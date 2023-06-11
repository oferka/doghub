package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesList;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UsersViewBodyListPresentation extends VerticalLayout {

    public static final String CLASS_NAME = UsersViewBody.CLASS_NAME + "-list-presentation";

    private final EntitiesList<DogHubUser> list;

    public UsersViewBodyListPresentation(UserDataProvider userDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        list = new UsersList(userDataProvider, authenticatedUser);
        addAndExpand(list);
    }
}
