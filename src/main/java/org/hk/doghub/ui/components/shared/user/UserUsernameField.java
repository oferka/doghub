package org.hk.doghub.ui.components.shared.user;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.ReadOnlyTextField;

import static org.hk.doghub.model.user.DogHubUser.USER_NAME_MAX_LENGTH;
import static org.vaadin.lineawesome.LineAwesomeIcon.USER_SOLID;

public class UserUsernameField extends ReadOnlyTextField {

    public static final String CLASS_NAME = "user-username-field";

    public static final String LABEL = "User Name";

    public UserUsernameField() {
        super(LABEL, true, USER_NAME_MAX_LENGTH, USER_SOLID.create());
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubUser user) {
        @NotNull String username = user.getUsername();
        setValue(username);
    }
}
