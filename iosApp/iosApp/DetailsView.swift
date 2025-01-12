//
//  DetailsView.swift
//  iosApp
//
//  Created by Vladimir Tishukov on 08.01.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct DetailsView: View {
    
    private let component: DetailComponent
    
    @StateValue
    private var model: DetailComponentDetailComponentModel
    
    init (_component: DetailComponent) {
        self.component = _component
        _model = StateValue(component.model)
    }
    
    var body: some View {
        Text(model.text)
    }
}

#Preview {
    DetailsView(_component: FakeDetailComponent())
}
