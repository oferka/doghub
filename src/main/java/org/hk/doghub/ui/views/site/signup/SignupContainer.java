package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.user.UserCreationService;

public class SignupContainer extends VerticalLayout {

    public static final String CLASS_NAME = "signup-container";

    public SignupContainer(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);
        SignupHeader header = new SignupHeader();
        SignupBody body = new SignupBody(authenticatedUser, userCreationService);
        SignupFooter footer = new SignupFooter();
        add(header, body, footer);
    }
}
