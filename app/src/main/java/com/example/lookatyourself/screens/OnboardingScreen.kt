package com.example.lookatyourself.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lookatyourself.R
import com.example.lookatyourself.SelfButton
import com.example.lookatyourself.screens.Tags.TAG_ONBOARD_SCREEN_IMAGE_VIEW
import com.example.lookatyourself.screens.Tags.TAG_ONBOARD_SCREEN_NAV_BUTTON
import com.example.lookatyourself.screens.Tags.TAG_ONBOARD_TAG_ROW
import com.example.lookatyourself.ui.theme.LookAtYourselfTheme

val onboardPagesList = listOf(
    OnboardPage(
        imageRes = R.drawable.pic_onboarding1,
        title = R.string.onboarding_screen1_title,
        description = R.string.onboarding_screen1_text
    ), OnboardPage(
        imageRes = R.drawable.pic_onboarding2,
        title = R.string.onboarding_screen2_title,
        description = R.string.onboarding_screen2_text
    ), OnboardPage(
        imageRes = R.drawable.pic_onboarding3,
        title = R.string.onboarding_screen3_title,
        description = R.string.onboarding_screen3_text
    ), OnboardPage(
        imageRes = R.drawable.pic_onboarding4,
        title =  R.string.onboarding_screen4_title,
        description = R.string.onboarding_screen4_text
    )
)

object Tags {
    const val TAG_ONBOARD_SCREEN = "onboard_screen"
    const val TAG_ONBOARD_SCREEN_IMAGE_VIEW = "onboard_screen_image"
    const val TAG_ONBOARD_SCREEN_NAV_BUTTON = "nav_button"
    const val TAG_ONBOARD_TAG_ROW = "tag_row"
}


@Composable
fun OnboardScreen() {

    val onboardPages = onboardPagesList

    val currentPage = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag(Tags.TAG_ONBOARD_SCREEN)
    ) {

        OnBoardImageView(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            currentPage = onboardPages[currentPage.value]
        )

        OnBoardDetails(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            currentPage = onboardPages[currentPage.value]
        )

        OnBoardNavButton(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            currentPage = currentPage.value,
            noOfPages = onboardPages.size
        ) {
            currentPage.value++
        }

        TabSelector(
            onboardPages = onboardPages,
            currentPage = currentPage.value
        ) { index ->
            currentPage.value = index
        }
    }
}

@Composable
fun OnBoardDetails(
    modifier: Modifier = Modifier,
    currentPage: OnboardPage,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState()),
    ) {
        Text(
            text = stringResource(currentPage.title),
            style = LookAtYourselfTheme.typography.title0Semibold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(currentPage.description),
            style = LookAtYourselfTheme.typography.text2Regular,
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun OnBoardNavButton(
    modifier: Modifier = Modifier,
    currentPage: Int,
    noOfPages: Int,
    onNextClicked: () -> Unit,
) = Box(
    modifier = modifier,
) {
    SelfButton(
        modifier = Modifier.testTag(TAG_ONBOARD_SCREEN_NAV_BUTTON),
        text = if (currentPage < noOfPages - 1) "Далее" else "Начать",
        onClick = {
            if (currentPage < noOfPages - 1) {
                onNextClicked()
            } else {
                // Handle onboarding completion
            }
        }
    )
}


@Composable
fun OnBoardImageView(
    modifier: Modifier = Modifier,
    currentPage: OnboardPage,
) {
    val imageRes = currentPage.imageRes
    Column(
        modifier = modifier
            .testTag(TAG_ONBOARD_SCREEN_IMAGE_VIEW + currentPage.title)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun TabSelector(
    onboardPages: List<OnboardPage>,
    currentPage: Int,
    onTabSelected: (Int) -> Unit
) {
    TabRow(
        selectedTabIndex = currentPage,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .testTag(TAG_ONBOARD_TAG_ROW)

    ) {
        onboardPages.forEachIndexed { index, _ ->
            Tab(
                modifier = Modifier.padding(16.dp),
                selected = index == currentPage,
                onClick = {
                onTabSelected(index)
            },
                content = {
                Box(
                    modifier = Modifier
                        .testTag("$TAG_ONBOARD_TAG_ROW$index")
                        .size(8.dp)
                        .background(
                            color = if (index == currentPage) MaterialTheme.colorScheme.onPrimary
                            else Color.LightGray, shape = RoundedCornerShape(4.dp)
                        )
                )
            })
        }
    }
}

data class OnboardPage(
    val imageRes: Int,
    val title: Int,
    val description: Int
)

@Preview
@Composable
fun PreviewOnboardScreen() {
    LookAtYourselfTheme {
        Surface {
            OnboardScreen()
        }
    }
}