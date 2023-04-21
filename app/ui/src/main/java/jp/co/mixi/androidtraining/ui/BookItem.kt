package jp.co.mixi.androidtraining.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BookItem(
    book: Book,
    modifier: Modifier = Modifier
) {
    // TODO 演習 3.1
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
