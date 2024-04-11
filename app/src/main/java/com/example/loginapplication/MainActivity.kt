package com.example.loginapplication

import android.os.Bundle
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.ModifierLocal
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginapplication.ui.theme.LoginApplicationTheme
import javax.security.auth.login.LoginException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginUi()
                }
            }
        }
    }
}
@Preview
@Composable
fun LoginUi() {
    val context = LocalContext.current
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    Column {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text  = "Welcome to the LoginPage",
            fontSize = 26.sp,
            modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(40.dp))
        Image(painter = painterResource(id = R.drawable.login), contentDescription = "",
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
            )
        Spacer(modifier = Modifier.height(40.dp))
        OutlinedTextField(value = email.value, onValueChange ={email.value = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
        placeholder = {
            Text(text = "Email")
        })
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value = password.value, onValueChange ={password.value = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            placeholder = {
                Text(text = "Password")
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(onClick = {
            Toast.makeText(context, "You Have Logged in successfully", Toast.LENGTH_SHORT).show()
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            ) {
            Text(text = "LOGIN")

            
        }
    }

}
//
//@Preview()
//@Composable
//private fun Preview() {
//    LoginUi()
//}
