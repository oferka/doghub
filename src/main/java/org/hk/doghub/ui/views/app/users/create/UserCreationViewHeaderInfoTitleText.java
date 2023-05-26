package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.html.H2;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.UserCreationService;

public class UserCreationViewHeaderInfoTitleText extends H2 {

    public static final String CLASS_NAME = UserCreationViewHeaderInfoTitle.CLASS_NAME + "-text";

    public UserCreationViewHeaderInfoTitleText(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);

        setTitleText("Create a User");
    }

    public void setTitleText(@NotNull String titleText) {
        setText(titleText);
    }
}
