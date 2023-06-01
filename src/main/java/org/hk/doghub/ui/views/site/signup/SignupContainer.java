package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.user.UserCreationService;

public class SignupContainer extends VerticalLayout {

    public static final String CLASS_NAME = "signup-container";

    private final SignupHeader header;

    private final SignupBody body;

    private final SignupFooter footer;

    public SignupContainer(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);

        header = new SignupHeader();
        add(header);

        body = new SignupBody(authenticatedUser, userCreationService);
        add(body);

        footer = new SignupFooter();
        add(footer);
    }
}
