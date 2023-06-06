package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.InfoCancelListener;
import org.hk.doghub.ui.components.shared.InfoSaveButton;
import org.hk.doghub.ui.components.shared.InfoSaveListener;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

public class UserInfoContainerButtons extends HorizontalLayout {

    public static final String CLASS_NAME = UserInfoContainer.CLASS_NAME + "-buttons";

    private final InfoSaveButton save;

    private final UserInfoCancelButton cancel;

    public UserInfoContainerButtons(UsersDataProvider usersDataProvider, AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);

        save = new InfoSaveButton();
        add(save);

        cancel = new UserInfoCancelButton();
        add(cancel);
    }

    public void addInfoSaveListener(InfoSaveListener listener) {
        save.addInfoSaveListener(listener);
    }

    public void removeInfoSaveListener(InfoSaveListener listener) {
        save.removeInfoSaveListener(listener);
    }

    public void addInfoCancelListener(InfoCancelListener listener) {
        cancel.addInfoCancelListener(listener);
    }

    public void removeInfoCancelListener(InfoCancelListener listener) {
        cancel.removeInfoCancelListener(listener);
    }
}
