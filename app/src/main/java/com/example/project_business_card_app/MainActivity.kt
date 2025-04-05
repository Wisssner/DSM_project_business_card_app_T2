package com.example.project_business_card_app

import android.media.Image
import android.media.ImageReader
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_business_card_app.ui.theme.Project_business_card_appTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material3.Icon


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project_business_card_appTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    BusinessCard(modifier = Modifier.padding(innerPadding) )

                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier=Modifier)
{
    Column (
        modifier=Modifier
            .fillMaxSize()
            .background(Color(0xFFBBDEFB))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        ProfileSection(
            name = "Wisner Valdiviezo",
            tittle = "Estudiante UNMSM",
            imageRes = R.drawable.wisneria
        )

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(12.dp))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally // Centrar contenido
        ) {
            ContactRow(Icons.Filled.Call, "+51 981 089 166")
            ContactRow(Icons.Filled.AccountCircle, "@wisnervg")
            ContactRow(Icons.Filled.Email, "wisnerva@gmail.com")

        }

    }

}

@Composable
fun ProfileSection(name:String,tittle: String,imageRes:Int,modifier: Modifier=Modifier) {

    Box(
        modifier = Modifier
//            .background(Color.LightGray, shape = RoundedCornerShape(12.dp))
            .padding(16.dp),
        contentAlignment = Alignment.Center,

    ) {
        Column(
            modifier = Modifier ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(50.dp))

            )

            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
            )
            Text(
                text = tittle,
                fontSize = 16.sp,
                modifier = modifier
            )
        }
    }
}




@Composable
fun ContactRow(
    iconRes: ImageVector,
    text: String,
    modifier: Modifier = Modifier)
{

    Row (
        modifier=Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment  = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
              // Ajusta el tamaño al contenido

    ) {
        Icon(
            imageVector = iconRes,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .weight(0.5f),
            tint = Color.Black,

        )
        Spacer(modifier = Modifier.width(16.dp)) // Espaciado entre el icono y el texto

        Text(
            text = text,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Start

        )




    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Project_business_card_appTheme {

        BusinessCard()
    }
}