package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.html.Span;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.TipDataProvider;

import java.util.Optional;

public class TipViewHeaderInfoDescription extends Span {

    public static final String CLASS_NAME = TipViewHeaderInfo.CLASS_NAME + "-description";

    private final TipDataProvider tipDataProvider;

    public TipViewHeaderInfoDescription(TipDataProvider tipDataProvider, AuthenticatedUser authenticatedUser) {
        this.tipDataProvider = tipDataProvider;
        addClassName(CLASS_NAME);
    }

    public void selectedTipChanged(long selectedTipId) {
        Optional<DogHubTip> tip = tipDataProvider.findById(selectedTipId);
        tip.ifPresent(value -> setText("Selected Tip Name: " + value.getName()));
    }
}
