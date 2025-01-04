package com.tishukoff.decomposewithmvikotlin.navigations_2.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.tishukoff.decomposewithmvikotlin.navigations_2.detail.DetailComponent
import com.tishukoff.decomposewithmvikotlin.navigations_2.list.ListComponent

interface RootComponent {

    val stack: Value<ChildStack<*, ChildPage>>

    fun onBackClicked(toIndex: Int)

    sealed class ChildPage {
        class ListChildPage(val listComponent: ListComponent) : ChildPage()
        class DetailsChildPage(val detailComponent: DetailComponent) : ChildPage()
    }
}
