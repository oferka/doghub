package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UsersViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = UsersViewHeaderInfo.CLASS_NAME + "-title";

    private final UsersViewHeaderInfoTitleIcon usersViewHeaderInfoTitleIcon;
    private final UsersViewHeaderInfoTitleText usersViewHeaderInfoTitleText;
    private final UsersViewHeaderInfoTitleCount usersViewHeaderInfoTitleCount;

    public UsersViewHeaderInfoTitle(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        usersViewHeaderInfoTitleIcon = new UsersViewHeaderInfoTitleIcon(usersViewDataProvider, usersViewState);
        add(usersViewHeaderInfoTitleIcon);

        usersViewHeaderInfoTitleText = new UsersViewHeaderInfoTitleText(usersViewDataProvider, usersViewState);
        add(usersViewHeaderInfoTitleText);

        usersViewHeaderInfoTitleCount = new UsersViewHeaderInfoTitleCount(usersViewDataProvider, usersViewState);
        add(usersViewHeaderInfoTitleCount);
    }
}
