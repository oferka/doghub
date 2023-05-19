package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.html.Div;
import org.hk.doghub.model.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;

public class TipsListItemInfoHeaderCreationTime extends Div {

    public static final String CLASS_NAME = TipsListItemInfoHeader.CLASS_NAME + "-creation-time";

    private final TipCreationTime creationTime;

    public TipsListItemInfoHeaderCreationTime(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        addClassNames(CLASS_NAME);
        creationTime = new TipCreationTime(tip, authenticatedUser);
        add(creationTime);
    }
}
