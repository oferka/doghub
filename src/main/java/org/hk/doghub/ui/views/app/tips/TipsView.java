package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;

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

    private final TipsViewHeader header;
    private final TipsViewBody body;
    private final TipsViewFooter footer;

    public TipsView(TipDataProvider tipDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        header = new TipsViewHeader(tipDataProvider, tipsViewState, authenticatedUser);
        add(header);

        body = new TipsViewBody(tipDataProvider, tipsViewState, authenticatedUser);
        addAndExpand(body);

        footer = new TipsViewFooter(tipDataProvider, tipsViewState, authenticatedUser);
        add(footer);
    }
}
