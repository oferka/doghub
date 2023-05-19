package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = TipView.CLASS_NAME + "-header";

    private final TipViewHeaderInfo tipViewHeaderInfo;
    private final TipViewHeaderActions tipViewHeaderActions;

    public TipViewHeader(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        tipViewHeaderInfo = new TipViewHeaderInfo(tipsDataProvider, authenticatedUser);
        add(tipViewHeaderInfo);

        tipViewHeaderActions = new TipViewHeaderActions(tipsDataProvider, authenticatedUser);
        add(tipViewHeaderActions);
    }

    public void selectedTipChanged(long selectedTipId) {
        tipViewHeaderInfo.selectedTipChanged(selectedTipId);
        tipViewHeaderActions.selectedTipChanged(selectedTipId);
    }
}
