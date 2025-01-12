//
//  StateValue.swift
//  iosApp
//
//  Created by Vladimir Tishukov on 08.01.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

@propertyWrapper struct StateValue<T : AnyObject>: DynamicProperty {
    @ObservedObject
    private var obj: ObservableValue<T>

    var wrappedValue: T { obj.value }

    init(_ value: Value<T>) {
        obj = ObservableValue(value)
    }
}
