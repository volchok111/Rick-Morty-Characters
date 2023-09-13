package com.volchok.rickmorty.library.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.volchok.rickmorty.library.ui.CustomColors.black
import com.volchok.rickmorty.library.ui.CustomColors.white
import com.volchok.rickmorty.library.ui.CustomColors.accentPrimary

@Composable
fun CustomAlertDialog(
    title: String,
    onDismiss: () -> Unit,
    positiveButtonText: String,
    modifier: Modifier = Modifier,
    onPositiveButtonClick: () -> Unit = onDismiss,
    message: String? = null,
    negativeButtonText: String? = null,
    onNegativeButtonClick: (() -> Unit) = onDismiss,
    neutralButtonText: String? = null,
    onNeutralButtonClick: (() -> Unit) = onDismiss,
    dialogProperties: DialogProperties = DialogProperties()
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = dialogProperties,

        ) {
        Surface(
            modifier = modifier,
            shape = RoundedCornerShape(CustomDimensions.sizeXXS),
            color = white,
            contentColor = black
        ) {
            Column(
                modifier = Modifier.padding(CustomDimensions.sizeXS)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .padding(CustomDimensions.sizeS)
                )
                if (!message.isNullOrEmpty()) {
                    Text(
                        text = message,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(CustomDimensions.sizeS)
                    )
                }
                Spacer(modifier = Modifier.height(CustomDimensions.sizeXS))
                Row {
                    neutralButtonText?.let {
                        SpaceXActionButton(
                            text = it,
                            onClick = onNeutralButtonClick
                        )
                    }
                    Spacer(Modifier.weight(1f))
                    negativeButtonText?.let {
                        SpaceXActionButton(
                            text = it,
                            onClick = onNegativeButtonClick
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = CustomDimensions.sizeXXS),
                        contentAlignment = BottomEnd
                    ) {
                        CustomText(
                            text = positiveButtonText,
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier
                                .clickable { onPositiveButtonClick() }
                                .padding(end = CustomDimensions.sizeXS),
                            color = accentPrimary,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(CustomDimensions.sizeXXS))
            }
        }
    }
}

@Composable
fun CustomLoadingDialog(
    title: String,
    modifier: Modifier = Modifier,
    text: String? = null,
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        shape = RoundedCornerShape(CustomDimensions.sizeS),
        color = white,
        contentColor = black
    ) {
        Column(
            modifier = Modifier.padding(CustomDimensions.sizeM)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h2
            )
            if (!text.isNullOrEmpty()) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(top = CustomDimensions.sizeL)
                )
            }
        }
    }
}