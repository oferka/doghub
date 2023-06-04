package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import jakarta.annotation.security.RolesAllowed;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.tip.TipInfoCancelEvent;
import org.hk.doghub.ui.components.shared.tip.TipInfoCancelListener;
import org.hk.doghub.ui.components.shared.tip.TipInfoSaveEvent;
import org.hk.doghub.ui.components.shared.tip.TipInfoSaveListener;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;
import org.hk.doghub.ui.views.app.tips.TipsView;
import org.hk.doghub.ui.views.app.tips.create.TipCreationService;

@Route(value = TipsView.ROUTE, layout = DogHubAppLayout.class)
@PageTitle(TipView.NAME)
@RolesAllowed({"USER", "ADMIN"})
public class TipView extends VerticalLayout implements HasUrlParameter<Long>, TipInfoSaveListener, TipInfoCancelListener {

    public static final String ID_PREFIX = "tip";
    public static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Tip";

    private final TipViewHeader header;
    private final TipViewBody body;
    private final TipViewFooter footer;

    private final TipsDataProvider tipsDataProvider;

    private final AuthenticatedUser authenticatedUser;

    public TipView(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        this.tipsDataProvider = tipsDataProvider;
        this.authenticatedUser = authenticatedUser;
        addClassName(CLASS_NAME);

        header = new TipViewHeader(tipsDataProvider, authenticatedUser);
        add(header);

        body = new TipViewBody(tipsDataProvider, authenticatedUser, tipCreationService);
        body.addTipInfoSaveListener(this);
        body.addTipInfoCancelListener(this);
        addAndExpand(body);

        footer = new TipViewFooter(tipsDataProvider, authenticatedUser);
        add(footer);
    }

    @Override
    public void setParameter(BeforeEvent event, Long parameter) {
        setTip(parameter);
        if(!tipsDataProvider.hasAccess(authenticatedUser, parameter)) {
            throw new NotFoundException();
        }
    }

    private void setTip(long selectedTipId) {
        header.selectedTipChanged(selectedTipId);
        body.selectedTipChanged(selectedTipId);
        footer.selectedTipChanged(selectedTipId);
    }

    @Override
    public void saveTriggered(TipInfoSaveEvent event) {
        header.save();
        body.save();
        footer.save();
    }

    @Override
    public void cancelTriggered(TipInfoCancelEvent event) {
        header.cancel();
        body.cancel();
        footer.cancel();
    }
}
