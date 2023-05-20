package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;

public class TipsListItem extends HorizontalLayout {

    public static final String CLASS_NAME = TipsList.CLASS_NAME + "-item";

    private final TipsListItemAvatar tipsListItemAvatar;
    private final TipsListItemInfo tipsListItemInfo;

    public TipsListItem(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");

        tipsListItemAvatar = new TipsListItemAvatar(tip, authenticatedUser);
        add(tipsListItemAvatar);

        tipsListItemInfo = new TipsListItemInfo(tip, authenticatedUser);
        add(tipsListItemInfo);
    }
}
