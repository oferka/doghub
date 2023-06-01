package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.tip.TipAvatar;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;

import java.util.Optional;

public class TipViewHeaderInfoTitleAvatar extends HorizontalLayout {

    public static final String CLASS_NAME = TipViewHeaderInfoTitle.CLASS_NAME + "-avatar";

    private final TipAvatar avatar;
    private final TipsDataProvider tipsDataProvider;

    public TipViewHeaderInfoTitleAvatar(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        this.tipsDataProvider = tipsDataProvider;
        addClassName(CLASS_NAME);
        avatar = new TipAvatar(null);
        add(avatar);
    }

    public void selectedTipChanged(long selectedTipId) {
        Optional<DogHubTip> tip = tipsDataProvider.findById(selectedTipId);
        if(tip.isPresent()) {
            avatar.selectedTipChanged(tip.get());
        }
    }
}
