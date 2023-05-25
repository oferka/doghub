package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UsersViewBody extends VerticalLayout {

    public static final String CLASS_NAME = UsersView.CLASS_NAME + "-body";

    private final UsersViewBodyListPresentation cardPresentation;
    private final UsersViewBodyGridPresentation gridPresentation;

    public UsersViewBody(UsersDataProvider usersDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        cardPresentation = new UsersViewBodyListPresentation(usersDataProvider);
        add(cardPresentation);

        gridPresentation = new UsersViewBodyGridPresentation(usersDataProvider);
        add(gridPresentation);

        setPresentationType(usersViewState.getPresentationMode());
        usersViewState.addPresentationModeChangeListener(this::presentationModeChanged);
    }

    private void setPresentationType(UsersViewPresentationMode presentationMode) {
        switch (presentationMode) {
            case GRID:
                remove(cardPresentation);
                add(gridPresentation);
                break;
            case LIST:
                remove(gridPresentation);
                add(cardPresentation);
                break;
        }
    }

    public void presentationModeChanged(UsersViewPresentationModeChangeEvent event) {
        setPresentationType(event.getNewPresentationMode());
    }
}
