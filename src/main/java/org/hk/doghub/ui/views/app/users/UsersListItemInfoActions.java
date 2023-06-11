package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.CommentsContainer;
import org.hk.doghub.ui.components.shared.LikesContainer;
import org.hk.doghub.ui.components.shared.SharesContainer;

public class UsersListItemInfoActions extends HorizontalLayout {

    public static final String CLASS_NAME = UsersListItemInfo.CLASS_NAME + "-actions";

    private final LikesContainer likes;
    private final CommentsContainer comments;
    private final SharesContainer shares;

    public UsersListItemInfoActions(DogHubUser user) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");

        likes = new LikesContainer(user.getFeedback().getLikes());
        add(likes);

        comments = new CommentsContainer(user.getFeedback().getComments());
        add(comments);

        shares = new SharesContainer(user.getFeedback().getShares());
        add(shares);
    }
}
