package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;

public class TipsViewHeaderInfo extends VerticalLayout {

    public static final String CLASS_NAME = TipsViewHeader.CLASS_NAME + "-info";

    private final TipsViewHeaderInfoTitle title;
    private final TipsViewHeaderInfoDescription description;

    public TipsViewHeaderInfo(TipsDataProvider tipsDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setAlignItems(FlexComponent.Alignment.CENTER);

        title = new TipsViewHeaderInfoTitle(tipsDataProvider, tipsViewState, authenticatedUser);
        add(title);

        description = new TipsViewHeaderInfoDescription(tipsDataProvider, tipsViewState, authenticatedUser);
        add(description);
    }
}
