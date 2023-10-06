package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Little Lemon",
                    color= Color(0xfff4ce14),
                    fontSize = 32.sp)
                Text(text = stringResource(id = R.string.chicago),
                    color= Color(0xfff4ce14),
                    fontSize = 32.sp)
                Row {
                    Button(onClick = { /*TODO*/ },
                        border= BorderStroke(1.dp,Color.Red),
                        shape= RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(Color.Gray)
                    ) {
                        Text(text= stringResource(id = R.string.order))
                    }
                    //Image(painter = painterResource(id = R.drawable.restaurantfoodb), contentDescription = )
                }
            }

        }
    }
}