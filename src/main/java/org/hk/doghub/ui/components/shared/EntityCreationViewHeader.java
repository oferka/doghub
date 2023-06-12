package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import jakarta.validation.constraints.NotNull;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class EntityCreationViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = "entity-creation-view-header";

    public EntityCreationViewHeader(@NotNull VaadinIcon vaadinIcon, @NotNull String titleText, @NotNull String descriptionText) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        EntityCreationViewHeaderInfo info = new EntityCreationViewHeaderInfo(vaadinIcon, titleText, descriptionText);
        EntityCreationViewHeaderActions actions = new EntityCreationViewHeaderActions();
        add(info, actions);
    }
}
