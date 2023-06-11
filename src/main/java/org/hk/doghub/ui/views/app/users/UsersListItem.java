package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.DogHubLabel;
import org.hk.doghub.ui.components.shared.EntitiesListItemAvatar;
import org.hk.doghub.ui.components.shared.EntitiesListItemInfo;

import java.util.ArrayList;
import java.util.List;

public class UsersListItem extends HorizontalLayout {

    public static final String CLASS_NAME = UsersList.CLASS_NAME + "-item";

    private final EntitiesListItemAvatar<DogHubUser> avatar;
    private final EntitiesListItemInfo<DogHubUser> info;

    public UsersListItem(DogHubUser user, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");

        avatar = new EntitiesListItemAvatar<>(user);
        add(avatar);

        info = new EntitiesListItemInfo<>(user, getListItemInfoBodyComponents(user, authenticatedUser));
        add(info);
    }

    private List<Component> getListItemInfoBodyComponents(DogHubUser user, AuthenticatedUser authenticatedUser) {
        List<Component> result = new ArrayList<>();
        result.add(new DogHubLabel(user.getCompany()));
        return result;
    }
}
