package org.hk.doghub.ui.views.app.dogs;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesView;
import org.hk.doghub.ui.components.shared.EntitiesViewBody;
import org.hk.doghub.ui.components.shared.EntitiesViewHeader;
import org.hk.doghub.ui.components.shared.EntitiesViewState;
import org.hk.doghub.ui.views.app.EntityDataProvider;
import org.hk.doghub.ui.views.app.dogs.create.DogCreationView;
import org.hk.doghub.ui.views.app.dogs.dog.DogView;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;

import static org.hk.doghub.ui.views.app.dogs.DogsView.ROUTE;
import static org.vaadin.lineawesome.LineAwesomeIcon.DOG_SOLID;

@PageTitle(DogsView.NAME)
@Route(value = ROUTE, layout = DogHubAppLayout.class)
@RolesAllowed({"USER", "ADMIN"})
public class DogsView extends EntitiesView<DogHubDog, DogView> {

    public static final String ROUTE = "dogs";
    private static final String ID_PREFIX = "dogs";
    private static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Dogs";

    public DogsView(EntityDataProvider<DogHubDog> entityDataProvider, DogsViewState viewState, AuthenticatedUser authenticatedUser) {
        super(entityDataProvider, viewState, authenticatedUser);
        addClassName(CLASS_NAME);
    }

    @Override
    protected @NotNull EntitiesViewHeader getViewHeader(EntityDataProvider<DogHubDog> entityDataProvider, EntitiesViewState viewState, AuthenticatedUser authenticatedUser) {
        return new EntitiesViewHeader(viewState, getHeaderIcon(), getTitleText(), ((DogDataProvider)entityDataProvider).countForUser(authenticatedUser), getTitleDescription(), getEntityCreationClass(), getEntityLabel());
    }

    @Override
    protected @NotNull EntitiesViewBody<DogHubDog, DogView> getViewBody(EntityDataProvider<DogHubDog> entityDataProvider, EntitiesViewState viewState, AuthenticatedUser authenticatedUser) {
        return new EntitiesViewBody<>(new DogsList(entityDataProvider, authenticatedUser), new DogsGrid(entityDataProvider, authenticatedUser), viewState);
    }

    @Override
    protected @NotNull Component getHeaderIcon() {
        return DOG_SOLID.create();
    }

    @Override
    protected @NotNull String getTitleText() {
        return DogsView.NAME;
    }

    @Override
    protected @NotNull String getTitleDescription() {
        return "Dogs view description";
    }

    @Override
    protected @NotNull Class<? extends Component> getEntityCreationClass() {
        return DogCreationView.class;
    }

    @Override
    protected @NotNull String getEntityLabel() {
        return DogView.NAME;
    }
}
