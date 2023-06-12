package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class EntityCreationViewFooter extends VerticalLayout {

    public static final String CLASS_NAME = "entity-creation-view-footer";

    public EntityCreationViewFooter() {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        add(new H2("Entity creation footer"));
    }
}
