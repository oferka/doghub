package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesGrid;
import org.hk.doghub.ui.views.app.EntityDataProvider;
import org.hk.doghub.ui.views.app.users.user.UserView;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UsersViewBodyGridPresentation extends VerticalLayout {

    public static final String CLASS_NAME = UsersViewBody.CLASS_NAME + "-grid-presentation";

    private final EntitiesGrid<DogHubUser, UserView> grid;

    public UsersViewBodyGridPresentation(EntityDataProvider<DogHubUser> entityDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        grid = new UsersGrid(entityDataProvider, authenticatedUser);
        addAndExpand(grid);
    }
}
