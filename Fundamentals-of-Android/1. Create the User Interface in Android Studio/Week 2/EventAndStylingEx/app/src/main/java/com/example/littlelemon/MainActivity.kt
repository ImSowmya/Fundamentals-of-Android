package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
            //Appscreen()
        }
    }
}


@Composable
fun HomeScreen(){
    val scaffoldState= rememberScaffoldState()
    val scope= rememberCoroutineScope()
    Scaffold(
        scaffoldState=scaffoldState,
        drawerContent = { DrawerPanel(scaffoldState = scaffoldState, scope =scope )},
        topBar = { TopAppBar(scaffoldState,scope)})
    {
        Column {
            UpperPanel()
            LowerPanel()
        }
    }
}

@Composable
fun Appscreen()
{
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    Counter(count,{ count += 1 },{ count -= 1 })
}

@Composable
fun Counter(count:Int,onIncrement: () -> Unit, onDecrement: () -> Unit){

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Card {
            Column (modifier = Modifier.padding(20.dp)){
                Text(text = "Greek Salad", fontWeight = FontWeight.W700,
                    fontSize = 30.sp)
                Row (modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically){
                    IconButton(onClick = { onDecrement()}) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Remove")
                    }
                    Text(text = count.toString(),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp))
                    IconButton(onClick = { onIncrement() }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                    }
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Add")                    
                }
            }
        }
    }
}
