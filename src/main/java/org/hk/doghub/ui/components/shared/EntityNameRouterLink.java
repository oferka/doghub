package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.NamedEntity;

public class EntityNameRouterLink<T extends NamedEntity> extends RouterLink {

    public static final String CLASS_NAME = "entity-name-router-link";

    public <C extends Component & HasUrlParameter<Long>> EntityNameRouterLink(T entity, Class<? extends C> entityClass) {
        super(entity.getName(), entityClass, entity.getId());
        addClassName(CLASS_NAME);
    }
}
