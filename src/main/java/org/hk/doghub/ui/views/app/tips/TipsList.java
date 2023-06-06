package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;

public class TipsList extends Div {

    public static final String CLASS_NAME = "tips-list";

    public TipsList(TipDataProvider tipDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setWidthFull();
        Grid<DogHubTip> grid = new Grid<>();
        grid.addClassName("tips-list-grid");
        setSizeFull();
        grid.setHeightFull();
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid.addColumn(new ComponentRenderer<>(tip -> new TipsListItem(tip, authenticatedUser)));
        grid.setItems(tipDataProvider.findAllForUser(authenticatedUser));
        add(grid);
    }
}
