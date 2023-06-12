package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesViewBody;
import org.hk.doghub.ui.components.shared.EntitiesViewFooter;
import org.hk.doghub.ui.components.shared.EntitiesViewHeader;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;
import org.hk.doghub.ui.views.app.tips.create.TipCreationView;
import org.hk.doghub.ui.views.app.tips.tip.TipView;

import static com.vaadin.flow.component.icon.VaadinIcon.LINK;
import static org.hk.doghub.ui.views.app.tips.TipsView.ROUTE;

@PageTitle(TipsView.NAME)
@Route(value = ROUTE, layout = DogHubAppLayout.class)
@RolesAllowed({"USER", "ADMIN"})
public class TipsView extends VerticalLayout {

    public static final String ROUTE = "tips";
    private static final String ID_PREFIX = "tips";
    private static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Tips";

    private final EntitiesViewHeader header;
    private final EntitiesViewBody<DogHubTip, TipView> body;
    private final EntitiesViewFooter footer;

    public TipsView(TipDataProvider tipDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        header = new EntitiesViewHeader(tipsViewState, LINK, TipsView.NAME, tipDataProvider.countForUser(authenticatedUser), "Tips view description", TipCreationView.class, TipView.NAME);
        add(header);

        body = new EntitiesViewBody<>(new TipsList(tipDataProvider, authenticatedUser), new TipsGrid(tipDataProvider, authenticatedUser), tipsViewState);
        addAndExpand(body);

        footer = new EntitiesViewFooter();
        add(footer);
    }
}
