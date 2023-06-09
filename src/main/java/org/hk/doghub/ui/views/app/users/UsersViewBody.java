package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.ui.components.shared.EntitiesViewPresentationMode;
import org.hk.doghub.ui.components.shared.EntitiesViewPresentationModeChangeEvent;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UsersViewBody extends VerticalLayout {

    public static final String CLASS_NAME = UsersView.CLASS_NAME + "-body";

    private final UsersViewBodyListPresentation cardPresentation;
    private final UsersViewBodyGridPresentation gridPresentation;

    public UsersViewBody(UserDataProvider userDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        cardPresentation = new UsersViewBodyListPresentation(userDataProvider);
        add(cardPresentation);

        gridPresentation = new UsersViewBodyGridPresentation(userDataProvider);
        add(gridPresentation);

        setPresentationType(usersViewState.getPresentationMode());
        usersViewState.addPresentationModeChangeListener(this::presentationModeChanged);
    }

    private void setPresentationType(EntitiesViewPresentationMode presentationMode) {
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

    public void presentationModeChanged(EntitiesViewPresentationModeChangeEvent event) {
        setPresentationType(event.getNewPresentationMode());
    }
}
