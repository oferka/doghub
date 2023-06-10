package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.NamedEntity;

public class EntityRouterLink<T extends NamedEntity> extends RouterLink {

    public static final String CLASS_NAME = "entity-router-link";

    public <C extends Component & HasUrlParameter<Long>> EntityRouterLink(T entity, Class<? extends C> navigationTarget) {
        super(entity.getName(), navigationTarget, entity.getId());
        addClassName(CLASS_NAME);
    }
}
