package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = TipView.CLASS_NAME + "-header";

    private final TipViewHeaderInfo info;
    private final TipViewHeaderActions actions;

    public TipViewHeader(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        info = new TipViewHeaderInfo(tipsDataProvider, authenticatedUser);
        add(info);

        actions = new TipViewHeaderActions(tipsDataProvider, authenticatedUser);
        add(actions);
    }

    public void selectedTipChanged(long selectedTipId) {
        info.selectedTipChanged(selectedTipId);
        actions.selectedTipChanged(selectedTipId);
    }
}
