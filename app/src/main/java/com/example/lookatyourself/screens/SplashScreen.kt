package com.example.lookatyourself.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.lookatyourself.Ext.rootElementSettings
import com.example.lookatyourself.R
import com.example.lookatyourself.navigation.MainScreens
import com.example.lookatyourself.ui.theme.LookAtYourselfTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(
    navHostController: NavHostController,
) {
    Box(
        modifier = Modifier
            .rootElementSettings()
            .padding(16.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Image(
                    modifier = Modifier
                        .size(40.dp),
                    painter = painterResource(id = R.drawable.cfu_logo),
                    contentDescription = null,
                )
                Image(
                    modifier = Modifier
                        .size(40.dp),
                    painter = painterResource(id = R.drawable.cgmu_logo),
                    contentDescription = null,
                )
            }
            Text(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 10.dp),
                text = " Ордена Трудового Красного Знамени Медицинский институт им. С.И. Георгиевского",
                textAlign = TextAlign.Center,
                style = LookAtYourselfTheme.typography.title4Bold,
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Image(
                    modifier = Modifier
                        .size(300.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.pic_start_screen),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = null,
                )
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                style = LookAtYourselfTheme.typography.title0Bold,
                color = colorResource(id = R.color.primary),
                text = "Посмотри на себя!",
            )
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(
                    alignment = Alignment.BottomCenter,
                ),
            textAlign = TextAlign.Center,
            text = "С заботой о Вашем здоровье!",
            fontStyle = Italic,
        )
    }

    LaunchedEffect(key1 = Unit) {
        this.launch {
            delay(2000)
            navHostController.popBackStack()
            navHostController.navigate(MainScreens.OnboardingScreen.getComposableRoute())
        }
    }
}

@Preview
@Composable
private fun StartScreenPreview() = LookAtYourselfTheme {
    SplashScreen(rememberNavController())
}
