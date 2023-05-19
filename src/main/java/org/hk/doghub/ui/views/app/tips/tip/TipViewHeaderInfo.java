package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipViewHeaderInfo extends VerticalLayout {

    public static final String CLASS_NAME = TipViewHeader.CLASS_NAME + "-info";

    private final TipViewHeaderInfoTitle tipViewHeaderInfoTitle;
    private final TipViewHeaderInfoDescription tipViewHeaderInfoDescription;

    public TipViewHeaderInfo(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        tipViewHeaderInfoTitle = new TipViewHeaderInfoTitle(tipsDataProvider, authenticatedUser);
        add(tipViewHeaderInfoTitle);

        tipViewHeaderInfoDescription = new TipViewHeaderInfoDescription(tipsDataProvider, authenticatedUser);
        add(tipViewHeaderInfoDescription);
    }

    public void selectedTipChanged(long selectedTipId) {
        tipViewHeaderInfoTitle.selectedTipChanged(selectedTipId);
        tipViewHeaderInfoDescription.selectedTipChanged(selectedTipId);
    }
}
