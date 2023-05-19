package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipsViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = TipsView.CLASS_NAME + "-header";

    private final TipsViewHeaderInfo tipsViewHeaderInfo;
    private final TipsViewHeaderActions tipsViewHeaderActions;

    public TipsViewHeader(TipsDataProvider tipsDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        tipsViewHeaderInfo = new TipsViewHeaderInfo(tipsDataProvider, tipsViewState, authenticatedUser);
        add(tipsViewHeaderInfo);

        tipsViewHeaderActions = new TipsViewHeaderActions(tipsDataProvider, tipsViewState, authenticatedUser);
        add(tipsViewHeaderActions);
    }
}
