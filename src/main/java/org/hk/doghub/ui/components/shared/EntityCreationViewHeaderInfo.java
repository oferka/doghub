package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import jakarta.validation.constraints.NotNull;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class EntityCreationViewHeaderInfo extends VerticalLayout {

    public static final String CLASS_NAME = "entity-creation-view-header-info";

    public EntityCreationViewHeaderInfo(@NotNull Component icon, @NotNull String titleText, @NotNull String descriptionText) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        EntityCreationViewHeaderInfoTitle title = new EntityCreationViewHeaderInfoTitle(icon, titleText);
        EntityCreationViewHeaderInfoDescription description = new EntityCreationViewHeaderInfoDescription(descriptionText);
        add(title, description);
    }
}
