package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.user.DogHubUser;

public class UsersListItemInfoActions extends HorizontalLayout {

    public static final String CLASS_NAME = UsersListItemInfo.CLASS_NAME + "-actions";

    private final UserLikes likes;
    private final UserComments comments;
    private final UserShares shares;

    public UsersListItemInfoActions(DogHubUser user) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");

        likes = new UserLikes(user);
        add(likes);

        comments = new UserComments(user);
        add(comments);

        shares = new UserShares(user);
        add(shares);
    }
}
