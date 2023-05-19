package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;

public class TipsListItemInfoActions extends HorizontalLayout {

    public static final String CLASS_NAME = TipsListItemInfo.CLASS_NAME + "-actions";

    private final TipLikes likes;
    private final TipComments comments;
    private final TipShares shares;

    public TipsListItemInfoActions(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");

        likes = new TipLikes(tip, authenticatedUser);
        add(likes);

        comments = new TipComments(tip, authenticatedUser);
        add(comments);

        shares = new TipShares(tip, authenticatedUser);
        add(shares);
    }
}
