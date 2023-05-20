package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.hk.doghub.ui.views.app.admin.AdminView;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;

@PageTitle(UsersView.NAME)
@Route(value = UsersView.ROUTE, layout = DogHubAppLayout.class)
@RolesAllowed({"ADMIN"})
public class UsersView extends VerticalLayout {

    public static final String ROUTE = AdminView.ROUTE + "/users";
    public static final String ID_PREFIX = "users";
    public static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Users";
    private final UsersViewHeader header;
    private final UsersViewBody body;
    private final UsersViewFooter footer;

    public UsersView(UsersDataProvider usersDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        header = new UsersViewHeader(usersDataProvider, usersViewState);
        add(header);

        body = new UsersViewBody(usersDataProvider, usersViewState);
        addAndExpand(body);

        footer = new UsersViewFooter(usersDataProvider, usersViewState);
        add(footer);
    }
}
