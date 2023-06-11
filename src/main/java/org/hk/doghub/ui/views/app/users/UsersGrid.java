package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.*;
import org.hk.doghub.ui.components.shared.user.UserAvatarRouterLink;
import org.hk.doghub.ui.views.app.users.user.UserView;

public class UsersGrid extends Grid<DogHubUser> {

    public static final String CLASS_NAME = "users-grid";

    public UsersGrid(UserDataProvider userDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setWidthFull();
        addColumns(authenticatedUser);
        setItems(userDataProvider.findAll());
    }

    private void addColumns(AuthenticatedUser authenticatedUser) {
        addColumn(new ComponentRenderer<>(UserIdRouterLink::new)).setHeader("ID").setComparator(DogHubUser::getId);
        addColumn(new ComponentRenderer<>(user -> new EntityNameRouterLink<>(user, UserView.class))).setHeader("Name").setComparator(DogHubUser::getName);
        addColumn(new ComponentRenderer<>(UserAvatarRouterLink::new)).setHeader("Picture").setComparator(DogHubUser::getName);
        addColumn(new ComponentRenderer<>(user -> new CreationTimeLabel(user.getCreationTime()))).setHeader("Creation Time").setComparator(DogHubUser::getCreationTime);
        addColumn(new ComponentRenderer<>(UserTipsRouterLink::new)).setHeader("Tips").setComparator(user -> user.getDogHubTips().size());
        addColumn(new ComponentRenderer<>(user -> new LikesContainer(user.getFeedback().getLikes()))).setHeader("Likes").setComparator(user -> user.getFeedback().getLikes());
        addColumn(new ComponentRenderer<>(user -> new CommentsContainer(user.getFeedback().getComments()))).setHeader("Comments").setComparator(user -> user.getFeedback().getComments());
        addColumn(new ComponentRenderer<>(user -> new SharesContainer(user.getFeedback().getShares()))).setHeader("Shares").setComparator(user -> user.getFeedback().getShares());
    }
}
