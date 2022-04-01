package com.example.composelinearprogressbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelinearprogressbar.ui.theme.ComposeLinearProgressBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLinearProgressBarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.LightGray
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")

    Card(modifier = Modifier
        .wrapContentSize()
        .fillMaxWidth()
        .padding(20.dp)
        .clickable {  }) {
        SampleCard()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeLinearProgressBarTheme {
        Greeting("Android")
    }
}

@Composable
fun SampleCard() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Column {
            Text("Sample Card")
            Row(
                modifier = Modifier.padding(top = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .background(color = Color.Gray)
                        .padding(horizontal = 8.dp, vertical = 6.dp),
                    horizontalArrangement = Arrangement.End,
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        contentDescription = null
                    )
                    Text("Done")
                }
                Spacer(modifier = Modifier.padding(end = 16.dp))
                Row(
                    modifier = Modifier.semantics(mergeDescendants = true) {
                        contentDescription = "Progress 50%"
                    },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    LinearProgressIndicator(
                        progress = 0.5f,
                        color = Color.Black,
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .width(40.dp)
                            .height(6.dp),
                    )
                    Text(
                        text = "10%",
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
        }
    }
}