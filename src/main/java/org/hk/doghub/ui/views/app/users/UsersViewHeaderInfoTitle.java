package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UsersViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = UsersViewHeaderInfo.CLASS_NAME + "-title";

    private final UsersViewHeaderInfoTitleIcon icon;
    private final UsersViewHeaderInfoTitleText text;
    private final UsersViewHeaderInfoTitleCount count;

    public UsersViewHeaderInfoTitle(UserDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        icon = new UsersViewHeaderInfoTitleIcon();
        add(icon);

        text = new UsersViewHeaderInfoTitleText(usersViewDataProvider, usersViewState);
        add(text);

        count = new UsersViewHeaderInfoTitleCount(usersViewDataProvider, usersViewState);
        add(count);
    }
}
