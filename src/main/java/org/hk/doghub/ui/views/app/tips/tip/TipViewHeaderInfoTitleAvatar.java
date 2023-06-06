package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.tip.TipAvatar;
import org.hk.doghub.ui.views.app.tips.TipDataProvider;

import java.util.Optional;

public class TipViewHeaderInfoTitleAvatar extends HorizontalLayout {

    public static final String CLASS_NAME = TipViewHeaderInfoTitle.CLASS_NAME + "-avatar";

    private final TipAvatar avatar;
    private final TipDataProvider tipDataProvider;

    public TipViewHeaderInfoTitleAvatar(TipDataProvider tipDataProvider, AuthenticatedUser authenticatedUser) {
        this.tipDataProvider = tipDataProvider;
        addClassName(CLASS_NAME);
        avatar = new TipAvatar(null);
        add(avatar);
    }

    public void selectedTipChanged(long selectedTipId) {
        Optional<DogHubTip> tip = tipDataProvider.findById(selectedTipId);
        if(tip.isPresent()) {
            avatar.selectedTipChanged(tip.get());
        }
    }
}
