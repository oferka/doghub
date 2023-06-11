package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.HasFeedback;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.ui.views.app.users.user.UserView;

import java.util.List;

public class EntitiesListItemInfo<T extends NamedEntity & HasFeedback> extends VerticalLayout {

    public static final String CLASS_NAME = "entities-list-item-info";

    private final EntitiesListItemInfoHeader<T> header;
    private final EntitiesListItemInfoBody<T> body;
    private final FeedbackContainer<T> feedback;

    public EntitiesListItemInfo(T entity, List<Component> components) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        setPadding(false);
        header = new EntitiesListItemInfoHeader<>(entity, UserView.class);
        body = new EntitiesListItemInfoBody<>(entity, components);
        feedback = new FeedbackContainer<>(entity);
        add(header, body, feedback);
    }
}
