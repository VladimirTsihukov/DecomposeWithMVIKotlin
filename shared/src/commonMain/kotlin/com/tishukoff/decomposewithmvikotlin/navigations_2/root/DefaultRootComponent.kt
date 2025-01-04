package com.tishukoff.decomposewithmvikotlin.navigations_2.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.value.Value
import com.tishukoff.decomposewithmvikotlin.navigations_2.detail.DetailComponent
import com.tishukoff.decomposewithmvikotlin.navigations_2.detail.DetailComponentDefault
import com.tishukoff.decomposewithmvikotlin.navigations_2.list.ListComponent
import com.tishukoff.decomposewithmvikotlin.navigations_2.list.ListComponentDefault
import kotlinx.serialization.Serializable

class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, RootComponent.ChildPage>> =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.List,
            handleBackButton = true,
            childFactory = ::child,
        )

    private fun child(config: Config, componentContext: ComponentContext): RootComponent.ChildPage {
        return when (config) {
            Config.List -> RootComponent.ChildPage.ListChildPage(listComponent(componentContext))
            is Config.Details -> RootComponent.ChildPage.DetailsChildPage(detailsComponent(componentContext, config))
        }
    }

    private fun listComponent(componentContext: ComponentContext): ListComponent {
        return ListComponentDefault(componentContext) {
            navigation.pushNew(Config.Details(it))
        }
    }

    private fun detailsComponent(
        componentContext: ComponentContext,
        config: Config.Details,
    ): DetailComponent {
        return DetailComponentDefault(
            componentContext = componentContext,
            item = config.item,
            onFinished = navigation::pop
        )
    }

    override fun onBackClicked(toIndex: Int) {
        navigation.popTo(index = toIndex)
    }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object List : Config

        @Serializable
        data class Details(val item: String) : Config
    }
}
