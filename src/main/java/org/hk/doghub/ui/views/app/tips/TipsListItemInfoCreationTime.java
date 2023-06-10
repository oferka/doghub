package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.html.Div;
import org.hk.doghub.model.tip.DogHubTip;

public class TipsListItemInfoCreationTime extends Div {

    public static final String CLASS_NAME = TipsListItemInfo.CLASS_NAME + "-creation-time";

    private final TipCreationTime creationTime;

    public TipsListItemInfoCreationTime(DogHubTip tip) {
        addClassNames(CLASS_NAME);
        creationTime = new TipCreationTime(tip);
        add(creationTime);
    }
}
