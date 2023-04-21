package jp.co.mixi.androidtraining.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UiScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        CustomText(text = "Custom text")
        Divider()

        PaddingText(text = "Padding text")
        Divider()

        LoginButton(onClick = { /* クリックしたときの処理 */ })
        Divider()

        TextColumn1(modifier = Modifier.fillMaxWidth())
        Divider()

        TextColumn2(modifier = Modifier.fillMaxWidth())
        Divider()

        TextRow()
        Divider()

        val book = Book(title = "吾輩は猫である", author = "夏目漱石")
        BookItem(book = book)
        Divider()
    }
}

@Composable
private fun CustomText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier,
        color = Color.Red,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun PaddingText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
private fun LoginButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(text = "Login")
    }
}

@Composable
private fun TextColumn1(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Top")
        Text(text = "Center")
        Text(text = "Bottom")
    }
}

@Composable
private fun TextColumn2(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Top")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Center")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Bottom")
    }
}

@Composable
private fun TextRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Left")
        Text(text = "Center")
        Text(text = "Right")
    }
}

@Preview
@Composable
private fun UiScreenPreview() {
    MaterialTheme {
        UiScreen()
    }
}
