package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.hk.doghub.ui.components.shared.EntitiesViewFooter;
import org.hk.doghub.ui.views.app.admin.AdminView;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;

@PageTitle(UsersView.NAME)
@Route(value = UsersView.ROUTE, layout = DogHubAppLayout.class)
@RolesAllowed({"ADMIN"})
public class UsersView extends VerticalLayout {

    public static final String ROUTE = AdminView.ROUTE + "/users";
    private static final String ID_PREFIX = "users";
    private static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Users";
    private final UsersViewHeader header;
    private final UsersViewBody body;
    private final EntitiesViewFooter footer;

    public UsersView(UserDataProvider userDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        header = new UsersViewHeader(userDataProvider, usersViewState);
        add(header);

        body = new UsersViewBody(userDataProvider, usersViewState);
        addAndExpand(body);

        footer = new EntitiesViewFooter();
        add(footer);
    }
}
