package com.example.lookatyourself.views

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.example.lookatyourself.R
import com.example.lookatyourself.ui.theme.LookAtYourselfTheme
import java.util.UUID

@Composable
fun AddPhotoView(
    title: String,
    onAddClicked: () -> Unit,
    onCloseClicked: (PhotoFile) -> Unit,
    items: List<PhotoFile>,
) {
    Column {
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Text(
            modifier = Modifier,
            text = title,
            style = LookAtYourselfTheme.typography.text1Semibold,
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            item {
                AddPhotoViewAdd(
                    onClick = onAddClicked,
                )
            }
            items(
                items = items,
                itemContent = { item ->
                    AddPhotoViewPhoto(
                        item = item,
                        onCloseClicked = onCloseClicked,
                    )
                }
            )
        }
    }
}

@Composable
private fun AddPhotoViewAdd(
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(
                end = 16.dp,
            )
            .size(84.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(LookAtYourselfTheme.colors.bgPrimaryGrey)
            .clickable {
                onClick.invoke()
            },
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painter = painterResource(
                id = R.drawable.ic_40dp_actions_plus,
            ),
            contentDescription = null,
        )
    }
}

@Composable
private fun AddPhotoViewPhoto(
    item: PhotoFile,
    onCloseClicked: (PhotoFile) -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(
                end = 16.dp,
            ),
    ) {
        Column(
            modifier = Modifier
                .width(84.dp),
            content = {
                Box(

                    modifier = Modifier
                        .size(84.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    content = {
                        Image(
                            bitmap = item.image.asImageBitmap(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                        Icon(
                            modifier = Modifier
                                .padding(
                                    top = 4.dp,
                                    end = 4.dp,
                                )
                                .align(Alignment.TopEnd)
                                .clickable {
                                    onCloseClicked.invoke(item)
                                },
                            painter = painterResource(
                                id = R.drawable.ic_16dp_system_close,
                            ),
                            contentDescription = null,
                        )
                    }
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    text = item.name,
                    style = LookAtYourselfTheme.typography.caption2Medium,
                    color = LookAtYourselfTheme.colors.textSecondary,
                    maxLines = 1,
                    textAlign = TextAlign.Center,
                )
            }
        )
    }
}

@Composable
@Preview
private fun AddPhotoViewPreview() = LookAtYourselfTheme {
    val bitmap = ContextCompat.getDrawable(LocalContext.current, R.drawable.cfu_logo)?.toBitmap()!!
    AddPhotoView(
        title = "Загрузить фотографию",
        onAddClicked = {

        },
        onCloseClicked = {

        },
        items = listOf(
            PhotoFile(
                image = bitmap,
                name = "testname"
            ),
            PhotoFile(
                image = bitmap,
                name = "testname"
            ),
            PhotoFile(
                image = bitmap,
                name = "testname"
            ),
            PhotoFile(
                image = bitmap,
                name = "testname"
            ),
        ),
    )
}

data class PhotoFile(
    val id: String = UUID.randomUUID().toString(),
    val image: Bitmap,
    val name: String,
)



