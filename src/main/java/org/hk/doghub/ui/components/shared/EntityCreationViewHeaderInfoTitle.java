package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import jakarta.validation.constraints.NotNull;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class EntityCreationViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = "entity-creation-view-header-info-title";

    public EntityCreationViewHeaderInfoTitle(@NotNull VaadinIcon vaadinIcon, @NotNull String titleText) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        EntityCreationViewHeaderInfoTitleIcon icon = new EntityCreationViewHeaderInfoTitleIcon(vaadinIcon);
        EntityCreationViewHeaderInfoTitleText text = new EntityCreationViewHeaderInfoTitleText(titleText);
        add(icon, text);
        setVerticalComponentAlignment(CENTER, icon, text);
    }
}
