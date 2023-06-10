package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.ui.components.shared.EntitiesListItemInfoHeaderName;
import org.hk.doghub.ui.views.app.tips.tip.TipView;

public class TipsListItemInfoHeader extends HorizontalLayout {

    public static final String CLASS_NAME = TipsListItemInfo.CLASS_NAME + "-header";

    private final EntitiesListItemInfoHeaderName<DogHubTip> name;

    public TipsListItemInfoHeader(DogHubTip tip) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");
        name = new EntitiesListItemInfoHeaderName<>(tip, TipView.class);
        add(name);
    }
}
