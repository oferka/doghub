package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.AbstractEntity;

public class EntityIdRouterLink<T extends AbstractEntity> extends RouterLink {

    public static final String CLASS_NAME = "entity-id-router-link";

    public <C extends Component & HasUrlParameter<Long>> EntityIdRouterLink(T entity, Class<? extends C> entityClass) {
        super(entity.getId().toString(), entityClass, entity.getId());
        addClassName(CLASS_NAME);
    }
}
