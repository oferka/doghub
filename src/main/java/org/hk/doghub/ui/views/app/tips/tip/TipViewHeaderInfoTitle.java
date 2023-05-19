package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = TipViewHeaderInfo.CLASS_NAME + "-title";

    private final TipViewHeaderInfoTitleAvatar tipViewHeaderInfoTitleAvatar;
    private final TipViewHeaderInfoTitleText tipViewHeaderInfoTitleText;

    public TipViewHeaderInfoTitle(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        tipViewHeaderInfoTitleAvatar = new TipViewHeaderInfoTitleAvatar(tipsDataProvider, authenticatedUser);
        add(tipViewHeaderInfoTitleAvatar);

        tipViewHeaderInfoTitleText = new TipViewHeaderInfoTitleText(tipsDataProvider, authenticatedUser);
        add(tipViewHeaderInfoTitleText);

        setVerticalComponentAlignment(CENTER, tipViewHeaderInfoTitleAvatar, tipViewHeaderInfoTitleText);
    }

    public void selectedTipChanged(long selectedTipId) {
        tipViewHeaderInfoTitleAvatar.selectedTipChanged(selectedTipId);
        tipViewHeaderInfoTitleText.selectedTipChanged(selectedTipId);
    }
}
