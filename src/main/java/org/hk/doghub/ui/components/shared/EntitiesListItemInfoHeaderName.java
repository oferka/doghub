package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.HasUrlParameter;
import org.hk.doghub.model.NamedEntity;

public class EntitiesListItemInfoHeaderName<T extends NamedEntity> extends Div {

    public static final String CLASS_NAME = "entities-list-item-info-header-name";

    private final EntityRouterLink<T> link;

    public <C extends Component & HasUrlParameter<Long>> EntitiesListItemInfoHeaderName(T entity, Class<? extends C> entityClass) {
        addClassName(CLASS_NAME);
        link = new EntityRouterLink<>(entity, entityClass);
        add(link);
    }
}
