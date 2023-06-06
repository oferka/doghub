package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;

import static com.vaadin.flow.component.Key.KEY_C;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.button.ButtonVariant.LUMO_ICON;
import static com.vaadin.flow.component.icon.VaadinIcon.BULLETS;
import static org.hk.doghub.ui.views.app.users.UsersViewPresentationMode.LIST;

public class UsersViewHeaderActionsTypeSelectorListButton extends Button {

    public static final String CLASS_NAME = UsersViewHeaderActionsPresentationTypeSelector.CLASS_NAME + "-list-button";

    private final UsersViewState viewState;

    public UsersViewHeaderActionsTypeSelectorListButton(UserDataProvider usersViewDataProvider, UsersViewState viewState) {
        this.viewState = viewState;
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ICON);
        getElement().setAttribute("aria-label", "List View");
        setTooltipText("List View");
        setIcon(BULLETS.create());
        addClickShortcut(KEY_C, ALT);
        addClickListener(this::cardPresentationTypeClicked);
    }

    private void cardPresentationTypeClicked(ClickEvent<Button> event) {
        viewState.setPresentationMode(LIST);
    }
}
