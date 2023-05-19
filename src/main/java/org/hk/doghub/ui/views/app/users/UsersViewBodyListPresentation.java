package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UsersViewBodyListPresentation extends VerticalLayout {

    public static final String CLASS_NAME = UsersViewBody.CLASS_NAME + "-list-presentation";

    private final UsersList usersList;

    public UsersViewBodyListPresentation(UsersDataProvider usersDataProvider) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        usersList = new UsersList(usersDataProvider);
        addAndExpand(usersList);
    }
}
