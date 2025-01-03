package com.volchok.rickmorty.library.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volchok.rickmorty.library.ui.CustomColors.accentPrimary
import com.volchok.rickmorty.library.ui.CustomColors.chrome300
import com.volchok.rickmorty.library.ui.CustomColors.chrome700
import com.volchok.rickmorty.library.ui.CustomColors.white

@Composable
fun CustomPrimaryButton(
    text: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    CustomButton(
        onClick = onClick,
        modifier = modifier,
        text = text,
        enabled = enabled,
        border = null,
        colors = primaryColors()
    )
}

@Composable
fun CustomSecondaryButton(
    text: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    CustomButton(
        onClick = onClick,
        modifier = modifier,
        text = text,
        enabled = enabled,
        border = BorderStroke(2.dp, accentPrimary),
        colors = secondaryColors()
    )
}

@Composable
fun CustomActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    CustomButton(
        onClick = onClick,
        modifier = modifier,
        text = text,
        enabled = enabled,
        colors = actionColors(),
        border = null
    )
}

@Composable
private fun CustomButton(
    onClick: () -> Unit,
    modifier: Modifier,
    text: String?,
    enabled: Boolean,
    border: BorderStroke?,
    fullWidth: Boolean = true,
    colors: androidx.compose.material.ButtonColors,
) {

    Button(
        onClick = onClick,
        enabled = enabled,
        contentPadding = PaddingValues(0.dp),
        border = border,
        colors = colors,
        modifier = modifier
            .fillMaxWidth((if (fullWidth) 1.0f else 0.6f))
            .requiredHeight(40.dp),
        shape = CircleShape
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            text?.let {
                CustomText(
                    text = it,
                    style = MaterialTheme.typography.body2,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = colors.contentColor(enabled = enabled).value,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Composable
private fun primaryColors() = androidx.compose.material.ButtonDefaults.buttonColors(
    contentColor = white,
    disabledContentColor = chrome300,
    backgroundColor = accentPrimary,
    disabledBackgroundColor = chrome700

)

@Composable
private fun secondaryColors() = androidx.compose.material.ButtonDefaults.buttonColors(
    contentColor = accentPrimary,
    disabledContentColor = chrome300,
    backgroundColor = white,
    disabledBackgroundColor = chrome700
)

@Composable
private fun actionColors() = androidx.compose.material.ButtonDefaults.buttonColors(
    contentColor = accentPrimary,
    disabledContentColor = chrome300,
    backgroundColor = Color.Transparent,
    disabledBackgroundColor = Color.Transparent
)