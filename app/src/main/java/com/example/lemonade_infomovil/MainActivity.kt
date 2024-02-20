package com.example.lemonade_infomovil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade_infomovil.ui.theme.Lemonade_INFOMOVILTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lemonade_INFOMOVILTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        when(currentStep){
            1 -> {
                contenidoPantalla(
                    texto = R.string.cadena1,
                    imagen = R.drawable.lemon_tree,
                    descripcionImagen = R.string.cadena1,
                    onImageClick = {
                        currentStep = 2
                        squeezeCount = (2..4).random()
                    }
                )
            }
            2 -> {
                contenidoPantalla(
                    texto = R.string.cadena2,
                    imagen = R.drawable.lemon_squeeze,
                    descripcionImagen = R.string.cadena2,
                    onImageClick = {
                        squeezeCount--
                        if (squeezeCount == 0) {
                            currentStep = 3
                        }
                    }
                )
            }
            3 -> {
                contenidoPantalla(
                    texto = R.string.cadena3,
                    imagen = R.drawable.lemon_drink,
                    descripcionImagen = R.string.cadena3,
                    onImageClick = {
                        currentStep = 4
                    }
                )
            }
            4 -> {
                contenidoPantalla(
                    texto = R.string.cadena4,
                    imagen = R.drawable.lemon_restart,
                    descripcionImagen = R.string.cadena4,
                    onImageClick = {
                        currentStep = 1
                    }
                )
            }
        }
    }
}

@Composable
fun contenidoPantalla(
    texto : Int,
    imagen : Int,
    descripcionImagen : Int,
    onImageClick : () -> Unit,
    modifier : Modifier = Modifier
){
    Box(modifier = modifier){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ){
            Button(
                onClick = onImageClick,

            ){
                Image(
                    painter = painterResource(imagen),
                    contentDescription = stringResource(texto),
                    modifier = Modifier
                        .width(128.dp)
                        .height(160.dp)
                        .padding(24.dp)
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = stringResource(texto)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonPreview(modifier: Modifier = Modifier) {
    Lemonade_INFOMOVILTheme {
        LemonApp()
    }
}