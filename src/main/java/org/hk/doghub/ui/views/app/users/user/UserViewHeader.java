package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Slf4j
public class UserViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = UserView.CLASS_NAME + "-header";

    private final UserViewHeaderInfo info;
    private final UserViewHeaderActions actions;

    public UserViewHeader(UsersDataProvider usersDataProvider) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        info = new UserViewHeaderInfo(usersDataProvider);
        add(info);

        actions = new UserViewHeaderActions(usersDataProvider);
        add(actions);
    }

    public void selectedUserChanged(long selectedUserId) {
        info.selectedUserChanged(selectedUserId);
        actions.selectedUserChanged(selectedUserId);
    }

    public void save() {
        log.info("Save");
    }

    public void cancel() {
        log.info("Cancel");
    }
}
