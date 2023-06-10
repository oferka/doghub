package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.user.UserAvatarRouterLink;

public class UsersGrid extends Grid<DogHubUser> {

    public static final String CLASS_NAME = "users-grid";

    public UsersGrid(UserDataProvider userDataProvider) {
        addClassName(CLASS_NAME);
        setWidthFull();
        addColumn(new ComponentRenderer<>(UserIdRouterLink::new)).setHeader("ID").setComparator(DogHubUser::getId);
        addColumn(new ComponentRenderer<>(UserNameRouterLink::new)).setHeader("Name").setComparator(DogHubUser::getName);
        addColumn(new ComponentRenderer<>(UserAvatarRouterLink::new)).setHeader("Picture").setComparator(DogHubUser::getName);
            addColumn(new ComponentRenderer<>(UserDateOfRegistration::new)).setHeader("Registered").setComparator(DogHubUser::getCreationTime);
        addColumn(new ComponentRenderer<>(UserTipsRouterLink::new)).setHeader("Tips").setComparator(user -> user.getDogHubTips().size());
        addColumn(new ComponentRenderer<>(UserLikes::new)).setHeader("Likes").setComparator(DogHubUser::getLikes);
        addColumn(new ComponentRenderer<>(UserComments::new)).setHeader("Comments").setComparator(DogHubUser::getComments);
        addColumn(new ComponentRenderer<>(UserShares::new)).setHeader("Shares").setComparator(DogHubUser::getShares);
        setItems(userDataProvider.findAll());
    }
}
