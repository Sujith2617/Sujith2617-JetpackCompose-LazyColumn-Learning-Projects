package com.example.simplenumberlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreenLazyList()
        }
    }
}


@Composable
fun MainScreenLazyList()
{
    val list = (1..100).toList()

    LazyColumn( modifier = Modifier.fillMaxSize()
        .systemBarsPadding()
        .padding(6.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp))
    {
        items(items = list,
            key = {it})
        { num ->
            Card(modifier = Modifier.fillMaxWidth().height(56.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF7299AB))
            )
            {
                Box(contentAlignment = Alignment.CenterStart,
                    modifier = Modifier.padding(start = 16.dp).height(60.dp))
                {
                    Text("$num",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold)
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen(){
    MainScreenLazyList()
}
