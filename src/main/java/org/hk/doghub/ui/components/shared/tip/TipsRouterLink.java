package org.hk.doghub.ui.components.shared.tip;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.components.shared.EntitiesButton;
import org.hk.doghub.ui.views.app.tips.TipsView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class TipsRouterLink extends RouterLink {

    public static final String CLASS_NAME = "tips-router-link";

    public TipsRouterLink() {
        super(EMPTY, TipsView.class);
        addClassName(CLASS_NAME);
        add(new EntitiesButton("Tips"));
    }
}
