package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import jakarta.validation.constraints.NotNull;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class EntityCreationViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = "entity-creation-view-header";

    public EntityCreationViewHeader(@NotNull Component icon, @NotNull String titleText, @NotNull String descriptionText) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        EntityCreationViewHeaderInfo info = new EntityCreationViewHeaderInfo(icon, titleText, descriptionText);
        EntityCreationViewHeaderActions actions = new EntityCreationViewHeaderActions();
        add(info, actions);
    }
}
