package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesView;
import org.hk.doghub.ui.components.shared.EntitiesViewBody;
import org.hk.doghub.ui.components.shared.EntitiesViewHeader;
import org.hk.doghub.ui.components.shared.EntitiesViewState;
import org.hk.doghub.ui.views.app.EntityDataProvider;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;
import org.hk.doghub.ui.views.app.tips.create.TipCreationView;
import org.hk.doghub.ui.views.app.tips.tip.TipView;

import static com.vaadin.flow.component.icon.VaadinIcon.LINK;
import static org.hk.doghub.ui.views.app.tips.TipsView.ROUTE;

@PageTitle(TipsView.NAME)
@Route(value = ROUTE, layout = DogHubAppLayout.class)
@RolesAllowed({"USER", "ADMIN"})
public class TipsView extends EntitiesView<DogHubTip, TipView> {

    public static final String ROUTE = "tips";
    private static final String ID_PREFIX = "tips";
    private static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Tips";

    public TipsView(EntityDataProvider<DogHubTip> entityDataProvider, TipsViewState viewState, AuthenticatedUser authenticatedUser) {
        super(entityDataProvider, viewState, authenticatedUser);
        addClassName(CLASS_NAME);
    }

    @Override
    protected @NotNull EntitiesViewHeader getViewHeader(EntityDataProvider<DogHubTip> entityDataProvider, EntitiesViewState viewState, AuthenticatedUser authenticatedUser) {
        return new EntitiesViewHeader(viewState, getHeaderIcon(), getTitleText(), ((TipDataProvider)entityDataProvider).countForUser(authenticatedUser), getTitleDescription(), getEntityCreationClass(), getEntityLabel());
    }

    @Override
    protected @NotNull EntitiesViewBody<DogHubTip, TipView> getViewBody(EntityDataProvider<DogHubTip> entityDataProvider, EntitiesViewState viewState, AuthenticatedUser authenticatedUser) {
        return new EntitiesViewBody<>(new TipsList(entityDataProvider, authenticatedUser), new TipsGrid(entityDataProvider, authenticatedUser), viewState);
    }

    @Override
    protected @NotNull Component getHeaderIcon() {
        return LINK.create();
    }

    @Override
    protected @NotNull String getTitleText() {
        return TipsView.NAME;
    }

    @Override
    protected @NotNull String getTitleDescription() {
        return "Tips view description";
    }

    @Override
    protected @NotNull Class<? extends Component> getEntityCreationClass() {
        return TipCreationView.class;
    }

    @Override
    protected @NotNull String getEntityLabel() {
        return TipView.NAME;
    }
}
