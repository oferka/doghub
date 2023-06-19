package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import jakarta.validation.constraints.NotNull;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class EntitiesViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = EntitiesViewHeaderInfo.CLASS_NAME + "-title";

    public EntitiesViewHeaderInfoTitle(@NotNull Component icon, @NotNull String titleText, long entityCount) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        icon.addClassName(CLASS_NAME + "-icon");
        EntitiesViewHeaderInfoTitleText text = new EntitiesViewHeaderInfoTitleText(titleText);
        EntitiesViewHeaderInfoTitleCount count = new EntitiesViewHeaderInfoTitleCount(entityCount);
        add(icon, text, count);
    }
}
