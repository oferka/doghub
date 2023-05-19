package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.TipAvatar;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;

import java.util.Optional;

public class TipViewHeaderInfoTitleAvatar extends HorizontalLayout {

    public static final String CLASS_NAME = TipViewHeaderInfoTitle.CLASS_NAME + "-avatar";

    private final TipAvatar tipAvatar;
    private final TipsDataProvider tipsDataProvider;

    public TipViewHeaderInfoTitleAvatar(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        this.tipsDataProvider = tipsDataProvider;
        addClassName(CLASS_NAME);
        tipAvatar = new TipAvatar(null);
        add(tipAvatar);
    }

    public void selectedTipChanged(long selectedTipId) {
        Optional<DogHubTip> tip = tipsDataProvider.findById(selectedTipId);
        if(tip.isPresent()) {
            tipAvatar.selectedTipChanged(tip.get());
        }
    }
}
