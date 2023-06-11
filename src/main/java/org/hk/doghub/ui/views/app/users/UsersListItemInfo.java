package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesListItemInfoBody;
import org.hk.doghub.ui.components.shared.EntitiesListItemInfoHeader;
import org.hk.doghub.ui.components.shared.FeedbackContainer;
import org.hk.doghub.ui.views.app.users.user.UserView;

public class UsersListItemInfo extends VerticalLayout {

    public static final String CLASS_NAME = UsersListItem.CLASS_NAME + "-info";

    private final EntitiesListItemInfoHeader<DogHubUser> header;
    private final EntitiesListItemInfoBody<DogHubUser> body;
    private final FeedbackContainer<DogHubUser> feedback;

    public UsersListItemInfo(DogHubUser user, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        setPadding(false);

        header = new EntitiesListItemInfoHeader<>(user, UserView.class);
        add(header);

        body = new EntitiesListItemInfoBody<>(user, authenticatedUser);
        add(body);

        feedback = new FeedbackContainer<>(user);
        add(feedback);
    }
}
