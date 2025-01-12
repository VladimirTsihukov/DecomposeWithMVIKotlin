//
//  RootHolder.swift
//  iosApp
//
//  Created by Vladimir Tishukov on 11.01.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import shared

class RootHolder : ObservableObject {
    let lifecycle: LifecycleRegistry
    let root: RootComponent

    init() {
        lifecycle = LifecycleRegistryKt.LifecycleRegistry()

        root = DefaultRootComponent(
            componentContext: DefaultComponentContext(lifecycle: lifecycle)
        )

        LifecycleRegistryExtKt.create(lifecycle)
    }

    deinit {
        // Destroy the root component before it is deallocated
        LifecycleRegistryExtKt.destroy(lifecycle)
    }
}
