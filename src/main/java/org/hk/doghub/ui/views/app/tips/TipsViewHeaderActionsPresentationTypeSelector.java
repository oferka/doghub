package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;

public class TipsViewHeaderActionsPresentationTypeSelector extends HorizontalLayout {

    public static final String CLASS_NAME = TipsViewHeaderActions.CLASS_NAME + "-presentation-type-selector";

    private final TipsViewHeaderActionsTypeSelectorGridButton grid;
    private final TipsViewHeaderActionsTypeSelectorListButton list;

    public TipsViewHeaderActionsPresentationTypeSelector(TipDataProvider tipDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setSpacing(false);

        grid = new TipsViewHeaderActionsTypeSelectorGridButton(tipsViewState);
        add(grid);

        list = new TipsViewHeaderActionsTypeSelectorListButton(tipDataProvider, tipsViewState, authenticatedUser);
        add(list);

        setPresentationType(tipsViewState.getPresentationMode());
        tipsViewState.addPresentationModeChangeListener(this::presentationModeChanged);
    }

    private void setPresentationType(TipsViewPresentationMode presentationMode) {
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

    public void presentationModeChanged(TipsViewPresentationModeChangeEvent event) {
        setPresentationType(event.getNewPresentationMode());
    }
}
