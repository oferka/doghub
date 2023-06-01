package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.html.Span;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.user.UserCreationService;

public class UserCreationViewHeaderInfoDescription extends Span {

    public static final String CLASS_NAME = UserCreationViewHeaderInfo.CLASS_NAME + "-description";

    public UserCreationViewHeaderInfoDescription(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);

        setDescriptionText("Add someone you love to DogHub");
    }

    public void setDescriptionText(@NotNull String descriptionText) {
        setText(descriptionText);
    }
}
