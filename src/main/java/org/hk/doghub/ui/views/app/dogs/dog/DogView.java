package org.hk.doghub.ui.views.app.dogs.dog;

import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.NotFoundException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityInfoContainer;
import org.hk.doghub.ui.components.shared.EntityUpdateService;
import org.hk.doghub.ui.components.shared.EntityView;
import org.hk.doghub.ui.components.shared.EntityViewBody;
import org.hk.doghub.ui.components.shared.dog.DogInfoContainerForm;
import org.hk.doghub.ui.components.shared.dog.DogUpdateParameters;
import org.hk.doghub.ui.views.app.EntityDataProvider;
import org.hk.doghub.ui.views.app.dogs.DogDataProvider;
import org.hk.doghub.ui.views.app.dogs.DogsView;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;

@Route(value = DogsView.ROUTE, layout = DogHubAppLayout.class)
@PageTitle(DogView.NAME)
@RolesAllowed({"USER", "ADMIN"})
public class DogView extends EntityView<DogHubDog, DogUpdateParameters, DogView, DogsView> {

    public static final String CLASS_NAME = "tip-view";
    public static final String NAME = "Tip";

    public DogView(EntityDataProvider<DogHubDog> entityDataProvider, AuthenticatedUser authenticatedUser, EntityUpdateService<DogHubDog, DogUpdateParameters> entityUpdateService) {
        super(entityDataProvider, authenticatedUser, entityUpdateService);
        addClassName(CLASS_NAME);
    }

    protected EntityViewBody<DogHubDog, DogUpdateParameters> getBody() {
        return new EntityViewBody<>(new EntityInfoContainer<>(entityDataProvider, new DogInfoContainerForm(entityDataProvider, entityUpdateService)));
    }

    @Override
    public void setParameter(BeforeEvent event, Long parameter) {
        setEntity(parameter);
        DogDataProvider tipDataProvider = (DogDataProvider) entityDataProvider;
        if(!tipDataProvider.hasAccess(authenticatedUser, parameter)) {
            throw new NotFoundException();
        }
    }

    @Override
    protected String getEntityLabel() {
        return DogView.NAME;
    }

    @Override
    protected Class<? extends DogView> getEntityClass() {
        return DogView.class;
    }

    @Override
    protected String getEntitiesLabel() {
        return DogsView.NAME;
    }

    @Override
    protected Class<? extends DogsView> getEntitiesClass() {
        return DogsView.class;
    }
}
