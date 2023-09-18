package com.volchok.rickmorty.feature.details.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.volchok.rickmorty.feature.details.presentation.DetailsViewModel
import com.volchok.rickmorty.library.ui.CustomColors
import com.volchok.rickmorty.library.ui.CustomDimensions
import com.volchok.rickmorty.library.ui.CustomLoadingDialog
import com.volchok.rickmorty.library.ui.CustomText
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailsScreen() {
    val viewModel = getViewModel<DetailsViewModel>()
    val state = viewModel.states.collectAsState()

    DetailsScreenImpl(
        state = state.value
    )
}

@Composable
private fun DetailsScreenImpl(
    state: DetailsViewModel.State
) {
    //TODO: Add Top Bar
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(CustomColors.backgroundsPrimary)
            .padding(CustomDimensions.sizeXS),
        elevation = CustomDimensions.sizeXXS
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(CustomDimensions.sizeS)
            ) {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .size(150.dp)
                        .padding(end = CustomDimensions.sizeS)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(model = state.character?.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(start = CustomDimensions.sizeXS)
                ) {
                    CustomText(
                        text = "Name",
                        style = MaterialTheme.typography.subtitle1,
                        color = CustomColors.chrome600,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(CustomDimensions.sizeS))

                    CustomText(
                        text = state.character?.name.orEmpty(),
                        style = MaterialTheme.typography.h5,
                        color = CustomColors.black,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Divider(color = CustomColors.chrome50, thickness = 1.dp)

            Column(
                modifier = Modifier
                    .padding(CustomDimensions.sizeS)
            ) {
                InfoItem(subTitle = "Status", title = state.character?.status.orEmpty())
                InfoItem(subTitle = "Species", title = state.character?.species.orEmpty())
                InfoItem(
                    subTitle = "Type",
                    title = if (state.character?.type?.isEmpty() == true) "-" else state.character?.type.orEmpty()
                )
                InfoItem(subTitle = "Gender", title = state.character?.gender.orEmpty())
                InfoItem(subTitle = "Origin", title = state.character?.origin?.name.orEmpty())
                InfoItem(subTitle = "Location", title = state.character?.location?.name.orEmpty())
            }
        }
    }
    if (state.loading) {
        CustomLoadingDialog(title = "")
    }
}

@Composable
private fun InfoItem(
    subTitle: String,
    title: String
) {
    CustomText(
        text = subTitle,
        style = MaterialTheme.typography.subtitle1,
        color = CustomColors.chrome600
    )
    CustomText(
        text = title,
        style = MaterialTheme.typography.h6,
        color = CustomColors.black,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(CustomDimensions.sizeL))
}
