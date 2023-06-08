package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderInfoTitleIcon;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderInfoTitleText;

import static com.vaadin.flow.component.icon.VaadinIcon.LINK;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipsViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = TipsViewHeaderInfo.CLASS_NAME + "-title";

    private final EntitiesViewHeaderInfoTitleIcon icon;
    private final EntitiesViewHeaderInfoTitleText text;
    private final TipsViewHeaderInfoTitleCount count;

    public TipsViewHeaderInfoTitle(TipDataProvider tipDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        icon = new EntitiesViewHeaderInfoTitleIcon(LINK);
        add(icon);

        text = new EntitiesViewHeaderInfoTitleText(TipsView.NAME);
        add(text);

        count = new TipsViewHeaderInfoTitleCount(tipDataProvider, authenticatedUser);
        add(count);
    }
}
