package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EntitiesListItemInfoHeaderName;
import org.hk.doghub.ui.views.app.users.user.UserView;

public class UsersListItemInfoHeader extends HorizontalLayout {

    public static final String CLASS_NAME = UsersListItemInfo.CLASS_NAME + "-header";

    private final EntitiesListItemInfoHeaderName<DogHubUser> name;

    public UsersListItemInfoHeader(DogHubUser user) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");
        name = new EntitiesListItemInfoHeaderName<>(user, UserView.class);
        add(name);
    }
}
