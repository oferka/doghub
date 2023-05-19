package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.html.Span;
import org.hk.doghub.model.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;

import java.util.Optional;

public class TipViewHeaderInfoDescription extends Span {

    public static final String CLASS_NAME = TipViewHeaderInfo.CLASS_NAME + "-description";

    private final TipsDataProvider tipsDataProvider;

    public TipViewHeaderInfoDescription(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        this.tipsDataProvider = tipsDataProvider;
        addClassName(CLASS_NAME);
    }

    public void selectedTipChanged(long selectedTipId) {
        Optional<DogHubTip> tip = tipsDataProvider.findById(selectedTipId);
        tip.ifPresent(value -> setText("Selected Tip Name: " + value.getName()));
    }
}
