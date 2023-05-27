package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import static com.vaadin.flow.component.Key.KEY_S;
import static com.vaadin.flow.component.KeyModifier.ALT;

@Slf4j
public class UserInfoSaveButton extends Button {

    public static final String CLASS_NAME = UserInfoContainerButtons.CLASS_NAME + "-save";

    public UserInfoSaveButton(UsersDataProvider usersDataProvider, AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);
        setText("Save");
        addClickShortcut(KEY_S, ALT);
        addClickListener(this::saveClicked);
    }

    private void saveClicked(ClickEvent<Button> event) {
        log.info("Save clicked");
    }
}
