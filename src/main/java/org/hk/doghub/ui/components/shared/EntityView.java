package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import org.hk.doghub.model.HasThumbnailPicture;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public abstract class EntityView<T extends NamedEntity & HasThumbnailPicture, P extends EntityUpdateParameters, C extends Component & HasUrlParameter<Long>> extends VerticalLayout implements HasUrlParameter<Long>, InfoSaveListener, InfoCancelListener {

    public static final String CLASS_NAME = "entity-view";

    private final EntityViewHeader<T> header;
    private final EntityViewBody<T, P> body;
    private final EntityViewFooter<T, C> footer;

    protected final EntityDataProvider<T> entityDataProvider;

    protected final AuthenticatedUser authenticatedUser;

    protected final EntityUpdateService<T, P> entityUpdateService;

    public EntityView(EntityDataProvider<T> entityDataProvider, AuthenticatedUser authenticatedUser, EntityUpdateService<T, P> entityUpdateService) {
        this.entityDataProvider = entityDataProvider;
        this.authenticatedUser = authenticatedUser;
        this.entityUpdateService = entityUpdateService;
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        header = new EntityViewHeader<>(entityDataProvider);
        add(header);
        body = getBody();
        body.addInfoSaveListener(this);
        body.addInfoCancelListener(this);
        addAndExpand(body);
        footer = new EntityViewFooter<T, C>(entityDataProvider, authenticatedUser, getEntityLabel(), getEntityClass(), getEntitiesLabel(), getEntitiesClass());
        add(footer);
    }

    protected abstract EntityViewBody<T, P> getBody();

    protected abstract String getEntityLabel();

    protected abstract Class<? extends C> getEntityClass();

    protected abstract String getEntitiesLabel();

    protected abstract Class getEntitiesClass();

    @Override
    public void setParameter(BeforeEvent event, Long parameter) {
        setEntity(parameter);
    }

    protected void setEntity(long selectedEntityId) {
        header.selectedEntityChanged(selectedEntityId);
        body.selectedEntityChanged(selectedEntityId);
        footer.selectedEntityChanged(selectedEntityId);
    }

    @Override
    public void saveTriggered(InfoSaveEvent event) {
        header.save();
        body.save();
        footer.save();
    }

    @Override
    public void cancelTriggered(InfoCancelEvent event) {
        header.cancel();
        body.cancel();
        footer.cancel();
    }
}
