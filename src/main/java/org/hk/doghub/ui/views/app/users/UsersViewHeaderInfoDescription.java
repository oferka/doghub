package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.html.Span;
import jakarta.validation.constraints.NotNull;

public class UsersViewHeaderInfoDescription extends Span {

    public static final String CLASS_NAME = UsersViewHeaderInfo.CLASS_NAME + "-description";

    public UsersViewHeaderInfoDescription(UserDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setDescriptionText("Users view description");
    }

    public void setDescriptionText(@NotNull String descriptionText) {
        setText(descriptionText);
    }
}
