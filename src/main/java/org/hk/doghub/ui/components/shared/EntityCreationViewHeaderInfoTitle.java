package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import jakarta.validation.constraints.NotNull;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class EntityCreationViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = "entity-creation-view-header-info-title";

    public EntityCreationViewHeaderInfoTitle(@NotNull Component icon, @NotNull String titleText) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        icon.addClassName(CLASS_NAME + "-icon");
        EntityCreationViewHeaderInfoTitleText text = new EntityCreationViewHeaderInfoTitleText(titleText);
        add(icon, text);
        setVerticalComponentAlignment(CENTER, icon, text);
    }
}
