package com.tishukoff.decomposewithmvikotlin.navigations_2.detail

import com.arkivanov.decompose.value.Value

interface DetailComponent {

    val model: Value<DetailComponentModel>

    fun onFinish()

    data class DetailComponentModel(val text: String)
}
