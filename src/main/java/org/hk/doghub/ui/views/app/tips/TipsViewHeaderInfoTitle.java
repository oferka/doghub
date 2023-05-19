package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipsViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = TipsViewHeaderInfo.CLASS_NAME + "-title";

    private final TipsViewHeaderInfoTitleIcon tipsViewHeaderInfoTitleIcon;
    private final TipsViewHeaderInfoTitleText tipsViewHeaderInfoTitleText;
    private final TipsViewHeaderInfoTitleCount tipsViewHeaderInfoTitleCount;

    public TipsViewHeaderInfoTitle(TipsDataProvider tipsDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        tipsViewHeaderInfoTitleIcon = new TipsViewHeaderInfoTitleIcon(tipsDataProvider, tipsViewState, authenticatedUser);
        add(tipsViewHeaderInfoTitleIcon);

        tipsViewHeaderInfoTitleText = new TipsViewHeaderInfoTitleText(tipsDataProvider, tipsViewState, authenticatedUser);
        add(tipsViewHeaderInfoTitleText);

        tipsViewHeaderInfoTitleCount = new TipsViewHeaderInfoTitleCount(tipsDataProvider, tipsViewState, authenticatedUser);
        add(tipsViewHeaderInfoTitleCount);
    }
}
