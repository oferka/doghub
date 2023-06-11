package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesViewBodyGridPresentation;
import org.hk.doghub.ui.components.shared.EntitiesViewBodyListPresentation;
import org.hk.doghub.ui.components.shared.EntitiesViewPresentationMode;
import org.hk.doghub.ui.components.shared.EntitiesViewPresentationModeChangeEvent;
import org.hk.doghub.ui.views.app.users.user.UserView;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UsersViewBody extends VerticalLayout {

    public static final String CLASS_NAME = UsersView.CLASS_NAME + "-body";

    private final EntitiesViewBodyListPresentation<DogHubUser> cardPresentation;
    private final EntitiesViewBodyGridPresentation<DogHubUser, UserView> gridPresentation;

    public UsersViewBody(UserDataProvider userDataProvider, UsersViewState usersViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        cardPresentation = new EntitiesViewBodyListPresentation<>(new UsersList(userDataProvider, authenticatedUser));
        add(cardPresentation);

        gridPresentation = new EntitiesViewBodyGridPresentation<>(new UsersGrid(userDataProvider, authenticatedUser));
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
