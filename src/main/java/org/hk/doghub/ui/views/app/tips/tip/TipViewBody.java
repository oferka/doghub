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

    private final Label selectedId;
    private final RouterLink tips;

    public TipViewBody(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        selectedId = new Label();
        add(selectedId);

        tips = new RouterLink(TipsView.NAME, TipsView.class);
        add(tips);
    }

    public void selectedTipChanged(long selectedTipId) {
        selectedId.setText("Selected Tip: " + selectedTipId);
    }
}
