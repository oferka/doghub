package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderActionsTypeSelectorGridButton;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderActionsTypeSelectorListButton;
import org.hk.doghub.ui.components.shared.EntitiesViewPresentationMode;
import org.hk.doghub.ui.components.shared.EntitiesViewPresentationModeChangeEvent;

public class TipsViewHeaderActionsPresentationTypeSelector extends HorizontalLayout {

    public static final String CLASS_NAME = TipsViewHeaderActions.CLASS_NAME + "-presentation-type-selector";

    private final EntitiesViewHeaderActionsTypeSelectorGridButton grid;
    private final EntitiesViewHeaderActionsTypeSelectorListButton list;

    public TipsViewHeaderActionsPresentationTypeSelector(TipDataProvider tipDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setSpacing(false);

        grid = new EntitiesViewHeaderActionsTypeSelectorGridButton(tipsViewState);
        add(grid);

        list = new EntitiesViewHeaderActionsTypeSelectorListButton(tipsViewState);
        add(list);

        setPresentationType(tipsViewState.getPresentationMode());
        tipsViewState.addPresentationModeChangeListener(this::presentationModeChanged);
    }

    private void setPresentationType(EntitiesViewPresentationMode presentationMode) {
        switch (presentationMode) {
            case GRID -> {
                grid.setEnabled(false);
                list.setEnabled(true);
            }
            case LIST -> {
                grid.setEnabled(true);
                list.setEnabled(false);
            }
        }
    }

    public void presentationModeChanged(EntitiesViewPresentationModeChangeEvent event) {
        setPresentationType(event.getNewPresentationMode());
    }
}
