package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderActions;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderInfo;
import org.hk.doghub.ui.views.app.users.create.UserCreationView;
import org.hk.doghub.ui.views.app.users.user.UserView;

import static com.vaadin.flow.component.icon.VaadinIcon.USERS;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UsersViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = UsersView.CLASS_NAME + "-header";

    private final EntitiesViewHeaderInfo info;
    private final EntitiesViewHeaderActions actions;

    public UsersViewHeader(UserDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        info = new EntitiesViewHeaderInfo(USERS, UsersView.NAME, usersViewDataProvider.count(), "Users view description");
        add(info);

        actions = new EntitiesViewHeaderActions(usersViewState, UserCreationView.class, UserView.NAME);
        add(actions);
    }
}
