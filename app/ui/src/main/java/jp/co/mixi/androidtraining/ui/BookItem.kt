package jp.co.mixi.androidtraining.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BookItem(
    book: Book,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = book.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = book.author,
                fontSize = 16.sp
            )
        }
        Button(onClick = { }) {
            Text(text = stringResource(R.string.read))
        }
    }
}

@Preview
@Composable
private fun BookItemPreview() {
    MaterialTheme {
        BookItem(
            book = Book(
                title = "吾輩は猫である",
                author = "夏目漱石"
            )
        )
    }
}
