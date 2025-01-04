package com.tishukoff.decomposewithmvikotlin.navigations_2.detail

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class FakeDetailComponent : DetailComponent {
    override val model: Value<String> = MutableValue("Item 1")

    override fun onFinish() { }
}
