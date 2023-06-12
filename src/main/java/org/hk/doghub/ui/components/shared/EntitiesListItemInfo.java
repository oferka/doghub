package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HasUrlParameter;
import org.hk.doghub.model.HasFeedback;
import org.hk.doghub.model.NamedEntity;

import java.util.List;

public class EntitiesListItemInfo<T extends NamedEntity & HasFeedback, C extends Component & HasUrlParameter<Long>> extends VerticalLayout {

    public static final String CLASS_NAME = "entities-list-item-info";

    private final EntitiesListItemInfoHeader<T> header;
    private final EntitiesListItemInfoBody<T> body;
    private final FeedbackContainer<T> feedback;

    public EntitiesListItemInfo(T entity, List<Component> components, Class<? extends C> entityClass) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        setPadding(false);
        header = new EntitiesListItemInfoHeader<>(entity, entityClass);
        body = new EntitiesListItemInfoBody<>(entity, components);
        feedback = new FeedbackContainer<>(entity);
        add(header, body, feedback);
    }
}
