package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class EntityCreationViewFooter extends HorizontalLayout {

    public static final String CLASS_NAME = "entity-creation-view-footer";

    public EntityCreationViewFooter() {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        add(new Span("Entity creation footer"));
    }
}
