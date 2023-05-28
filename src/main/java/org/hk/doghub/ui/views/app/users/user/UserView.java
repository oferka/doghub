package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.UserCreationService;
import org.hk.doghub.ui.components.shared.UserInfoSaveEvent;
import org.hk.doghub.ui.components.shared.UserInfoSaveListener;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;
import org.hk.doghub.ui.views.app.users.UsersView;

@Slf4j
@Route(value = UsersView.ROUTE, layout = DogHubAppLayout.class)
@PageTitle(UserView.NAME)
@RolesAllowed({"ADMIN"})
public class UserView extends VerticalLayout implements HasUrlParameter<Long>, UserInfoSaveListener {

    public static final String ID_PREFIX = "user";
    public static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "User";

    private final UserViewHeader header;
    private final UserViewBody body;
    private final UserViewFooter footer;

    public UserView(UsersDataProvider usersDataProvider, AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);

        header = new UserViewHeader(usersDataProvider);
        add(header);

        body = new UserViewBody(usersDataProvider, authenticatedUser, userCreationService);
        body.addUserInfoSaveListener(this);
        addAndExpand(body);

        footer = new UserViewFooter(usersDataProvider);
        add(footer);
    }

    @Override
    public void setParameter(BeforeEvent event, Long parameter) {
        setUser(parameter);
    }

    private void setUser(long selectedUserId) {
        header.selectedUserChanged(selectedUserId);
        body.selectedUserChanged(selectedUserId);
        footer.selectedUserChanged(selectedUserId);
    }

    @Override
    public void saveTriggered(UserInfoSaveEvent event) {
        header.save();
        body.save();
        footer.save();
    }
}
