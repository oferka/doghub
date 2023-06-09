package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderInfoDescription;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderInfoTitle;

import static com.vaadin.flow.component.icon.VaadinIcon.USERS;

public class UsersViewHeaderInfo extends VerticalLayout {

    public static final String CLASS_NAME = UsersViewHeader.CLASS_NAME + "-info";

    private final EntitiesViewHeaderInfoTitle title;
    private final EntitiesViewHeaderInfoDescription description;

    public UsersViewHeaderInfo(UserDataProvider usersViewDataProvider) {
        addClassName(CLASS_NAME);

        setAlignItems(FlexComponent.Alignment.CENTER);

        title = new EntitiesViewHeaderInfoTitle(USERS, UsersView.NAME, usersViewDataProvider.count());
        add(title);

        description = new EntitiesViewHeaderInfoDescription("Users view description");
        add(description);
    }
}
