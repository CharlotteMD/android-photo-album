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
import androidx.compose.runtime.Composable
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
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtBox()
        Spacer(modifier = Modifier.height(24.dp))
        ArtistCredentials()
        Spacer(modifier = Modifier.height(16.dp))
        NavigationButtons()
    }
}

@Composable
fun ArtBox() {
    Column(
        modifier = Modifier
            .padding(8.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.beach),
            contentDescription = "Beach",
            modifier = Modifier
                .fillMaxWidth()
                .border(4.dp, Color.Gray)
                .padding(8.dp)
                .height(200.dp),
            contentScale = ContentScale.Crop,
        )
    }

}

@Composable
fun ArtistCredentials() {
    Column(
        modifier = Modifier
            .border(2.dp, Color.LightGray)
            .padding(8.dp, 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Painting Name",
            fontStyle = FontStyle.Italic,
            color = Color.DarkGray,
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

@Composable
fun NavigationButtons() {
    Row() {
        Button(
            onClick = { /*TODO*/ },
            Modifier.width(120.dp)
        ) {
            Text("Previous")
        }
        Spacer(modifier = Modifier.width(16.dp))
        Button(
            onClick = { /*TODO*/ },
            Modifier.width(120.dp)
        ) {
            Text("Next")
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ScreenLayout()
    }
}