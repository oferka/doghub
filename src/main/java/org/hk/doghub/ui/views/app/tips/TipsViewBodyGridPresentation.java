package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipsViewBodyGridPresentation extends VerticalLayout {

    public static final String CLASS_NAME = TipsViewBody.CLASS_NAME + "-grid-presentation";

    private final TipsGrid tipsGrid;

    public TipsViewBodyGridPresentation(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        tipsGrid = new TipsGrid(tipsDataProvider, authenticatedUser);
        addAndExpand(tipsGrid);
    }
}
