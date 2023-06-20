package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_ICON;
import static org.hk.doghub.ui.components.shared.EntitiesViewPresentationMode.LIST;
import static org.vaadin.lineawesome.LineAwesomeIcon.BARS_SOLID;

public class EntitiesViewHeaderActionsTypeSelectorListButton extends Button {

    public static final String CLASS_NAME = EntitiesViewHeaderActionsPresentationTypeSelector.CLASS_NAME + "-list-button";

    private final EntitiesViewState viewState;

    public EntitiesViewHeaderActionsTypeSelectorListButton(EntitiesViewState viewState) {
        this.viewState = viewState;
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ICON);
        getElement().setAttribute("aria-label", "List View");
        setTooltipText("List View");
        setIcon(BARS_SOLID.create());
        addClickListener(this::cardPresentationTypeClicked);
    }

    private void cardPresentationTypeClicked(ClickEvent<Button> event) {
        viewState.setPresentationMode(LIST);
    }
}
