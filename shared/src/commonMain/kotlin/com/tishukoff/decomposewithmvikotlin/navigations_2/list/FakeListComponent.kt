package com.tishukoff.decomposewithmvikotlin.navigations_2.list

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class FakeListComponent: ListComponent {
    override val model: Value<ListComponent.ListModel> =
        MutableValue((ListComponent.ListModel(items = List(10) { "Item $it" })))

    override fun onItemClicked(item: String) { }
}
