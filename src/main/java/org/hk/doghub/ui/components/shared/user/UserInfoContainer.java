package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.InfoCancelListener;
import org.hk.doghub.ui.components.shared.InfoSaveListener;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import java.util.Optional;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserInfoContainer extends VerticalLayout {

    public static final String CLASS_NAME = "user-info-container";

    private final UsersDataProvider usersDataProvider;

    private final UserInfoContainerForm form;

    private final UserInfoContainerButtons buttons;

    public UserInfoContainer(UsersDataProvider usersDataProvider, AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        this.usersDataProvider = usersDataProvider;
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        form = new UserInfoContainerForm(usersDataProvider, userCreationService);
        add(form);

        buttons = new UserInfoContainerButtons();
        add(buttons);
    }

    public void setUser(long userId) {
        Optional<DogHubUser> userOptional = usersDataProvider.findById(userId);
        userOptional.ifPresent(form::setUser);
    }

    public void save() {
        form.save();
    }

    public void cancel() {
        form.cancel();
    }

    public void addInfoSaveListener(InfoSaveListener listener) {
        buttons.addInfoSaveListener(listener);
    }

    public void removeInfoSaveListener(InfoSaveListener listener) {
        buttons.removeInfoSaveListener(listener);
    }

    public void addInfoCancelListener(InfoCancelListener listener) {
        buttons.addInfoCancelListener(listener);
    }

    public void removeInfoCancelListener(InfoCancelListener listener) {
        buttons.removeInfoCancelListener(listener);
    }
}
