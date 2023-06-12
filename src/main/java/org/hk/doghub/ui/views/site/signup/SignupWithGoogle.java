package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.ui.components.shared.GoogleLogo;

import static com.vaadin.flow.component.Key.KEY_G;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.button.ButtonVariant.LUMO_ICON;

@Slf4j
public class SignupWithGoogle extends Button {

    public static final String CLASS_NAME = SignupWith.CLASS_NAME + "-google";

    public SignupWithGoogle() {
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ICON);
        GoogleLogo google = new GoogleLogo();
        setIcon(google);
        setText("Continue with Google");
        addClickListener(this::signupWithGoogleClicked);
        addClickShortcut(KEY_G, ALT);
    }

    private void signupWithGoogleClicked(ClickEvent<Button> event) {
        log.info("Signup with Google clicked");
    }
}
