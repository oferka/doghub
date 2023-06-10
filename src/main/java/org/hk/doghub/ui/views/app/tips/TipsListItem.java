package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesListItemAvatar;

public class TipsListItem extends HorizontalLayout {

    public static final String CLASS_NAME = TipsList.CLASS_NAME + "-item";

    private final EntitiesListItemAvatar<DogHubTip> avatar;
    private final TipsListItemInfo info;

    public TipsListItem(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");

        avatar = new EntitiesListItemAvatar<>(tip);
        add(avatar);

        info = new TipsListItemInfo(tip, authenticatedUser);
        add(info);
    }
}
