package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.DogHubUser;

public class UsersListItemInfo extends VerticalLayout {

    public static final String CLASS_NAME = UsersListItem.CLASS_NAME + "-info";

    private final UsersListItemInfoHeader header;
    private final UsersListItemInfoSummary summary;
    private final UsersListItemInfoActions actions;

    public UsersListItemInfo(DogHubUser user) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        setPadding(false);

        header = new UsersListItemInfoHeader(user);
        add(header);

        summary = new UsersListItemInfoSummary(user);
        add(summary);

        actions = new UsersListItemInfoActions(user);
        add(actions);
    }
}
