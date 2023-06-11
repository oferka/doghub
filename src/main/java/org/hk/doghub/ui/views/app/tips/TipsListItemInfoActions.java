package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.ui.components.shared.CommentsContainer;
import org.hk.doghub.ui.components.shared.LikesContainer;
import org.hk.doghub.ui.components.shared.SharesContainer;

public class TipsListItemInfoActions extends HorizontalLayout {

    public static final String CLASS_NAME = TipsListItemInfo.CLASS_NAME + "-actions";

    private final LikesContainer likes;
    private final CommentsContainer comments;
    private final SharesContainer shares;

    public TipsListItemInfoActions(DogHubTip tip) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");

        likes = new LikesContainer(tip.getFeedback().getLikes());
        add(likes);

        comments = new CommentsContainer(tip.getFeedback().getComments());
        add(comments);

        shares = new SharesContainer(tip.getFeedback().getShares());
        add(shares);
    }
}
