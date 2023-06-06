package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class UsersViewHeaderActionsPresentationTypeSelector extends HorizontalLayout {

    public static final String CLASS_NAME = UsersViewHeaderActions.CLASS_NAME + "-presentation-type-selector";

    private final UsersViewHeaderActionsTypeSelectorGridButton grid;
    private final UsersViewHeaderActionsTypeSelectorListButton list;

    public UsersViewHeaderActionsPresentationTypeSelector(UserDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setSpacing(false);

        grid = new UsersViewHeaderActionsTypeSelectorGridButton(usersViewDataProvider, usersViewState);
        add(grid);

        list = new UsersViewHeaderActionsTypeSelectorListButton(usersViewDataProvider, usersViewState);
        add(list);

        setPresentationType(usersViewState.getPresentationMode());
        usersViewState.addPresentationModeChangeListener(this::presentationModeChanged);
    }

    private void setPresentationType(UsersViewPresentationMode presentationMode) {
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

    public void presentationModeChanged(UsersViewPresentationModeChangeEvent event) {
        setPresentationType(event.getNewPresentationMode());
    }
}
