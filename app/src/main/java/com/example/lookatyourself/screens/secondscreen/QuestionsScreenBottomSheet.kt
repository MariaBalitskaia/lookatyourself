package com.example.lookatyourself.screens.secondscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lookatyourself.ui.theme.LookAtYourselfTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionsScreenBottomSheet(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit = {},
    onMakePhotoClicked: () -> Unit,
    onChooseFromGalleryClicked: () -> Unit,
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        modifier = modifier
            .fillMaxSize(),
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        QuestionsScreenBottomSheetContent(
            onMakePhotoClicked = onMakePhotoClicked,
            onChooseFromGalleryClicked = onChooseFromGalleryClicked,
        )
    }
}

@Composable
private fun QuestionsScreenBottomSheetContent(
    onMakePhotoClicked: () -> Unit = {},
    onChooseFromGalleryClicked: () -> Unit = {},
) = Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 16.dp),
) {
    TextField(value = "qwerty", onValueChange = {})
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onMakePhotoClicked.invoke() }
            .padding(16.dp),
        text = "Сделать фото",
        style = LookAtYourselfTheme.typography.text1Medium,
    )
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onChooseFromGalleryClicked.invoke() }
            .padding(16.dp),
        text = "Выбрать из галереи",
        style = LookAtYourselfTheme.typography.text1Medium,
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuestionsScreenBottomSheetPreview() {
    QuestionsScreenBottomSheetContent()
}
