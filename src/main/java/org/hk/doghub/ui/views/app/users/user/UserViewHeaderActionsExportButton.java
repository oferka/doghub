package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.views.app.users.UserDataProvider;

import java.util.Optional;

import static com.vaadin.flow.component.Key.KEY_E;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.button.ButtonVariant.LUMO_PRIMARY;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;

public class UserViewHeaderActionsExportButton extends Button {

    public static final String CLASS_NAME = UserViewHeaderActions.CLASS_NAME + "-export-button";

    private final UserDataProvider userDataProvider;
    private long selectedUserId;

    public UserViewHeaderActionsExportButton(UserDataProvider userDataProvider) {
        this.userDataProvider = userDataProvider;
        addClassName(CLASS_NAME);

        setIcon(VaadinIcon.DOWNLOAD.create());
        setText("Export");
        addThemeVariants(LUMO_PRIMARY);
        addClickListener(this::exportClicked);
        addClickShortcut(KEY_E, ALT);
    }

    private void exportClicked(ClickEvent<Button> event) {
        String name = null;
        Optional<DogHubUser> user = userDataProvider.findById(selectedUserId);
        if(user.isPresent()) {
            name = user.get().getName();
        }
        Notification.show("Export clicked. Selected user name is: " + name, 3000, MIDDLE);
    }

    public void selectedUserChanged(long selectedUserId) {
        this.selectedUserId = selectedUserId;
    }
}
