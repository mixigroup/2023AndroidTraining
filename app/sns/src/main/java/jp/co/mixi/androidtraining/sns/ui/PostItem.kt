package jp.co.mixi.androidtraining.sns.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import jp.co.mixi.androidtraining.sns.data.entity.Post
import jp.co.mixi.androidtraining.sns.data.entity.User

@Composable
fun PostItem(
    post: Post,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AsyncImage(
            model = post.author.photoUrl,
            contentDescription = post.author.name,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape),
            placeholder = ColorPainter(MaterialTheme.colorScheme.surfaceVariant),
            error = ColorPainter(MaterialTheme.colorScheme.surfaceVariant)
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = post.author.name,
                fontWeight = FontWeight.Bold
            )
            Text(text = post.content)
        }
    }
}

@Preview
@Composable
private fun PostItemPreview() {
    MaterialTheme {
        PostItem(
            post = Post(
                author = User(
                    name = "User Name",
                    photoUrl = ""
                ),
                content = "Content"
            )
        )
    }
}
