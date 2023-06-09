package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;

import static com.vaadin.flow.component.Key.KEY_G;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.button.ButtonVariant.LUMO_ICON;
import static com.vaadin.flow.component.icon.VaadinIcon.TABLE;
import static org.hk.doghub.ui.views.app.users.UsersViewPresentationMode.GRID;

public class UsersViewHeaderActionsTypeSelectorGridButton extends Button {

    public static final String CLASS_NAME = UsersViewHeaderActionsPresentationTypeSelector.CLASS_NAME + "-grid-button";

    private final UsersViewState viewState;

    public UsersViewHeaderActionsTypeSelectorGridButton(UsersViewState viewState) {
        this.viewState = viewState;
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ICON);
        getElement().setAttribute("aria-label", "Grid View");
        setTooltipText("Grid View");
        setIcon(TABLE.create());
        addClickShortcut(KEY_G, ALT);
        addClickListener(this::gridPresentationTypeClicked);
    }

    private void gridPresentationTypeClicked(ClickEvent<Button> event) {
        viewState.setPresentationMode(GRID);
    }
}
