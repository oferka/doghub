package org.hk.doghub.ui.views.app.dogs.create;

import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityCreationContainerForm;
import org.hk.doghub.ui.components.shared.EntityCreationService;
import org.hk.doghub.ui.components.shared.EntityCreationView;
import org.hk.doghub.ui.components.shared.dog.DogCreationContainerForm;
import org.hk.doghub.ui.components.shared.dog.DogCreationParameters;
import org.hk.doghub.ui.views.app.dogs.DogsView;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;

import static com.vaadin.flow.component.icon.VaadinIcon.SWORD;

@PageTitle(DogCreationView.NAME)
@Route(value = DogCreationView.ROUTE, layout = DogHubAppLayout.class)
@RolesAllowed({"USER", "ADMIN"})
public class DogCreationView extends EntityCreationView<DogHubDog, DogCreationParameters> {

    public static final String ROUTE = DogsView.ROUTE + "/create";
    private static final String ID_PREFIX = "dog-creation";
    private static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Dog Creation";

    public DogCreationView(AuthenticatedUser authenticatedUser, DogCreationService creationService) {
        super(authenticatedUser, creationService);
        addClassName(CLASS_NAME);
    }

    @Override
    protected @NotNull VaadinIcon getHeaderIcon() {
        return SWORD;
    }

    @Override
    protected @NotNull String getHeaderTitleText() {
        return "Create a Dog";
    }

    @Override
    protected @NotNull String getHeaderDescriptionText() {
        return "Add your dog to DogHub";
    }

    @Override
    protected @NotNull EntityCreationContainerForm<DogHubDog, DogCreationParameters> getForm(AuthenticatedUser authenticatedUser, EntityCreationService<DogHubDog, DogCreationParameters> creationService) {
        return new DogCreationContainerForm(authenticatedUser, creationService);
    }
}
