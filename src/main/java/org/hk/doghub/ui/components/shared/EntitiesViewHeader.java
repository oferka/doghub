package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import jakarta.validation.constraints.NotNull;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class EntitiesViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = "entities-view-header";

    private final EntitiesViewHeaderInfo info;
    private final EntitiesViewHeaderActions actions;

    public EntitiesViewHeader(@NotNull EntitiesViewState viewState,
                              @NotNull VaadinIcon vaadinIcon,
                              @NotNull String titleText,
                              long entityCount,
                              @NotNull String descriptionText,
                              @NotNull Class<? extends Component> entityCreationNavigationTarget,
                              @NotNull String entityName) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        info = new EntitiesViewHeaderInfo(vaadinIcon, titleText, entityCount, descriptionText);
        add(info);

        actions = new EntitiesViewHeaderActions(viewState, entityCreationNavigationTarget, entityName);
        add(actions);
    }
}
