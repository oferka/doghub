package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import jakarta.validation.constraints.NotNull;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class EntitiesViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = "entities-view-header-info-title-title";

    private final EntitiesViewHeaderInfoTitleIcon icon;
    private final EntitiesViewHeaderInfoTitleText text;
    private final EntitiesViewHeaderInfoTitleCount count;

    public EntitiesViewHeaderInfoTitle(@NotNull VaadinIcon vaadinIcon, @NotNull String titleText, long entityCount) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        icon = new EntitiesViewHeaderInfoTitleIcon(vaadinIcon);
        add(icon);
        text = new EntitiesViewHeaderInfoTitleText(titleText);
        add(text);
        count = new EntitiesViewHeaderInfoTitleCount(entityCount);
        add(count);
    }
}
