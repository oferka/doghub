package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipsViewBodyGridPresentation extends VerticalLayout {

    public static final String CLASS_NAME = TipsViewBody.CLASS_NAME + "-grid-presentation";

    private final TipsGrid grid;

    public TipsViewBodyGridPresentation(TipDataProvider tipDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        grid = new TipsGrid(tipDataProvider, authenticatedUser);
        addAndExpand(grid);
    }
}
