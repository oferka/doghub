package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.icon.VaadinIcon.LINK;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipsViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = TipsView.CLASS_NAME + "-header";

    private final TipsViewHeaderInfo info;
    private final TipsViewHeaderActions actions;

    public TipsViewHeader(TipDataProvider tipDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        info = new TipsViewHeaderInfo(LINK, TipsView.NAME, tipDataProvider.countForUser(authenticatedUser), "Tips view description");
        add(info);

        actions = new TipsViewHeaderActions(tipDataProvider, tipsViewState, authenticatedUser);
        add(actions);
    }
}
