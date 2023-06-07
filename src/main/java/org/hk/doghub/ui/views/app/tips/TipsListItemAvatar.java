package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.html.Div;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityAvatar;

public class TipsListItemAvatar extends Div {

    public static final String CLASS_NAME = TipsListItem.CLASS_NAME + "-avatar";

    private final EntityAvatar<DogHubTip> avatar;

    public TipsListItemAvatar(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        addClassNames(CLASS_NAME);
        avatar = new EntityAvatar<>(tip);
        add(avatar);
    }
}
