package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.html.H2;
import jakarta.validation.constraints.NotNull;

public class UsersViewHeaderInfoTitleText extends H2 {

    public static final String CLASS_NAME = UsersViewHeaderInfoTitle.CLASS_NAME + "-text";

    public UsersViewHeaderInfoTitleText(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setTitleText(UsersView.NAME);
    }

    public void setTitleText(@NotNull String titleText) {
        setText(titleText);
    }
}
