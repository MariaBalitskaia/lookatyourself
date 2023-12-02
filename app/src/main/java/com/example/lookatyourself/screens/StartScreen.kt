package com.example.lookatyourself.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lookatyourself.R
import com.example.lookatyourself.ui.theme.LookAtYourselfTheme

@Composable
fun StartScreen() {
    Scaffold(
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.systemBars),
        containerColor = LookAtYourselfTheme.colors.bgPrimary,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    Modifier.padding(10.dp)
                ) {
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
                        contentDescription = null
                    )
                }
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Крымский федеральный университет им. В.И. Вернадского (Медицинский институт)",
                    textAlign = TextAlign.Left,
                    style = LookAtYourselfTheme.typography.title4Bold
                )
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                style = LookAtYourselfTheme.typography.title0Semibold,
                color = colorResource(id = R.color.primary),
                text = "Посмотри на себя",)

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "С заботой о Вашем здоровье!",
                fontStyle = Italic,
            )


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                Image(
                    modifier = Modifier.size(500.dp),
                    painter = painterResource(id = R.drawable.pic_start_screen),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = null,
                )
            }
        }
    }
}

@Preview
@Composable
private fun StartScreenPreview() = LookAtYourselfTheme {
    StartScreen()
}