package com.example.lookatyourself.screens.secondscreen

import android.Manifest
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.lookatyourself.App
import com.example.lookatyourself.Ext.rootElementSettings
import com.example.lookatyourself.R
import com.example.lookatyourself.SelfButton
import com.example.lookatyourself.navigation.MainScreens
import com.example.lookatyourself.ui.theme.LookAtYourselfTheme
import com.example.lookatyourself.views.AddPhotoView
import com.example.lookatyourself.views.PhotoFile
import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.TelegramFile
import com.github.kotlintelegrambot.entities.inputmedia.InputMediaDocument
import com.github.kotlintelegrambot.entities.inputmedia.MediaGroup
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun QuestionsScreen(
    navHostController: NavHostController,
) {
    val context = LocalContext.current
    var temporaryFile: File? by remember { mutableStateOf(null) }

    var value1 by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    var value3 by remember { mutableStateOf("") }
    var value4 by remember { mutableStateOf("") }
    var value5 by remember { mutableStateOf("") }
    var value6 by remember { mutableStateOf("") }
    var value7 by remember { mutableStateOf("") }
    var value8 by remember { mutableStateOf("") }
    var value9 by remember { mutableStateOf("") }
    var value10 by remember { mutableStateOf("") }
    var value11 by remember { mutableStateOf("") }
    var value12 by remember { mutableStateOf("") }
    var value13 by remember { mutableStateOf("") }
    var value14 by remember { mutableStateOf("") }
    var value15 by remember { mutableStateOf("") }
    var value16 by remember { mutableStateOf("") }
    var value17 by remember { mutableStateOf("") }
    val images = remember { mutableStateListOf<PhotoFile>() }
    val isButtonEnabled =
        value1.isNotEmpty() && value2.isNotEmpty() && value3.isNotEmpty() && value4.isNotEmpty() &&
            value5.isNotEmpty() && value6.isNotEmpty() && value7.isNotEmpty() && value8.isNotEmpty() &&
            value9.isNotEmpty() && value10.isNotEmpty() && value11.isNotEmpty() && value12.isNotEmpty() &&
            value13.isNotEmpty() && value14.isNotEmpty() && value15.isNotEmpty() && value16.isNotEmpty() &&
            value17.isNotEmpty() && images.size > 1

    val cameraLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.TakePicture(),
    ) {
        if (it) {
            images.add(
                PhotoFile(
                    image = BitmapFactory.decodeFile(temporaryFile?.path),
                    name = temporaryFile?.name ?: "",
                ),
            )
        }
        temporaryFile = null
    }

    val galleryLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetMultipleContents(),
    ) { uriList: List<Uri> ->
        val pickedImages = uriList.map { uri ->
            val item = context.contentResolver.openInputStream(uri)
            val bytes = item?.readBytes()
            item?.close()
            val bos = ByteArrayOutputStream()
            val bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes!!.size)
            bmp.compress(Bitmap.CompressFormat.JPEG, 50, bos)
            PhotoFile(
                image = bmp!!,
                name = File(uri.path).name,
            )
        }
        images.addAll(pickedImages)
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) {
        if (it) {
            temporaryFile = context.createImageFile()
            val uri = FileProvider.getUriForFile(
                context,
                "com.example.lookatyourself.provider",
                temporaryFile!!,
            )
            cameraLauncher.launch(uri)
        } else {
            Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }

    var isShowBottomSheet by remember { mutableStateOf(false) }

    if (isShowBottomSheet) {
        QuestionsScreenBottomSheet(
            onDismiss = {
                isShowBottomSheet = false
            },
            onMakePhotoClicked = {
                permissionLauncher.launch(Manifest.permission.CAMERA)
            },
            onChooseFromGalleryClicked = {
                galleryLauncher.launch("image/*")
            },
        )
    }

    Column(
        modifier = Modifier
            .rootElementSettings()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        Spacer(
            modifier = Modifier.height(10.dp),
        )
        Text(
            modifier = Modifier.padding(),
            text = stringResource(R.string.questions_screen_title),
            style = LookAtYourselfTheme.typography.title4Bold,
        )
        Spacer(
            modifier = Modifier.height(10.dp),
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value1,
            onValueChange = { value1 = it },
            label = { Text(stringResource(R.string.questions_screen_1)) },
            maxLines = 2,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value2,
            onValueChange = { value2 = it },
            label = { Text(stringResource(R.string.questions_screen_2)) },
            maxLines = 2,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value3,
            onValueChange = { value3 = it },
            label = { Text(stringResource(R.string.questions_screen_3)) },
            maxLines = 2,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value4,
            onValueChange = { value4 = it },
            label = { Text(stringResource(R.string.questions_screen_4)) },
            maxLines = 2,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value5,
            onValueChange = { value5 = it },
            label = { Text(stringResource(R.string.questions_screen_5)) },
            maxLines = 2,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value6,
            onValueChange = { value6 = it },
            label = { Text(stringResource(R.string.questions_screen_6)) },
            maxLines = 2,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value7,
            onValueChange = { value7 = it },
            label = { Text(stringResource(R.string.questions_screen_7)) },
            maxLines = 2,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value8,
            onValueChange = { value8 = it },
            label = { Text(stringResource(R.string.questions_screen_8)) },
            maxLines = 2,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value9,
            onValueChange = { value9 = it },
            label = { Text(stringResource(R.string.questions_screen_9)) },
            maxLines = 2,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value10,
            onValueChange = { value10 = it },
            label = { Text(stringResource(R.string.questions_screen_10)) },
            maxLines = 2,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value11,
            onValueChange = { value11 = it },
            label = { Text(stringResource(R.string.questions_screen_11)) },
            maxLines = 2,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value12,
            onValueChange = { value12 = it },
            label = { Text(stringResource(R.string.questions_screen_12)) },
            maxLines = 2,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value13,
            onValueChange = { value13 = it },
            label = { Text(stringResource(R.string.questions_screen_13)) },
            maxLines = 2,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value14,
            onValueChange = { value14 = it },
            label = { Text(stringResource(R.string.questions_screen_14)) },
            maxLines = 2,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value15,
            onValueChange = { value15 = it },
            label = { Text(stringResource(R.string.questions_screen_15)) },
            maxLines = 2,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value16,
            onValueChange = { value16 = it },
            label = { Text(stringResource(R.string.questions_screen_16)) },
            maxLines = 2,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value17,
            onValueChange = { value17 = it },
            label = { Text(stringResource(R.string.questions_screen_17)) },
            maxLines = 2,
        )

        AddPhotoView(
            title = "Загрузите несколько фотографий",
            onAddClicked = {
                isShowBottomSheet = true
                Log.d("Log", "SecondScreen : AddPhotoView onAddClicked")
            },
            onCloseClicked = { item ->
                images.removeIf {
                    it.id == item.id
                }
                Log.d("Log", "SecondScreen : AddPhotoView onCloseClicked ${item.id}")
            },
            items = images,
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.Center,
        ) {
            SelfButton(
                text = "Отправить данные",
                enabled = isButtonEnabled,
            ) {
                sendMessage(
                    message = "${context.getString(R.string.questions_screen_1)}: $value1\n" +
                        "${context.getString(R.string.questions_screen_2)}: $value2\n" +
                        "${context.getString(R.string.questions_screen_3)}: $value3\n" +
                        "${context.getString(R.string.questions_screen_4)}: $value4\n" +
                        "${context.getString(R.string.questions_screen_5)}: $value5\n" +
                        "${context.getString(R.string.questions_screen_6)}: $value6\n" +
                        "${context.getString(R.string.questions_screen_7)}: $value7\n" +
                        "${context.getString(R.string.questions_screen_8)}: $value8\n" +
                        "${context.getString(R.string.questions_screen_9)}: $value9\n" +
                        "${context.getString(R.string.questions_screen_10)}: $value10\n" +
                        "${context.getString(R.string.questions_screen_11)}: $value11\n" +
                        "${context.getString(R.string.questions_screen_12)}: $value12\n" +
                        "${context.getString(R.string.questions_screen_13)}: $value13\n" +
                        "${context.getString(R.string.questions_screen_14)}: $value14\n" +
                        "${context.getString(R.string.questions_screen_15)}: $value15\n" +
                        "${context.getString(R.string.questions_screen_16)}: $value16\n" +
                        "${context.getString(R.string.questions_screen_17)}: $value17\n",
                    images = images,
                    onSuccess = {
                        navHostController.popBackStack()
                        navHostController.navigate(MainScreens.StatusScreen.getComposableRoute())
                    },
                    onError = {
                    },
                )
            }
        }
        Spacer(
            modifier = Modifier.height(10.dp),
        )
    }
}

private fun Context.createImageFile(): File {
    // Create an image file name
    val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
    val imageFileName = "JPEG_" + timeStamp + "_"
    val image = File.createTempFile(
        imageFileName,
        ".jpg",
        externalCacheDir,
    )
    return image
}

private fun sendMessage(
    message: String,
    images: List<PhotoFile>,
    onSuccess: () -> Unit,
    onError: () -> Unit,
) {
    CoroutineScope(Dispatchers.IO).launch {
        val bot = bot {
            token = "6852699864:AAHBwV_LFBgGntUzrzkwPFFpjuRNia3menY"
        }
        val chatId = ChatId.fromId(-1002132265636)

        val inputMediaPhoto = images.mapIndexed { index, photoFile ->
            val file = photoFile.toFile()
            val telegramFile = TelegramFile.ByFile(file = file)
            InputMediaDocument(
                media = telegramFile,
            )
        }
        val messageDocument = InputMediaDocument(
            media = TelegramFile.ByFile(createTextFile(message)),
        )

        val mediaGroupResult = bot.sendMediaGroup(
            chatId = chatId,
            mediaGroup = MediaGroup.from(
                *inputMediaPhoto.toTypedArray(),
                messageDocument,
            ),
        )
        if (mediaGroupResult.isSuccess) {
            withContext(Dispatchers.Main) {
                onSuccess.invoke()
            }
            println("SUCCESS")
            // Удалось отправить (открыть статусный)
        } else {
            withContext(Dispatchers.Main) {
                onError.invoke()
            }
            println("ERROR $mediaGroupResult")
            // Не удалось отправить (попросить повторить)
        }
    }
}

fun PhotoFile.toFile(): File {
    val wrapper = ContextWrapper(App.shared)
    var file = wrapper.getDir("Images", Context.MODE_PRIVATE)
    file = File(file, "$name.jpg")
    val stream: OutputStream = FileOutputStream(file)
    image.compress(Bitmap.CompressFormat.JPEG, 90, stream)
    stream.flush()
    stream.close()
    return file
}

private fun createTextFile(message: String): File {
    val file = File(App.shared.externalCacheDir, "message.txt")
    file.printWriter().use { out ->
        out.println(message)
    }
    return file
}

@Composable
@Preview
private fun SecondScreenPreview() = LookAtYourselfTheme {
    QuestionsScreen(rememberNavController())
}
