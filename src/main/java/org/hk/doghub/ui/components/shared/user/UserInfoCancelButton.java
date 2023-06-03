package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static com.vaadin.flow.component.Key.KEY_C;
import static com.vaadin.flow.component.KeyModifier.ALT;

@Slf4j
public class UserInfoCancelButton extends Button {

    public static final String CLASS_NAME = UserInfoContainerButtons.CLASS_NAME + "-cancel";

    private final List<UserInfoCancelListener> userInfoCancelListeners = new ArrayList<>();

    public UserInfoCancelButton() {
        addClassName(CLASS_NAME);
        setText("Cancel");
        addClickShortcut(KEY_C, ALT);
        addClickListener(this::cancelClicked);
    }

    public void addUserInfoCancelListener(UserInfoCancelListener listener) {
        userInfoCancelListeners.add(listener);
    }

    public void removeUserInfoCancelListener(UserInfoCancelListener listener) {
        userInfoCancelListeners.remove(listener);
    }

    private void cancelClicked(ClickEvent<Button> event) {
        fireUserInfoCancelEvent(new UserInfoCancelEvent(this));
    }

    private void fireUserInfoCancelEvent(UserInfoCancelEvent event) {
        for(UserInfoCancelListener listener : userInfoCancelListeners) {
            listener.cancelTriggered(event);
        }
    }
}