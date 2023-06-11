package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.DogHubLabel;
import org.hk.doghub.ui.components.shared.EntitiesListItemInfoBody;
import org.hk.doghub.ui.components.shared.EntitiesListItemInfoHeader;
import org.hk.doghub.ui.components.shared.FeedbackContainer;
import org.hk.doghub.ui.views.app.users.user.UserView;

import java.util.ArrayList;
import java.util.List;

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

        body = new EntitiesListItemInfoBody<>(user, getBodyComponents(user, authenticatedUser));
        add(body);

        feedback = new FeedbackContainer<>(user);
        add(feedback);
    }

    private List<Component> getBodyComponents(DogHubUser user, AuthenticatedUser authenticatedUser) {
        List<Component> result = new ArrayList<>();
        result.add(new DogHubLabel(user.getCompany()));
        return result;
    }
}
