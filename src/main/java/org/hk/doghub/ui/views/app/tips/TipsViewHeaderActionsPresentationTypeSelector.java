package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;

public class TipsViewHeaderActionsPresentationTypeSelector extends HorizontalLayout {

    public static final String CLASS_NAME = TipsViewHeaderActions.CLASS_NAME + "-presentation-type-selector";

    private final TipsViewHeaderActionsTypeSelectorGridButton gridButton;
    private final TipsViewHeaderActionsTypeSelectorListButton listButton;

    public TipsViewHeaderActionsPresentationTypeSelector(TipsDataProvider tipsDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setSpacing(false);

        gridButton = new TipsViewHeaderActionsTypeSelectorGridButton(tipsDataProvider, tipsViewState, authenticatedUser);
        add(gridButton);

        listButton = new TipsViewHeaderActionsTypeSelectorListButton(tipsDataProvider, tipsViewState, authenticatedUser);
        add(listButton);

        setPresentationType(tipsViewState.getPresentationMode());
        tipsViewState.addPresentationModeChangeListener(this::presentationModeChanged);
    }

    private void setPresentationType(TipsViewPresentationMode presentationMode) {
        switch (presentationMode) {
            case GRID -> {
                gridButton.setEnabled(false);
                listButton.setEnabled(true);
            }
            case LIST -> {
                gridButton.setEnabled(true);
                listButton.setEnabled(false);
            }
        }
    }

    public void presentationModeChanged(TipsViewPresentationModeChangeEvent event) {
        setPresentationType(event.getNewTipViewPresentationMode());
    }
}
