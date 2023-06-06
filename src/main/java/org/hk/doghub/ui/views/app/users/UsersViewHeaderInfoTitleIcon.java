package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.icon.Icon;

import static com.vaadin.flow.component.icon.VaadinIcon.USERS;

public class UsersViewHeaderInfoTitleIcon extends Icon {

    public static final String CLASS_NAME = UsersViewHeaderInfoTitle.CLASS_NAME + "-icon";

    public UsersViewHeaderInfoTitleIcon(UserDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        super(USERS);
        addClassName(CLASS_NAME);
    }
}
