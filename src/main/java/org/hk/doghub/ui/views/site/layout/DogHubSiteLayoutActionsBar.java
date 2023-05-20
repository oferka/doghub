package org.hk.doghub.ui.views.site.layout;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.AuthenticatedUserBar;
import org.hk.doghub.ui.components.shared.AuthenticationBar;

import java.util.Optional;

public class DogHubSiteLayoutActionsBar extends HorizontalLayout {

    public static final String CLASS_NAME = DogHubSiteLayout.ID + "-actions-bar";

    private final AuthenticationBar authenticationBar;

    private final AuthenticatedUserBar authenticatedUserBar;

    public DogHubSiteLayoutActionsBar(AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        authenticationBar = new AuthenticationBar();
        add(authenticationBar);
        authenticatedUserBar = new AuthenticatedUserBar(authenticatedUser);
        add(authenticatedUserBar);
        setMode(authenticatedUser);
    }

    private void setMode(AuthenticatedUser authenticatedUser) {
        Optional<DogHubUser> maybeUser = authenticatedUser.get();
        if (maybeUser.isPresent()) {
            add(authenticatedUserBar);
            remove(authenticationBar);
        }
        else {
            add(authenticationBar);
            remove(authenticatedUserBar);
        }
    }
}
