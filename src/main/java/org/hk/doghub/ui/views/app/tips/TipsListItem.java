package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesListItemAvatar;
import org.hk.doghub.ui.components.shared.EntitiesListItemInfo;
import org.hk.doghub.ui.components.shared.EntityNameRouterLink;
import org.hk.doghub.ui.views.app.users.user.UserView;

import java.util.ArrayList;
import java.util.List;

public class TipsListItem extends HorizontalLayout {

    public static final String CLASS_NAME = TipsList.CLASS_NAME + "-item";

    private final EntitiesListItemAvatar<DogHubTip> avatar;
    private final EntitiesListItemInfo<DogHubTip> info;

    public TipsListItem(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");

        avatar = new EntitiesListItemAvatar<>(tip);
        add(avatar);

        info = new EntitiesListItemInfo<>(tip, getListItemInfoBodyComponents(tip, authenticatedUser));
        add(info);
    }

    private List<Component> getListItemInfoBodyComponents(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        List<Component> result = new ArrayList<>();
        if(authenticatedUser.hasAdminRole()) {
            result.add(new EntityNameRouterLink<>(tip.getCreatedBy(), UserView.class));
        }
        return result;
    }
}
