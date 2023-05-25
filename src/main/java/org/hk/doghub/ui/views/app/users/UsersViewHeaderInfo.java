package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class UsersViewHeaderInfo extends VerticalLayout {

    public static final String CLASS_NAME = UsersViewHeader.CLASS_NAME + "-info";

    private final UsersViewHeaderInfoTitle title;
    private final UsersViewHeaderInfoDescription description;

    public UsersViewHeaderInfo(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setAlignItems(FlexComponent.Alignment.CENTER);

        title = new UsersViewHeaderInfoTitle(usersViewDataProvider, usersViewState);
        add(title);

        description = new UsersViewHeaderInfoDescription(usersViewDataProvider, usersViewState);
        add(description);
    }
}
