package org.hk.doghub.ui.views.app.tips.create;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityCreationContainerForm;
import org.hk.doghub.ui.components.shared.EntityCreationService;
import org.hk.doghub.ui.components.shared.EntityCreationView;
import org.hk.doghub.ui.components.shared.tip.TipCreationContainerForm;
import org.hk.doghub.ui.components.shared.tip.TipCreationParameters;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;
import org.hk.doghub.ui.views.app.tips.TipsView;

import static com.vaadin.flow.component.icon.VaadinIcon.LINK;

@PageTitle(TipCreationView.NAME)
@Route(value = TipCreationView.ROUTE, layout = DogHubAppLayout.class)
@RolesAllowed({"USER", "ADMIN"})
public class TipCreationView extends EntityCreationView<DogHubTip, TipCreationParameters> {

    public static final String ROUTE = TipsView.ROUTE + "/create";
    private static final String ID_PREFIX = "tip-creation";
    private static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Tip Creation";

    public TipCreationView(AuthenticatedUser authenticatedUser, TipCreationService creationService) {
        super(authenticatedUser, creationService);
        addClassName(CLASS_NAME);
    }

    @Override
    protected @NotNull Component getHeaderIcon() {
        return LINK.create();
    }

    @Override
    protected @NotNull String getHeaderTitleText() {
        return "Create a Tip";
    }

    @Override
    protected @NotNull String getHeaderDescriptionText() {
        return "Add some interesting tip to DogHub";
    }

    @Override
    protected @NotNull EntityCreationContainerForm<DogHubTip, TipCreationParameters> getForm(AuthenticatedUser authenticatedUser, EntityCreationService<DogHubTip, TipCreationParameters> creationService) {
        return new TipCreationContainerForm(authenticatedUser, creationService);
    }
}
