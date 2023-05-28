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

    private long selectedUserId;

    public UserViewHeader(UsersDataProvider usersDataProvider) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        info = new UserViewHeaderInfo(usersDataProvider);
        add(info);

        actions = new UserViewHeaderActions(usersDataProvider);
        add(actions);
    }

    public long getSelectedUserId() {
        return selectedUserId;
    }

    public void setSelectedUserId(long selectedUserId) {
        this.selectedUserId = selectedUserId;
    }

    public void selectedUserChanged(long selectedUserId) {
        setSelectedUserId(selectedUserId);
        info.selectedUserChanged(selectedUserId);
        actions.selectedUserChanged(selectedUserId);
    }

    public void save() {
        selectedUserChanged(selectedUserId);
    }

    public void cancel() {
        log.info("Cancel");
    }
}
