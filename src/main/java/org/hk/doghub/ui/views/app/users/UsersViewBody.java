package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UsersViewBody extends VerticalLayout {

    public static final String CLASS_NAME = UsersView.CLASS_NAME + "-body";

    private final UsersViewBodyListPresentation usersViewBodyCardPresentation;
    private final UsersViewBodyGridPresentation usersViewBodyGridPresentation;

    public UsersViewBody(UsersDataProvider usersDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        usersViewBodyCardPresentation = new UsersViewBodyListPresentation(usersDataProvider);
        add(usersViewBodyCardPresentation);

        usersViewBodyGridPresentation = new UsersViewBodyGridPresentation(usersDataProvider);
        add(usersViewBodyGridPresentation);

        setPresentationType(usersViewState.getPresentationMode());
        usersViewState.addPresentationModeChangeListener(this::presentationModeChanged);
    }

    private void setPresentationType(UsersViewPresentationMode presentationMode) {
        switch (presentationMode) {
            case GRID:
                remove(usersViewBodyCardPresentation);
                add(usersViewBodyGridPresentation);
                break;
            case LIST:
                remove(usersViewBodyGridPresentation);
                add(usersViewBodyCardPresentation);
                break;
        }
    }

    public void presentationModeChanged(UsersViewPresentationModeChangeEvent event) {
        setPresentationType(event.getNewUserViewPresentationMode());
    }
}
