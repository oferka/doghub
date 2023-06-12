package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.HasUrlParameter;
import org.hk.doghub.model.NamedEntity;

public class EntitiesListItemInfoHeader<T extends NamedEntity> extends HorizontalLayout {

    public static final String CLASS_NAME = "entities-list-item-info-header";

    public <C extends Component & HasUrlParameter<Long>> EntitiesListItemInfoHeader(T entity, Class<? extends C> entityClass) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");
        EntitiesListItemInfoHeaderName<T> name = new EntitiesListItemInfoHeaderName<>(entity, entityClass);
        add(name);
    }
}
