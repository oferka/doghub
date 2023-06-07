package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.AbstractEntity;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.Optional;

public class NextEntityRouterLink extends RouterLink {

    public static final String CLASS_NAME = "next-entity-router-link";

    private final EntityDataProvider entityDataProvider;

    private final NextEntityButton nextEntityButton;

    private final AuthenticatedUser authenticatedUser;

    private final Class navigationTarget;

    public NextEntityRouterLink(EntityDataProvider entityDataProvider, AuthenticatedUser authenticatedUser, String text, Class navigationTarget) {
        this.entityDataProvider = entityDataProvider;
        this.authenticatedUser = authenticatedUser;
        this.navigationTarget = navigationTarget;
        addClassName(CLASS_NAME);

        nextEntityButton = new NextEntityButton(text);
        nextEntityButton.setEnabled(false);
        add(nextEntityButton);
    }

    public void selectedEntityChanged(long selectedEntityId) {
        Optional<AbstractEntity> entityOptional = entityDataProvider.findNext(authenticatedUser, selectedEntityId);
        if(entityOptional.isPresent()) {
            setRoute(navigationTarget, entityOptional.get().getId());
            nextEntityButton.setEnabled(true);
        }
        else {
            nextEntityButton.setEnabled(false);
        }
    }
}
