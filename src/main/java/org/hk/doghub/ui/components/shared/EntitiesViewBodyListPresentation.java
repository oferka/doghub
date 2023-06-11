package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.HasFeedback;
import org.hk.doghub.model.HasThumbnailPicture;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public abstract class EntitiesViewBodyListPresentation<T extends NamedEntity & HasThumbnailPicture & HasFeedback> extends VerticalLayout {

    public static final String CLASS_NAME = "entities-view-body-list-presentation";

    private final EntitiesList<T> list;

    public EntitiesViewBodyListPresentation(EntityDataProvider<T> entityDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        list = getEntitiesList(entityDataProvider, authenticatedUser);
        addAndExpand(list);
    }

    protected abstract EntitiesList<T> getEntitiesList(EntityDataProvider<T> entityDataProvider, AuthenticatedUser authenticatedUser);
}
