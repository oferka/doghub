package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import jakarta.annotation.security.RolesAllowed;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.DogHubAppLayout;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;
import org.hk.doghub.ui.views.app.tips.TipsView;

@Route(value = TipsView.ROUTE, layout = DogHubAppLayout.class)
@PageTitle(TipView.NAME)
@RolesAllowed({"USER", "ADMIN"})
public class TipView extends VerticalLayout implements HasUrlParameter<Long> {

    public static final String ID_PREFIX = "tip";
    public static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Tip";

    private final TipViewHeader tipViewHeader;
    private final TipViewBody tipViewBody;
    private final TipViewFooter tipViewFooter;

    private final TipsDataProvider tipsDataProvider;

    private final AuthenticatedUser authenticatedUser;

    public TipView(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        this.tipsDataProvider = tipsDataProvider;
        this.authenticatedUser = authenticatedUser;
        addClassName(CLASS_NAME);

        tipViewHeader = new TipViewHeader(tipsDataProvider, authenticatedUser);
        add(tipViewHeader);

        tipViewBody = new TipViewBody(tipsDataProvider, authenticatedUser);
        addAndExpand(tipViewBody);

        tipViewFooter = new TipViewFooter(tipsDataProvider, authenticatedUser);
        add(tipViewFooter);
    }

    @Override
    public void setParameter(BeforeEvent event, Long parameter) {
        setTip(parameter);
        if(!tipsDataProvider.hasAccess(authenticatedUser, parameter)) {
            throw new NotFoundException();
        }
    }

    private void setTip(long selectedTipId) {
        tipViewHeader.selectedTipChanged(selectedTipId);
        tipViewBody.selectedTipChanged(selectedTipId);
        tipViewFooter.selectedTipChanged(selectedTipId);
    }
}
