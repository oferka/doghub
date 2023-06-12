package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import jakarta.validation.constraints.NotNull;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class EntitiesViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = EntitiesViewHeaderInfo.CLASS_NAME + "-title";

    public EntitiesViewHeaderInfoTitle(@NotNull VaadinIcon vaadinIcon, @NotNull String titleText, long entityCount) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        EntitiesViewHeaderInfoTitleIcon icon = new EntitiesViewHeaderInfoTitleIcon(vaadinIcon);
        EntitiesViewHeaderInfoTitleText text = new EntitiesViewHeaderInfoTitleText(titleText);
        EntitiesViewHeaderInfoTitleCount count = new EntitiesViewHeaderInfoTitleCount(entityCount);
        add(icon, text, count);
    }
}
