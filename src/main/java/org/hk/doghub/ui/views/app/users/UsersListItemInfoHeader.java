package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.DogHubUser;

public class UsersListItemInfoHeader extends HorizontalLayout {

    public static final String CLASS_NAME = UsersListItemInfo.CLASS_NAME + "-header";

    private final UsersListItemInfoHeaderName name;
    private final UsersListItemInfoHeaderDateOfRegistration dateOfRegistration;

    public UsersListItemInfoHeader(DogHubUser user) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");

        name = new UsersListItemInfoHeaderName(user);
        add(name);

        dateOfRegistration = new UsersListItemInfoHeaderDateOfRegistration(user);
        add(dateOfRegistration);
    }
}
