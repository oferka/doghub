package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import org.hk.doghub.model.DogHubUser;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import java.util.Optional;

import static com.vaadin.flow.component.Key.KEY_S;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.icon.VaadinIcon.SHARE;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;

public class UserViewHeaderActionsShareButton extends Button {

    public static final String CLASS_NAME = UserViewHeaderActions.CLASS_NAME + "-share-button";

    private final UsersDataProvider usersDataProvider;
    private long selectedUserId;

    public UserViewHeaderActionsShareButton(UsersDataProvider usersDataProvider) {
        this.usersDataProvider = usersDataProvider;
        addClassName(CLASS_NAME);

        setIcon(SHARE.create());
        setText("Share");
        addClickListener(this::shareClicked);
        addClickShortcut(KEY_S, ALT);
    }

    private void shareClicked(ClickEvent<Button> event) {
        String name = null;
        Optional<DogHubUser> user = usersDataProvider.findById(selectedUserId);
        if(user.isPresent()) {
            name = user.get().getName();
        }
        Notification.show("Share clicked. Selected user name is: " + name, 3000, MIDDLE);
    }

    public void selectedUserChanged(long selectedUserId) {
        this.selectedUserId = selectedUserId;
    }
}
