package com.example.lookatyourself.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.lookatyourself.R
import com.example.lookatyourself.ui.theme.LookAtYourselfTheme

@Composable
fun StatusScreen(navHostController: NavHostController) {
    Scaffold(
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.systemBars),
        containerColor = LookAtYourselfTheme.colors.bgPrimary,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Image(
                    modifier = Modifier
                        .size(100.dp)
                        .align(alignment = Alignment.Center),
                    painter = painterResource(id = R.drawable.pic_done_status_screen),
                    contentDescription = null,
                )
            }
            Spacer(
                modifier = Modifier
                    .height(16.dp),
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.status_screen_text),
                textAlign = TextAlign.Center,
                style = LookAtYourselfTheme.typography.title4Bold,
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp),
            )
            Button(
                onClick = {
                    navHostController.popBackStack()
                },
            ) {
                Text(text = "Хорошо")
            }
        }
    }
}

@Preview
@Composable
private fun StatusScreenPreview() = LookAtYourselfTheme {
    StatusScreen(rememberNavController())
}
