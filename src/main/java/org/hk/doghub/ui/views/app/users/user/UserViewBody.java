package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EntityInfoContainer;
import org.hk.doghub.ui.components.shared.InfoCancelListener;
import org.hk.doghub.ui.components.shared.InfoSaveListener;
import org.hk.doghub.ui.components.shared.user.UserInfoContainer;
import org.hk.doghub.ui.components.shared.user.UserUpdateParameters;
import org.hk.doghub.ui.components.shared.user.UserUpdateService;
import org.hk.doghub.ui.views.app.users.UserDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserViewBody extends VerticalLayout {

    public static final String CLASS_NAME = UserView.CLASS_NAME + "-body";

    private final EntityInfoContainer<DogHubUser, UserUpdateParameters> entityInfo;

    public UserViewBody(UserDataProvider userDataProvider, UserUpdateService userUpdateService) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        entityInfo = new UserInfoContainer(userDataProvider, userUpdateService);
        add(entityInfo);
    }

    public void selectedUserChanged(long selectedUserId) {
        entityInfo.setEntity(selectedUserId);
    }

    public void addInfoSaveListener(InfoSaveListener listener) {
        entityInfo.addInfoSaveListener(listener);
    }

    public void addInfoCancelListener(InfoCancelListener listener) {
        entityInfo.addInfoCancelListener(listener);
    }

    public void removeInfoSaveListener(InfoSaveListener listener) {
        entityInfo.removeInfoSaveListener(listener);
    }

    public void removeInfoCancelListener(InfoCancelListener listener) {
        entityInfo.removeInfoCancelListener(listener);
    }

    public void save() {
        entityInfo.save();
    }

    public void cancel() {
        entityInfo.cancel();
    }
}
