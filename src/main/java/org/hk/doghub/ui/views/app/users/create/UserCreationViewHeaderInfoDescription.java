package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.html.Span;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.security.AuthenticatedUser;

public class UserCreationViewHeaderInfoDescription extends Span {

    public static final String CLASS_NAME = UserCreationViewHeaderInfo.CLASS_NAME + "-description";

    public UserCreationViewHeaderInfoDescription(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);

        setDescriptionText("Create user view description");
    }

    public void setDescriptionText(@NotNull String descriptionText) {
        setText(descriptionText);
    }
}
