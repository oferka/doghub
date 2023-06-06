package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UsersViewBodyListPresentation extends VerticalLayout {

    public static final String CLASS_NAME = UsersViewBody.CLASS_NAME + "-list-presentation";

    private final UsersList list;

    public UsersViewBodyListPresentation(UserDataProvider userDataProvider) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        list = new UsersList(userDataProvider);
        addAndExpand(list);
    }
}
