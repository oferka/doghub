package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.NotFoundException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityUpdateService;
import org.hk.doghub.ui.components.shared.EntityView;
import org.hk.doghub.ui.components.shared.EntityViewBody;
import org.hk.doghub.ui.components.shared.tip.TipUpdateParameters;
import org.hk.doghub.ui.views.app.EntityDataProvider;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;
import org.hk.doghub.ui.views.app.tips.TipDataProvider;
import org.hk.doghub.ui.views.app.tips.TipsView;

@Route(value = TipsView.ROUTE, layout = DogHubAppLayout.class)
@PageTitle(TipView.NAME)
@RolesAllowed({"USER", "ADMIN"})
    public class TipView extends EntityView<DogHubTip, TipUpdateParameters> {

    private static final String ID_PREFIX = "tip";
    private static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Tip";

    public TipView(EntityDataProvider<DogHubTip> entityDataProvider, AuthenticatedUser authenticatedUser, EntityUpdateService<DogHubTip, TipUpdateParameters> entityUpdateService) {
        super(entityDataProvider, authenticatedUser, entityUpdateService);
        addClassName(CLASS_NAME);
    }

    protected EntityViewBody<DogHubTip, TipUpdateParameters> getBody() {
        return new TipViewBody(entityDataProvider, entityUpdateService);
    }

    @Override
    public void setParameter(BeforeEvent event, Long parameter) {
        setEntity(parameter);
        TipDataProvider tipDataProvider = (TipDataProvider) entityDataProvider;
        if(!tipDataProvider.hasAccess(authenticatedUser, parameter)) {
            throw new NotFoundException();
        }
    }

    @Override
    protected String getEntityLabel() {
        return TipView.NAME;
    }

    @Override
    protected Class getEntityClass() {
        return TipView.class;
    }

    @Override
    protected String getEntitiesLabel() {
        return TipsView.NAME;
    }

    @Override
    protected Class getEntitiesClass() {
        return TipsView.class;
    }
}
