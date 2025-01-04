package com.tishukoff.decomposewithmvikotlin.android.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.tishukoff.decomposewithmvikotlin.navigations_2.root.RootComponent

@Composable
fun RootContent(
    content: RootComponent,
    modifier: Modifier = Modifier,
) {
    Children(
        stack = content.stack,
        modifier = modifier,
        animation = stackAnimation(fade() + slide()),
    ) { (_, instance) ->
        when (instance) {
            is RootComponent.ChildPage.ListChildPage -> ListContent(
                component = instance.listComponent,
                modifier = Modifier.fillMaxSize(),
            )

            is RootComponent.ChildPage.DetailsChildPage -> DetailContent(component = instance.detailComponent)
        }
    }
}
