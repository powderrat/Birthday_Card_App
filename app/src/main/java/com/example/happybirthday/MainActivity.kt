package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BackgroundImage()
                   NameTitle(
                        name = "Michael Kidwell",
                        title = "For All Your Coding Needs",
                        modifier = Modifier.padding(8.dp))

                    ContactMethods(phoneNumber = "3522159575",
                        email = "mt_kidwell@yahoo.com",
                        github = "@powderrat")


                }
            }

        }
    }
}
@Composable
fun NameTitle(name: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.icon_business_card)
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = image,
            contentDescription = "logo",
            modifier = Modifier.size((120.dp))
        )
        Text(
            text = name,
            fontSize = 54.sp,
            lineHeight = 58.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = title,
            fontSize = 24.sp,
            lineHeight = 5.sp,
            modifier = Modifier
        )
    }
}

@Composable
fun ContactMethods(phoneNumber: String, email: String, github: String, modifier: Modifier = Modifier){
    val textMod = Modifier.padding(6.dp)
    val image = painterResource(R.drawable.github_mark_white)
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(
            text = phoneNumber,
            modifier = textMod
        )
        Text(
            text = email,
            modifier = textMod
        )
        Row {

            Image(
                painter = image,
                contentDescription = "github",
                modifier = Modifier.size((25.dp)),

                )
            Text(
                text = github,
                modifier = textMod
                    .padding(bottom = 25.dp)
            )
        }
    }
}

@Composable
fun BackgroundImage(modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.business_card_background)

    Image(
        painter = image,
        contentDescription = "Background",
        contentScale = ContentScale.Crop,
        alpha = 0.5F,
        modifier = Modifier.fillMaxSize()
    )
}
@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    HappyBirthdayTheme {
        BackgroundImage()
        NameTitle(name = "Michael Kidwell", title = "For All Your Coding Needs")
        ContactMethods(phoneNumber = "3522159575",
            email = "mt_kidwell@yahoo.com",
            github = "@powderrat")
    }
}