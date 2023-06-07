package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.InfoCancelListener;
import org.hk.doghub.ui.components.shared.InfoSaveListener;
import org.hk.doghub.ui.components.shared.user.UserInfoContainer;
import org.hk.doghub.ui.components.shared.user.UserUpdateService;
import org.hk.doghub.ui.views.app.users.UserDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserViewBody extends VerticalLayout {

    public static final String CLASS_NAME = UserView.CLASS_NAME + "-body";

    private final UserInfoContainer userInfo;

    public UserViewBody(UserDataProvider userDataProvider, AuthenticatedUser authenticatedUser, UserUpdateService userUpdateService) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        userInfo = new UserInfoContainer(userDataProvider, userUpdateService);
        add(userInfo);
    }

    public void selectedUserChanged(long selectedUserId) {
        userInfo.setUser(selectedUserId);
    }

    public void addInfoSaveListener(InfoSaveListener listener) {
        userInfo.addInfoSaveListener(listener);
    }

    public void addInfoCancelListener(InfoCancelListener listener) {
        userInfo.addInfoCancelListener(listener);
    }

    public void removeInfoSaveListener(InfoSaveListener listener) {
        userInfo.removeInfoSaveListener(listener);
    }

    public void removeInfoCancelListener(InfoCancelListener listener) {
        userInfo.removeInfoCancelListener(listener);
    }

    public void save() {
        userInfo.save();
    }

    public void cancel() {
        userInfo.cancel();
    }
}
