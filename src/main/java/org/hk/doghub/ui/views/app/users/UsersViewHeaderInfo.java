package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class UsersViewHeaderInfo extends VerticalLayout {

    public static final String CLASS_NAME = UsersViewHeader.CLASS_NAME + "-info";

    private final UsersViewHeaderInfoTitle usersViewHeaderInfoTitle;
    private final UsersViewHeaderInfoDescription usersViewHeaderInfoDescription;

    public UsersViewHeaderInfo(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setAlignItems(FlexComponent.Alignment.CENTER);

        usersViewHeaderInfoTitle = new UsersViewHeaderInfoTitle(usersViewDataProvider, usersViewState);
        add(usersViewHeaderInfoTitle);

        usersViewHeaderInfoDescription = new UsersViewHeaderInfoDescription(usersViewDataProvider, usersViewState);
        add(usersViewHeaderInfoDescription);
    }
}
