package com.tishukoff.decomposewithmvikotlin.navigations_2.detail

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.tishukoff.decomposewithmvikotlin.navigations_2.detail.DetailComponent.DetailComponentModel

class FakeDetailComponent : DetailComponent {
    override val model: Value<DetailComponentModel> = MutableValue(DetailComponentModel("Item 1"))

    override fun onFinish() { }
}
