//
//  RootView.swift
//  iosApp
//
//  Created by Vladimir Tishukov on 08.01.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct RootView: View {
    
    let root: RootComponent
    
    init(_root: RootComponent) {
        self.root = _root
    }
    
    var body: some View {
        StackView(
            stackValue: StateValue(root.stack),
            getTitle: {
                switch $0 {
                case is RootComponentChildPage.ListChildPage: return "ListPage"
                case is RootComponentChildPage.DetailsChildPage: return "DetailsPage"
                default: return ""
                }
            },
            onBack: root.onBackClicked(toIndex:),
            childContent: {
                switch $0 {
                case let child as RootComponentChildPage.ListChildPage: ListView(_component: child.listComponent)
                case let child as RootComponentChildPage.DetailsChildPage: DetailsView(_component: child.detailComponent)
                default: EmptyView()
                }
            }
        )
    }
}
