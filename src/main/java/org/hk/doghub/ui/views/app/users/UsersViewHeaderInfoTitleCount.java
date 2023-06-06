package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.html.H2;

import static java.lang.String.format;

public class UsersViewHeaderInfoTitleCount extends H2 {

    public static final String CLASS_NAME = UsersViewHeaderInfoTitle.CLASS_NAME + "-count";

    public UsersViewHeaderInfoTitleCount(UserDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setTitleText(usersViewDataProvider.count());
    }

    public void setTitleText(long count) {
        setText(format("(%s)", count));
    }
}
