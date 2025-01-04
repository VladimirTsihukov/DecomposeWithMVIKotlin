package com.tishukoff.decomposewithmvikotlin.android.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.tishukoff.decomposewithmvikotlin.android.MyApplicationTheme
import com.tishukoff.decomposewithmvikotlin.navigations_2.list.FakeListComponent
import com.tishukoff.decomposewithmvikotlin.navigations_2.list.ListComponent

@Composable
fun ListContent(
    component: ListComponent,
    modifier: Modifier = Modifier
) {

    val modelValue = component.model.subscribeAsState().value

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(
            items = modelValue.items,
        ) { item ->
            Text(
                text = item,
                modifier = modifier.wrapContentSize().clickable { component.onItemClicked(item) },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ListComponentPreview() {
    MyApplicationTheme {
        ListContent(
            FakeListComponent(),
            Modifier.fillMaxSize()
        )
    }
}
