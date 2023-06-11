package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.HasUrlParameter;
import org.hk.doghub.model.HasFeedback;
import org.hk.doghub.model.HasThumbnailPicture;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.Collection;

public abstract class EntitiesGrid<T extends NamedEntity & HasThumbnailPicture & HasFeedback, C extends Component & HasUrlParameter<Long>> extends Grid<T> {

    public static final String CLASS_NAME = "entities-grid";

    public EntitiesGrid(EntityDataProvider<T> entityDataProvider, AuthenticatedUser authenticatedUser, Class<? extends C> entityClass) {
        addClassName(CLASS_NAME);
        setWidthFull();
        addColumns(authenticatedUser, entityClass);
        setItems(getItems(entityDataProvider, authenticatedUser));
    }

    private void addColumns(AuthenticatedUser authenticatedUser, Class<? extends C> entityClass) {
        addColumn(new ComponentRenderer<>(entity -> new EntityIdRouterLink<>(entity, entityClass))).setHeader("ID").setComparator(T::getId);
        addColumn(new ComponentRenderer<>(entity -> new EntityNameRouterLink<>(entity, entityClass))).setHeader("Name").setComparator(T::getName);
        addColumn(new ComponentRenderer<>(EntityAvatar<T>::new)).setHeader("Picture").setComparator(T::getName);
        addColumn(new ComponentRenderer<>(entity -> new CreationTimeLabel(entity.getCreationTime()))).setHeader("Creation Time").setComparator(T::getCreationTime);
        addSpecificColumns(authenticatedUser, entityClass);
        addColumn(new ComponentRenderer<>(entity -> new LikesContainer(entity.getFeedback().getLikes()))).setHeader("Likes").setComparator(entity -> entity.getFeedback().getLikes());
        addColumn(new ComponentRenderer<>(entity -> new CommentsContainer(entity.getFeedback().getComments()))).setHeader("Comments").setComparator(entity -> entity.getFeedback().getComments());
        addColumn(new ComponentRenderer<>(entity -> new SharesContainer(entity.getFeedback().getShares()))).setHeader("Shares").setComparator(entity -> entity.getFeedback().getShares());
    }

    protected abstract void addSpecificColumns(AuthenticatedUser authenticatedUser, Class<? extends C> entityClass);

    protected abstract Collection<T> getItems(EntityDataProvider<T> entityDataProvider, AuthenticatedUser authenticatedUser);
}
