package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.security.AuthenticatedUser;

public abstract class EntityCreationView<T extends NamedEntity, P extends EntityCreationParameters> extends VerticalLayout {

    public static final String CLASS_NAME = "entity-creation-view";

    public EntityCreationView(AuthenticatedUser authenticatedUser, EntityCreationService<T, P> creationService) {
        addClassName(CLASS_NAME);
        EntityCreationViewHeader header = new EntityCreationViewHeader(getHeaderIcon(), getHeaderTitleText(), getHeaderDescriptionText());
        add(header);
        EntityCreationViewBody<T, P> body = new EntityCreationViewBody<>(getForm(authenticatedUser, creationService));
        addAndExpand(body);
        EntityCreationViewFooter footer = new EntityCreationViewFooter();
        add(footer);
    }

    protected abstract @NotNull VaadinIcon getHeaderIcon();

    protected abstract @NotNull String getHeaderTitleText();

    protected abstract @NotNull String getHeaderDescriptionText();

    protected abstract @NotNull EntityCreationContainerForm<T, P> getForm(AuthenticatedUser authenticatedUser, EntityCreationService<T, P> creationService);
}
