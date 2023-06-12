package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HasUrlParameter;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.HasFeedback;
import org.hk.doghub.model.HasThumbnailPicture;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.EntityDataProvider;

public abstract class EntitiesView<T extends NamedEntity & HasThumbnailPicture & HasFeedback, C extends Component & HasUrlParameter<Long>> extends VerticalLayout {

    public static final String CLASS_NAME = "entities-view";

    public EntitiesView(EntityDataProvider<T> entityDataProvider, EntitiesViewState viewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        EntitiesViewHeader header = getViewHeader(entityDataProvider, viewState, authenticatedUser);
        add(header);
        EntitiesViewBody<T, C> body = getViewBody(entityDataProvider, viewState, authenticatedUser);
        addAndExpand(body);
        EntitiesViewFooter footer = new EntitiesViewFooter();
        add(footer);
    }

    protected abstract @NotNull EntitiesViewHeader getViewHeader(EntityDataProvider<T> entityDataProvider, EntitiesViewState viewState, AuthenticatedUser authenticatedUser);

    protected abstract @NotNull EntitiesViewBody<T, C> getViewBody(EntityDataProvider<T> entityDataProvider, EntitiesViewState viewState, AuthenticatedUser authenticatedUser);

    protected abstract @NotNull VaadinIcon getHeaderIcon();

    protected abstract @NotNull String getTitleText();

    protected abstract @NotNull String getTitleDescription();

    protected abstract @NotNull Class<? extends Component> getEntityCreationClass();

    protected abstract @NotNull String getEntityLabel();
}
