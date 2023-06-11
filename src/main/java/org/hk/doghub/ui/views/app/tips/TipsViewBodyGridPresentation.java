package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesGrid;
import org.hk.doghub.ui.views.app.EntityDataProvider;
import org.hk.doghub.ui.views.app.tips.tip.TipView;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipsViewBodyGridPresentation extends VerticalLayout {

    public static final String CLASS_NAME = TipsViewBody.CLASS_NAME + "-grid-presentation";

    private final EntitiesGrid<DogHubTip, TipView> grid;

    public TipsViewBodyGridPresentation(EntityDataProvider<DogHubTip> entityDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        grid = new TipsGrid(entityDataProvider, authenticatedUser);
        addAndExpand(grid);
    }
}
