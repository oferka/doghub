package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.AbstractEntity;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.Optional;

import static java.text.MessageFormat.format;

public class NextEntityRouterLink<T extends AbstractEntity> extends RouterLink {

    public static final String CLASS_NAME = "next-entity-router-link";

    private final EntityDataProvider<T> entityDataProvider;

    private final NextEntityButton nextEntityButton;

    private final AuthenticatedUser authenticatedUser;

    private final Class navigationTarget;

    public NextEntityRouterLink(EntityDataProvider<T> entityDataProvider, AuthenticatedUser authenticatedUser, String entityLabel, Class navigationTarget) {
        this.entityDataProvider = entityDataProvider;
        this.authenticatedUser = authenticatedUser;
        this.navigationTarget = navigationTarget;
        addClassName(CLASS_NAME);

        nextEntityButton = new NextEntityButton(format("Next {0}", entityLabel));
        nextEntityButton.setEnabled(false);
        add(nextEntityButton);
    }

    public void selectedEntityChanged(long selectedEntityId) {
        Optional<T> entityOptional = entityDataProvider.findNext(authenticatedUser, selectedEntityId);
        if(entityOptional.isPresent()) {
            setRoute(navigationTarget, entityOptional.get().getId());
            nextEntityButton.setEnabled(true);
        }
        else {
            nextEntityButton.setEnabled(false);
        }
    }
}
