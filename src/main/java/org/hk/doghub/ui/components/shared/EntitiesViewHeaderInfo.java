package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import jakarta.validation.constraints.NotNull;

public class EntitiesViewHeaderInfo extends VerticalLayout {

    public static final String CLASS_NAME = EntitiesViewHeader.CLASS_NAME + "-info";

    public EntitiesViewHeaderInfo(@NotNull VaadinIcon vaadinIcon, @NotNull String titleText, long entityCount, @NotNull String descriptionText) {
        addClassName(CLASS_NAME);
        setAlignItems(FlexComponent.Alignment.CENTER);
        EntitiesViewHeaderInfoTitle title = new EntitiesViewHeaderInfoTitle(vaadinIcon, titleText, entityCount);
        EntitiesViewHeaderInfoDescription description = new EntitiesViewHeaderInfoDescription(descriptionText);
        add(title, description);
    }
}
