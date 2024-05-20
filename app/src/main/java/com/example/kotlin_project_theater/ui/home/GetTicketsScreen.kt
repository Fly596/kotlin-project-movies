package com.example.kotlin_project_theater.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin_project_theater.R

@Composable
fun GetTicketsScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            ,
    ) {
        item {
            MovieTitle()
            HorizontalDivider(Modifier.padding(vertical = 16.dp))
        }
    }
}

@Composable
fun MovieTitle(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxWidth().padding(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.the_neon_demon_2016),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier =
            Modifier
                .clip(shape = androidx.compose.foundation.shape.CircleShape)
                .size(64.dp)
        )
        Text(text = "The Neon Demon", style = MaterialTheme.typography.headlineLarge)

    }
}

@Preview(
    name = "HomeScreen",
    device = "id:pixel_8",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    showSystemUi = true,
    showBackground = false,
    backgroundColor = 0xFF292929
)
@Composable
private fun PreviewGetTicketsScreen() {
    GetTicketsScreen()
}
