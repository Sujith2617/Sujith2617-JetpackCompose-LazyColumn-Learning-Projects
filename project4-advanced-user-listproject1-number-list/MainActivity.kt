
package com.example.listtaskb

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listtaskb.ui.theme.ListTaskBTheme

class MainActivity : ComponentActivity() {
    private val viewModel  by viewModels<UserDataViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen(viewModel)
        }
    }
}

@Composable
fun MainScreen(viewModel: UserDataViewModel){

    val context = LocalContext.current
    LazyColumn(modifier = Modifier.fillMaxSize().systemBarsPadding().padding(4.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp))
    {
        itemsIndexed(items = viewModel.users){index , user ->

            Card(modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(4.dp) ,
                colors = CardDefaults.cardColors(viewModel.cardColours(index)),
                onClick = {
                    Toast.makeText(context ,"You clicked on user ${user.name}" , Toast.LENGTH_SHORT).show()
                })
            {

                Row(modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(user.name, fontSize = 22.sp, fontWeight = FontWeight.Bold)

                    Text("${user.age} Year" , color = Color.Blue, fontSize = 20.sp)
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen(){
    MainScreen(viewModel = UserDataViewModel())
}
