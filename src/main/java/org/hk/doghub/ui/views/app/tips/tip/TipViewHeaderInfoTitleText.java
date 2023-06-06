package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.html.H2;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.TipDataProvider;

import java.util.Optional;

public class TipViewHeaderInfoTitleText extends H2 {

    public static final String CLASS_NAME = TipViewHeaderInfoTitle.CLASS_NAME + "-text";

    private final TipDataProvider tipDataProvider;

    public TipViewHeaderInfoTitleText(TipDataProvider tipDataProvider, AuthenticatedUser authenticatedUser) {
        this.tipDataProvider = tipDataProvider;
        addClassName(CLASS_NAME);
    }

    public void selectedTipChanged(long selectedTipId) {
        setText("Selected Tip: " + selectedTipId);
        Optional<DogHubTip> tip = tipDataProvider.findById(selectedTipId);
        tip.ifPresent(value -> setText(value.getName()));
    }
}
