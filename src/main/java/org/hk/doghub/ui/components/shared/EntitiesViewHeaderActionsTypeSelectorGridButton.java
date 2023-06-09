package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_ICON;
import static com.vaadin.flow.component.icon.VaadinIcon.TABLE;
import static org.hk.doghub.ui.components.shared.EntitiesViewPresentationMode.GRID;

public class EntitiesViewHeaderActionsTypeSelectorGridButton extends Button {

    public static final String CLASS_NAME = "entities-view-header-actions-type-selector-grid-button";

    private final EntitiesViewState viewState;

    public EntitiesViewHeaderActionsTypeSelectorGridButton(EntitiesViewState viewState) {
        this.viewState = viewState;
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ICON);
        getElement().setAttribute("aria-label", "Grid View");
        setTooltipText("Grid View");
        setIcon(TABLE.create());
        addClickListener(this::gridPresentationTypeClicked);
    }

    private void gridPresentationTypeClicked(ClickEvent<Button> event) {
        viewState.setPresentationMode(GRID);
    }
}
