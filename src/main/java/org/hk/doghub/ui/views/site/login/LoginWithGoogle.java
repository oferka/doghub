package org.hk.doghub.ui.views.site.login;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.ui.components.shared.GoogleLogo;

import static com.vaadin.flow.component.Key.KEY_G;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.button.ButtonVariant.LUMO_ICON;

@Slf4j
public class LoginWithGoogle extends Button {

    public static final String CLASS_NAME = LoginWith.CLASS_NAME + "-google";

    private final GoogleLogo google;

    public LoginWithGoogle() {
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ICON);
        google = new GoogleLogo();
        setIcon(google);
        setText("Continue with Google");
        addClickListener(this::loginWithGoogleClicked);
        addClickShortcut(KEY_G, ALT);
    }

    private void loginWithGoogleClicked(ClickEvent<Button> event) {
        log.info("Login with Google clicked");
    }
}
