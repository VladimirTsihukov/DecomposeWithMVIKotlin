package com.tishukoff.decomposewithmvikotlin.android.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.tishukoff.decomposewithmvikotlin.android.MyApplicationTheme
import com.tishukoff.decomposewithmvikotlin.navigations_2.detail.DetailComponent
import com.tishukoff.decomposewithmvikotlin.navigations_2.detail.FakeDetailComponent

@Composable
fun DetailContent(
    component: DetailComponent,
    modifier: Modifier = Modifier,
) {

    val modelValue = component.model.subscribeAsState().value

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = modelValue.text,
            fontSize = 40.sp,
            fontStyle = FontStyle.Normal,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailContentPreview() {
    MyApplicationTheme {
        DetailContent(FakeDetailComponent())
    }
}
