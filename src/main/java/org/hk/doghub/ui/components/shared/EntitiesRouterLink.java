package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.RouterLink;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class EntitiesRouterLink extends RouterLink {

    public static final String CLASS_NAME = "entities-router-link";

    public EntitiesRouterLink(Class<? extends Component> navigationTarget, String entitiesLabel) {
        super(EMPTY, navigationTarget);
        addClassName(CLASS_NAME);
        add(new EntitiesButton(entitiesLabel));
    }
}
