package org.hk.doghub.ui.views.app.tips.create;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;
import org.hk.doghub.ui.views.app.tips.TipsView;

@PageTitle(TipCreationView.NAME)
@Route(value = TipCreationView.ROUTE, layout = DogHubAppLayout.class)
@RolesAllowed({"USER", "ADMIN"})
public class TipCreationView extends VerticalLayout {

    public static final String ROUTE = TipsView.ROUTE + "/create";
    private static final String ID_PREFIX = "tip-creation";
    private static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Tip Creation";

    public TipCreationView(AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        addClassName(CLASS_NAME);
        TipCreationViewHeader header = new TipCreationViewHeader();
        add(header);
        TipCreationViewBody body = new TipCreationViewBody(authenticatedUser, tipCreationService);
        addAndExpand(body);
        TipCreationViewFooter footer = new TipCreationViewFooter(authenticatedUser, tipCreationService);
        add(footer);
    }
}
