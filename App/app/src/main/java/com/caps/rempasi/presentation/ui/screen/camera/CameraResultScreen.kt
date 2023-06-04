package com.caps.rempasi.presentation.ui.screen.camera

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.caps.rempasi.R
import com.caps.rempasi.presentation.ui.components.ActionCameraButton
import com.caps.rempasi.presentation.ui.components.ButtonLeadingIcon
import com.caps.rempasi.presentation.ui.components.CaptureGuideline
import com.caps.rempasi.presentation.ui.screen.SharedCameraResultViewModel

@Composable
fun CameraResultScreen(
    sharedViewModel: SharedCameraResultViewModel,
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
) {
    val imageResult = sharedViewModel.imageResult

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = rememberAsyncImagePainter(imageResult?.imageUri),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(3f / 4f)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                ActionCameraButton(
                    icon = R.drawable.close,
                    contentDescription = "Kembali"
                ) {
                    navigateBack()
                }
            }
        }
        CaptureGuideline()
        Spacer(modifier = Modifier.height(16.dp))
        ButtonLeadingIcon(textTitle = "Temukan Resep", icon = R.drawable.find_recipe) {

        }
    }
}