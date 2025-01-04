package com.tishukoff.decomposewithmvikotlin.navigations_2.detail

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class DetailComponentDefault(
    componentContext: ComponentContext,
    item: String,
    private val onFinished: () -> Unit,
) : DetailComponent, ComponentContext by componentContext {

    override val model: Value<String> = MutableValue(item)

    override fun onFinish() {
        onFinished.invoke()
    }
}
