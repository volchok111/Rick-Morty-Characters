package com.volchok.rickmorty.feature.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.volchok.rickmorty.R
import com.volchok.rickmorty.feature.home.presentation.HomeViewModel
import com.volchok.rickmorty.library.ui.CustomColors.backgroundsPrimary
import com.volchok.rickmorty.library.ui.CustomColors.black
import com.volchok.rickmorty.library.ui.CustomColors.chrome300
import com.volchok.rickmorty.library.ui.CustomDimensions.sizeS
import com.volchok.rickmorty.library.ui.CustomDimensions.sizeXS
import com.volchok.rickmorty.library.ui.CustomText
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen() {
    val viewModel = getViewModel<HomeViewModel>()
    val state = viewModel.states.collectAsState()

    HomeScreenImpl()
}

@Composable
private fun HomeScreenImpl() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundsPrimary)
            .padding(sizeXS)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.TopStart
        ) {
            CustomText(
                text = "Characters",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold
            )
        }

        Box {
            LazyColumn {
                items(10) { item ->
                    Spacer(modifier = Modifier.height(sizeXS))
                    ListItem(
                        modifier = Modifier
                            .clickable { }
                    )
                    Spacer(modifier = Modifier.height(sizeXS))
                }
            }
        }
    }
}

@Composable
private fun ListItem(
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(sizeXS),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .size(90.dp)
                    .padding(end = sizeS)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }
            Column {
                CustomText(
                    text = "Rick Sanchez",
                    style = MaterialTheme.typography.h5,
                    color = black,
                    fontWeight = FontWeight.Bold
                )
                CustomText(
                    text = "Alive",
                    style = MaterialTheme.typography.subtitle1,
                    color = chrome300
                )
            }
        }
    }
}
