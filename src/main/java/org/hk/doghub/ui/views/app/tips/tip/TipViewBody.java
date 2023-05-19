package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;
import org.hk.doghub.ui.views.app.tips.TipsView;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipViewBody extends VerticalLayout {

    public static final String CLASS_NAME = TipView.CLASS_NAME + "-body";

    private final Label selectedIdLabel;
    private final RouterLink tipsRouterLink;

    public TipViewBody(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        selectedIdLabel = new Label();
        add(selectedIdLabel);

        tipsRouterLink = new RouterLink(TipsView.NAME, TipsView.class);
        add(tipsRouterLink);
    }

    public void selectedTipChanged(long selectedTipId) {
        selectedIdLabel.setText("Selected Tip: " + selectedTipId);
    }
}
