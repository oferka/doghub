package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.LikesContainer;

public class TipsListItemInfoActions extends HorizontalLayout {

    public static final String CLASS_NAME = TipsListItemInfo.CLASS_NAME + "-actions";

    private final LikesContainer likes;
    private final TipComments comments;
    private final TipShares shares;

    public TipsListItemInfoActions(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");

        likes = new LikesContainer(tip.getFeedback().getLikes());
        add(likes);

        comments = new TipComments(tip, authenticatedUser);
        add(comments);

        shares = new TipShares(tip, authenticatedUser);
        add(shares);
    }
}
