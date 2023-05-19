package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.html.H2;
import org.hk.doghub.model.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;

import java.util.Optional;

public class TipViewHeaderInfoTitleText extends H2 {

    public static final String CLASS_NAME = TipViewHeaderInfoTitle.CLASS_NAME + "-text";

    private final TipsDataProvider tipsDataProvider;

    public TipViewHeaderInfoTitleText(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        this.tipsDataProvider = tipsDataProvider;
        addClassName(CLASS_NAME);
    }

    public void selectedTipChanged(long selectedTipId) {
        setText("Selected Tip: " + selectedTipId);
        Optional<DogHubTip> tip = tipsDataProvider.findById(selectedTipId);
        tip.ifPresent(value -> setText(value.getName()));
    }
}
