package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.CommentsContainer;
import org.hk.doghub.ui.components.shared.EntityNameRouterLink;
import org.hk.doghub.ui.components.shared.LikesContainer;
import org.hk.doghub.ui.components.shared.SharesContainer;
import org.hk.doghub.ui.components.shared.user.UserAvatarRouterLink;
import org.hk.doghub.ui.views.app.users.user.UserView;

public class UsersGrid extends Grid<DogHubUser> {

    public static final String CLASS_NAME = "users-grid";

    public UsersGrid(UserDataProvider userDataProvider) {
        addClassName(CLASS_NAME);
        setWidthFull();
        addColumn(new ComponentRenderer<>(UserIdRouterLink::new)).setHeader("ID").setComparator(DogHubUser::getId);
        addColumn(new ComponentRenderer<>(user -> new EntityNameRouterLink<>(user, UserView.class))).setHeader("Name").setComparator(DogHubUser::getName);
        addColumn(new ComponentRenderer<>(UserAvatarRouterLink::new)).setHeader("Picture").setComparator(DogHubUser::getName);
        addColumn(new ComponentRenderer<>(UserDateOfRegistration::new)).setHeader("Registered").setComparator(DogHubUser::getCreationTime);
        addColumn(new ComponentRenderer<>(UserTipsRouterLink::new)).setHeader("Tips").setComparator(user -> user.getDogHubTips().size());
        addColumn(new ComponentRenderer<>(user -> new LikesContainer(user.getFeedback().getLikes()))).setHeader("Likes").setComparator(user -> user.getFeedback().getLikes());
        addColumn(new ComponentRenderer<>(user -> new CommentsContainer(user.getFeedback().getComments()))).setHeader("Comments").setComparator(user -> user.getFeedback().getComments());
        addColumn(new ComponentRenderer<>(user -> new SharesContainer(user.getFeedback().getShares()))).setHeader("Shares").setComparator(user -> user.getFeedback().getShares());
        setItems(userDataProvider.findAll());
    }
}
