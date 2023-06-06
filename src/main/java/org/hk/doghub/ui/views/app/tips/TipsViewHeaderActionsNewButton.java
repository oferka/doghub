package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.Key.KEY_N;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.button.ButtonVariant.LUMO_PRIMARY;
import static com.vaadin.flow.component.icon.VaadinIcon.PLUS_CIRCLE;

@Slf4j
public class TipsViewHeaderActionsNewButton extends Button {

    public static final String CLASS_NAME = TipsViewHeaderActions.CLASS_NAME + "-new-button";

    public TipsViewHeaderActionsNewButton(TipDataProvider tipDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setIcon(PLUS_CIRCLE.create());
        setText("New Tip");
        addThemeVariants(LUMO_PRIMARY);
        addClickListener(this::newClicked);
        addClickShortcut(KEY_N, ALT);
    }

    private void newClicked(ClickEvent<Button> event) {
        log.info("New tip clicked");
    }
}
