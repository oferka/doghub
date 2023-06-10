package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.html.Div;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.ui.components.shared.CreationTimeLabel;

public class TipsListItemInfoCreationTime extends Div {

    public static final String CLASS_NAME = TipsListItemInfo.CLASS_NAME + "-creation-time";

    private final CreationTimeLabel creationTime;

    public TipsListItemInfoCreationTime(DogHubTip tip) {
        addClassNames(CLASS_NAME);
        creationTime = new CreationTimeLabel(tip.getCreationTime());
        add(creationTime);
    }
}
