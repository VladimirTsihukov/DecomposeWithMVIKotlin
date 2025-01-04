package com.tishukoff.decomposewithmvikotlin.navigations_2.list

import com.arkivanov.decompose.value.Value

interface ListComponent {

    val model: Value<ListModel>

    fun onItemClicked(item: String)

    data class ListModel(
        val items: List<String>,
    )
}
