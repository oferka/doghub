package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.HasFeedback;
import org.hk.doghub.model.HasThumbnailPicture;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.Collection;
import java.util.List;

public abstract class EntitiesList<T extends NamedEntity & HasThumbnailPicture & HasFeedback> extends Div {

    public static final String CLASS_NAME = "entities-list";

    public EntitiesList(EntityDataProvider<T> entityDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setWidthFull();
        Grid<T> grid = new Grid<>();
        grid.addClassName("entities-list-grid");
        setSizeFull();
        grid.setHeightFull();
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid.addComponentColumn((T entity) -> createListItem(entity, authenticatedUser));
        grid.setItems(getItems(entityDataProvider, authenticatedUser));
        add(grid);
    }

    private HorizontalLayout createListItem(T entity, AuthenticatedUser authenticatedUser) {
        return new EntitiesListItem<>(entity, getListItemInfoBodyComponents(entity, authenticatedUser));
    }

    protected abstract List<Component> getListItemInfoBodyComponents(T entity, AuthenticatedUser authenticatedUser);

    protected abstract Collection<T> getItems(EntityDataProvider<T> entityDataProvider, AuthenticatedUser authenticatedUser);
}
