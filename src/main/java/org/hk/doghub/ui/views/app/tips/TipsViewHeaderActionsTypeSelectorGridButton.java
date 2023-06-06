package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.Key.KEY_G;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.button.ButtonVariant.LUMO_ICON;
import static com.vaadin.flow.component.icon.VaadinIcon.TABLE;
import static org.hk.doghub.ui.views.app.tips.TipsViewPresentationMode.GRID;

public class TipsViewHeaderActionsTypeSelectorGridButton extends Button {

    public static final String CLASS_NAME = TipsViewHeaderActionsPresentationTypeSelector.CLASS_NAME + "-grid-button";

    private final TipsViewState tipsViewState;

    public TipsViewHeaderActionsTypeSelectorGridButton(TipDataProvider tipDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        this.tipsViewState = tipsViewState;
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ICON);
        getElement().setAttribute("aria-label", "Grid View");
        setTooltipText("Grid View");
        setIcon(TABLE.create());
        addClickShortcut(KEY_G, ALT);
        addClickListener(this::gridPresentationTypeClicked);
    }

    private void gridPresentationTypeClicked(ClickEvent<Button> event) {
        tipsViewState.setPresentationMode(GRID);
    }
}
