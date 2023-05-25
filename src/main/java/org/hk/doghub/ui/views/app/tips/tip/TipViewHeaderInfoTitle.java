package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = TipViewHeaderInfo.CLASS_NAME + "-title";

    private final TipViewHeaderInfoTitleAvatar avatar;
    private final TipViewHeaderInfoTitleText text;

    public TipViewHeaderInfoTitle(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        avatar = new TipViewHeaderInfoTitleAvatar(tipsDataProvider, authenticatedUser);
        add(avatar);

        text = new TipViewHeaderInfoTitleText(tipsDataProvider, authenticatedUser);
        add(text);

        setVerticalComponentAlignment(CENTER, avatar, text);
    }

    public void selectedTipChanged(long selectedTipId) {
        avatar.selectedTipChanged(selectedTipId);
        text.selectedTipChanged(selectedTipId);
    }
}
