
package com.example.lazycolumntext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazycolumntext.ui.theme.LazyColumnTextTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<LogicViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           MainScreenListDisplay(viewModel)
        }
    }
}

@Composable
fun MainScreenListDisplay(viewModel: LogicViewModel){




    LazyColumn(modifier = Modifier.fillMaxSize().systemBarsPadding()) {

        items(viewModel.textList){  text  ->

            Card(modifier = Modifier.fillMaxWidth().padding(6.dp).height(56.dp),
                colors = CardDefaults.cardColors(   Color(0xFF7299AB)) ,
                elevation = CardDefaults.cardElevation(4.dp)) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(text, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }

            }

        }
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreenListDisplay() {
    MainScreenListDisplay(viewModel = LogicViewModel())
}
