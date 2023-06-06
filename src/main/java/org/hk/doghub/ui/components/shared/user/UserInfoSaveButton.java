package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import java.util.ArrayList;
import java.util.List;

import static com.vaadin.flow.component.Key.KEY_S;
import static com.vaadin.flow.component.KeyModifier.ALT;

public class UserInfoSaveButton extends Button {

    public static final String CLASS_NAME = UserInfoContainerButtons.CLASS_NAME + "-save";

    private final List<UserInfoSaveListener> userInfoSaveListeners = new ArrayList<>();

    public UserInfoSaveButton() {
        addClassName(CLASS_NAME);
        setText("Save");
        addClickShortcut(KEY_S, ALT);
        addClickListener(this::saveClicked);
    }

    public void addUserInfoSaveListener(UserInfoSaveListener listener) {
        userInfoSaveListeners.add(listener);
    }

    public void removeUserInfoSaveListener(UserInfoSaveListener listener) {
        userInfoSaveListeners.remove(listener);
    }

    private void saveClicked(ClickEvent<Button> event) {
        fireUserInfoSaveEvent(new UserInfoSaveEvent(this));
    }

    private void fireUserInfoSaveEvent(UserInfoSaveEvent event) {
        for(UserInfoSaveListener listener : userInfoSaveListeners) {
            listener.saveTriggered(event);
        }
    }
}
