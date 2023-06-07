package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.AbstractEntity;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.EntityDataProvider;
import org.hk.doghub.ui.views.app.users.user.UserView;

import java.util.Optional;

public class PreviousEntityRouterLink extends RouterLink {

    public static final String CLASS_NAME = "previous-entity-router-link";

    private final EntityDataProvider entityDataProvider;

    private final PreviousEntityButton previousEntityButton;

    private final AuthenticatedUser authenticatedUser;

    public PreviousEntityRouterLink(EntityDataProvider entityDataProvider, AuthenticatedUser authenticatedUser, String text) {
        this.entityDataProvider = entityDataProvider;
        this.authenticatedUser = authenticatedUser;
        addClassName(CLASS_NAME);

        previousEntityButton = new PreviousEntityButton(text);
        previousEntityButton.setEnabled(false);
        add(previousEntityButton);
    }

    public void selectedEntityChanged(long selectedEntityId) {
        Optional<AbstractEntity> entityOptional = entityDataProvider.findPrevious(authenticatedUser, selectedEntityId);
        if(entityOptional.isPresent()) {
            setRoute(UserView.class, entityOptional.get().getId());
            previousEntityButton.setEnabled(true);
        }
        else {
            previousEntityButton.setEnabled(false);
        }
    }
}
