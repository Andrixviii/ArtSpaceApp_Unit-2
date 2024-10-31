package lat.pam.artspaceapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

data class ArtWork(
    val imageResId: Int,
    val title: String,
    val artist: String,
    val year: Int
)

val artworks = listOf(
    ArtWork(R.drawable.image1, "Sailing Under the Bridge", "Kat Kuan", 2017),
    ArtWork(R.drawable.image2, "Sunset at the Lake", "Mas Faiz Jawir", 2020),
    ArtWork(R.drawable.image3, "Mountain Peaks", "Rusdi Ngawi", 2018)
)

@Composable
fun ArtGalleryApp() {
    var currentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = artworks[currentIndex].imageResId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .padding(8.dp)
        )

        Text(
            text = artworks[currentIndex].title,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "${artworks[currentIndex].artist} (${artworks[currentIndex].year})",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    if (currentIndex > 0) currentIndex--
                },
                enabled = currentIndex > 0
            ) {
                Text("Previous")
            }
            Button(
                onClick = {
                    if (currentIndex < artworks.size - 1) currentIndex++
                },
                enabled = currentIndex < artworks.size - 1
            ) {
                Text("Next")
            }
        }
    }
}