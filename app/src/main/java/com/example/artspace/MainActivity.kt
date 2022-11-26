package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import com.example.artspace.ui.theme.Purple200
import com.example.artspace.ui.theme.Purple700

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScreenLayout()
                }
            }
        }
    }
}

@Composable
fun ScreenLayout() {

    var result by remember { mutableStateOf(1) }

    fun nextPicture() {
        if (result < 3) result++ else result = 1
    }

    fun prevPicture() {
        if (result in 2..3) result-- else result = 3
    }

    val imageResource: Int = when(result) {
        1 -> R.drawable.beach
        2 -> R.drawable.balcony
        3 -> R.drawable.sisters
        else -> R.drawable.ic_launcher_foreground
    }

    val textContent = when(result) {
        1 -> "The Beach"
        2 -> "View from our balcony"
        3 -> "Sisters"
        else -> "That's all"
    }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtBox(imageResource)
        Spacer(modifier = Modifier.height(24.dp))
        ArtistCredentials(textContent)
        Spacer(modifier = Modifier.height(16.dp))

        Row() {
            Button(
                onClick = { prevPicture() },
                Modifier.width(120.dp)
            ) {
                Text("Previous")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { nextPicture() },
                Modifier.width(120.dp)
            ) {
                Text("Next")
            }
        }

        Text(text = "$result")
    }
}

@Composable
fun ArtBox(
    imageResource: Int
) {
    Column(
        modifier = Modifier
            .padding(8.dp),
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = "Beach",
            modifier = Modifier
                .fillMaxWidth()
                .border(4.dp, Purple200)
                .padding(8.dp)
                .height(200.dp),
            contentScale = ContentScale.Crop,
        )
    }

}

@Composable
fun ArtistCredentials(
    textContent: String
) {
    Column(
        modifier = Modifier
            .border(2.dp, Color.LightGray)
            .padding(8.dp, 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = textContent,
            fontStyle = FontStyle.Italic,
            color = Purple700,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Artist Credentials",
            fontSize = 16.sp
        )
        Text(
            text = "Year created",
            fontSize = 12.sp
        )
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ScreenLayout()
    }
}