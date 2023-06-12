package org.hk.doghub.ui.views.site.login;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.ui.components.shared.FacebookLogo;

import static com.vaadin.flow.component.Key.KEY_F;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.button.ButtonVariant.LUMO_ICON;

@Slf4j
public class LoginWithFacebook extends Button {

    public static final String CLASS_NAME = LoginWith.CLASS_NAME + "-facebook";

    public LoginWithFacebook() {
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ICON);
        FacebookLogo facebook = new FacebookLogo();
        setIcon(facebook);
        setText("Continue with Facebook");
        addClickListener(this::signupWithFacebookClicked);
        addClickShortcut(KEY_F, ALT);
    }

    private void signupWithFacebookClicked(ClickEvent<Button> event) {
        log.info("Login with Facebook clicked");
    }
}
