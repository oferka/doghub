package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UsersViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = UsersView.CLASS_NAME + "-header";

    private final UsersViewHeaderInfo usersViewHeaderInfo;
    private final UsersViewHeaderActions usersViewHeaderActions;

    public UsersViewHeader(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        usersViewHeaderInfo = new UsersViewHeaderInfo(usersViewDataProvider, usersViewState);
        add(usersViewHeaderInfo);

        usersViewHeaderActions = new UsersViewHeaderActions(usersViewDataProvider, usersViewState);
        add(usersViewHeaderActions);
    }
}
