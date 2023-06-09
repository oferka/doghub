package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderInfo;

import static com.vaadin.flow.component.icon.VaadinIcon.LINK;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipsViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = TipsView.CLASS_NAME + "-header";

    private final EntitiesViewHeaderInfo info;
    private final TipsViewHeaderActions actions;

    public TipsViewHeader(TipDataProvider tipDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        info = new EntitiesViewHeaderInfo(LINK, TipsView.NAME, tipDataProvider.countForUser(authenticatedUser), "Tips view description");
        add(info);

        actions = new TipsViewHeaderActions(tipsViewState);
        add(actions);
    }
}
