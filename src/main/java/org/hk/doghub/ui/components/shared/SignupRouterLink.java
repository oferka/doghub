package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.views.site.signup.SignupView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class SignupRouterLink extends RouterLink {

    public static final String CLASS_NAME = "signup-router-link";

    private final SignupButton signupButton;

    public SignupRouterLink() {
        super(EMPTY, SignupView.class);
        addClassName(CLASS_NAME);

        signupButton = new SignupButton();
        add(signupButton);
    }
}
