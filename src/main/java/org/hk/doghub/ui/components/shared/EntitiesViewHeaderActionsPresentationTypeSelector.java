package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class EntitiesViewHeaderActionsPresentationTypeSelector extends HorizontalLayout {

    public static final String CLASS_NAME = EntitiesViewHeaderActions.CLASS_NAME + "-type-selector";

    private final EntitiesViewHeaderActionsTypeSelectorGridButton grid;
    private final EntitiesViewHeaderActionsTypeSelectorListButton list;

    public EntitiesViewHeaderActionsPresentationTypeSelector(EntitiesViewState viewState) {
        addClassName(CLASS_NAME);

        setSpacing(false);

        grid = new EntitiesViewHeaderActionsTypeSelectorGridButton(viewState);
        add(grid);

        list = new EntitiesViewHeaderActionsTypeSelectorListButton(viewState);
        add(list);

        setPresentationType(viewState.getPresentationMode());
        viewState.addPresentationModeChangeListener(this::presentationModeChanged);
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
