package com.volchok.rickmorty.library.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.volchok.rickmorty.R

@Composable
fun CustomBottomBar(
    onHome: () -> Unit,
    onRockets: () -> Unit,
) {
    BottomNavigation(
        backgroundColor = CustomColors.accentPrimary
    ) {
        BottomBarItem(
            icon = R.drawable.ricki_con,
            selected = false,
            onClick = { onHome() },
            modifier = Modifier
                .size(CustomDimensions.sizeM)
        )
        BottomBarItem(
            icon = R.drawable.star_filed,
            selected = false,
            onClick = { onRockets() },
            modifier = Modifier
                .size(CustomDimensions.sizeM),
        )
    }
}

@Composable
private fun RowScope.BottomBarItem(
    icon: Int,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier
) {
    BottomNavigationItem(
        selected = selected,
        onClick = { onClick() },
        icon = {
            SpaceXIcon(
                icon = icon,
                contentDescription = null,
                tint = CustomColors.black,
                modifier = modifier
            )
        }
    )
}