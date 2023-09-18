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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.volchok.rickmorty.feature.home.presentation.HomeViewModel
import com.volchok.rickmorty.library.ui.CustomColors.backgroundsPrimary
import com.volchok.rickmorty.library.ui.CustomColors.black
import com.volchok.rickmorty.library.ui.CustomColors.chrome300
import com.volchok.rickmorty.library.ui.CustomDimensions
import com.volchok.rickmorty.library.ui.CustomDimensions.sizeS
import com.volchok.rickmorty.library.ui.CustomDimensions.sizeXS
import com.volchok.rickmorty.library.ui.CustomLoadingDialog
import com.volchok.rickmorty.library.ui.CustomText
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen() {
    val viewModel = getViewModel<HomeViewModel>()
    val state = viewModel.states.collectAsState()

    HomeScreenImpl(
        state = state.value,
        viewModel::onItem
    )
}

@Composable
private fun HomeScreenImpl(
    state: HomeViewModel.State,
    onItem: (Int) -> Unit
) {
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
                items(state.characters) { item ->
                    Spacer(modifier = Modifier.height(sizeXS))
                    ListItem(
                        modifier = Modifier
                            .clickable { item.id?.let { onItem(it) } },
                        item = item
                    )
                    Spacer(modifier = Modifier.height(sizeXS))
                }
            }
        }
    }
    if (state.loading) {
        CustomLoadingDialog(title = "")
    }
}

@Composable
private fun ListItem(
    modifier: Modifier = Modifier,
    item: HomeViewModel.State.CharacterItem
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp),
        elevation = CustomDimensions.sizeXXS
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
                    painter = rememberAsyncImagePainter(model = item.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }
            Column {
                CustomText(
                    text = item.name.orEmpty(),
                    style = MaterialTheme.typography.h6,
                    color = black,
                    fontWeight = FontWeight.Bold
                )
                CustomText(
                    text = item.status.orEmpty(),
                    style = MaterialTheme.typography.subtitle1,
                    color = chrome300
                )
            }
        }
    }
}
