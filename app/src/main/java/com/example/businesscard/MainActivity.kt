package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
fun PersonalInfo(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        val image = painterResource(R.drawable.android_logo)
        val aspectRatio = image.intrinsicSize.width / image.intrinsicSize.height
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .weight(1f, fill = false)
                .height(70.dp)
                .width(70.dp)
                .aspectRatio(aspectRatio)
                .fillMaxWidth()
                .background(Color.Black),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Phillip Wray",
            color = Color.DarkGray,
            fontSize = 48.sp
        )
        Text(
            text = "Director",
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.android_green),
            fontSize = 20.sp
        )
    }
}

@Composable
fun PhoneInfo(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier.padding(start = 30.dp)
    ) {
        val callContactInfoImage = painterResource(R.drawable.call_contact_info)
//        Image(painter = callContactInfoImage, contentDescription = null)
        Icon(painter = callContactInfoImage, contentDescription = null, tint = colorResource(R.color.android_green))
        Text(
            text = "+1 (403) 970-2757",
            fontWeight = FontWeight.Normal,
            color = Color.DarkGray,
            fontSize = 16.sp,
            modifier = modifier.padding(start = 4.dp)
        )

    }
}

@Composable
fun SocialMediaInfo(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier.padding(start = 30.dp)
    ) {
        val socialMediaContactInfoImage = painterResource(R.drawable.share_contact_info)
//        Image(painter = socialMediaContactInfoImage, contentDescription = null)
        Icon(painter = socialMediaContactInfoImage, contentDescription = null, tint = colorResource(R.color.android_green))
        Text(
            text = "@KotlinLearner",
            fontWeight = FontWeight.Normal,
            color = Color.DarkGray,
            fontSize = 16.sp,
            modifier = modifier.padding(start = 4.dp)
        )

    }
}

@Composable
fun MailInfo(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier.padding(start = 30.dp)
    ) {
        val mailContactInfoImage = painterResource(R.drawable.mail_contact_info)
//        Image(painter = callContactInfoImage, contentDescription = null)
        Icon(painter = mailContactInfoImage, contentDescription = null, tint = colorResource(R.color.android_green))
        Text(
            text = "phillip.j.wray.esq@gmail.com",
            fontWeight = FontWeight.Normal,
            color = Color.DarkGray,
            fontSize = 16.sp,
            modifier = modifier.padding(start = 4.dp)
        )

    }
}

@Composable
fun ContactInfo(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = modifier
    ) {
        PhoneInfo(modifier)
        SocialMediaInfo(modifier)
        MailInfo(modifier)
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier.fillMaxSize().padding(bottom = 24.dp)
    ) {
        PersonalInfo(modifier)
        Spacer(modifier.padding(top = 210.dp))
        ContactInfo(modifier.padding(bottom = 8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
//        Greeting("Android")
//        PersonalInfo(modifier = Modifier)
//        ContactInfo(modifier = Modifier)
//        PhoneInfo(modifier = Modifier)
        BusinessCard(modifier = Modifier)
    }
}