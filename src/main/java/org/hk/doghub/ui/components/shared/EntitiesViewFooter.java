package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class EntitiesViewFooter extends VerticalLayout {

    public static final String CLASS_NAME = "entities-view-footer";

    public EntitiesViewFooter() {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        add(new H2("Entities View Footer"));
    }
}
