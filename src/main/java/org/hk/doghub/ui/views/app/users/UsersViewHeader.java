package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UsersViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = UsersView.CLASS_NAME + "-header";

    private final UsersViewHeaderInfo info;
    private final UsersViewHeaderActions actions;

    public UsersViewHeader(UserDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        info = new UsersViewHeaderInfo(usersViewDataProvider, usersViewState);
        add(info);

        actions = new UsersViewHeaderActions(usersViewDataProvider, usersViewState);
        add(actions);
    }
}
