package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.Key.KEY_C;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.button.ButtonVariant.LUMO_ICON;
import static com.vaadin.flow.component.icon.VaadinIcon.BULLETS;
import static org.hk.doghub.ui.components.shared.EntitiesViewPresentationMode.LIST;

public class TipsViewHeaderActionsTypeSelectorListButton extends Button {

    public static final String CLASS_NAME = TipsViewHeaderActionsPresentationTypeSelector.CLASS_NAME + "-list-button";

    private final TipsViewState tipsViewState;

    public TipsViewHeaderActionsTypeSelectorListButton(TipDataProvider tipDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        this.tipsViewState = tipsViewState;
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ICON);
        getElement().setAttribute("aria-label", "List View");
        setTooltipText("List View");
        setIcon(BULLETS.create());
        addClickShortcut(KEY_C, ALT);
        addClickListener(this::cardPresentationTypeClicked);
    }

    private void cardPresentationTypeClicked(ClickEvent<Button> event) {
        tipsViewState.setPresentationMode(LIST);
    }
}
