//
//  ListView.swift
//  iosApp
//
//  Created by Vladimir Tishukov on 08.01.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ListView: View {
    
    private let component: ListComponent
    
    @StateValue
    private var state: ListComponentListModel
    
    init(_component: ListComponent) {
        self.component = _component
        _state = StateValue(component.model)
    }
    
    var body: some View {
        List(state.items) { item in
            Text(item)
                .onTapGesture {
                    component.onItemClicked(item: item)
                }
        }
    }
}

#Preview {
    ListView(_component: FakeListComponent())
}

extension String : @retroactive Identifiable {
    public var id: String { self }
}
