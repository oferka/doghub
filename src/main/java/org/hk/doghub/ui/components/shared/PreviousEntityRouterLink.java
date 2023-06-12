package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.AbstractEntity;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.Optional;

import static java.text.MessageFormat.format;

public class PreviousEntityRouterLink<T extends AbstractEntity, C extends Component & HasUrlParameter<Long>> extends RouterLink {

    public static final String CLASS_NAME = "previous-entity-router-link";

    private final EntityDataProvider<T> entityDataProvider;

    private final PreviousEntityButton previousEntityButton;

    private final AuthenticatedUser authenticatedUser;

    private final Class<? extends C> navigationTarget;

    public PreviousEntityRouterLink(EntityDataProvider<T> entityDataProvider, AuthenticatedUser authenticatedUser, String entityLabel, Class<? extends C> navigationTarget) {
        this.entityDataProvider = entityDataProvider;
        this.authenticatedUser = authenticatedUser;
        this.navigationTarget = navigationTarget;
        addClassName(CLASS_NAME);

        previousEntityButton = new PreviousEntityButton(format("Previous {0}", entityLabel));
        previousEntityButton.setEnabled(false);
        add(previousEntityButton);
    }

    public void selectedEntityChanged(long selectedEntityId) {
        Optional<T> entityOptional = entityDataProvider.findPrevious(authenticatedUser, selectedEntityId);
        if(entityOptional.isPresent()) {
            setRoute(navigationTarget, entityOptional.get().getId());
            previousEntityButton.setEnabled(true);
        }
        else {
            previousEntityButton.setEnabled(false);
        }
    }
}
