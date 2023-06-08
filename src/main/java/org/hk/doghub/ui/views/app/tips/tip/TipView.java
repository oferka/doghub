package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import jakarta.annotation.security.RolesAllowed;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.*;
import org.hk.doghub.ui.components.shared.tip.TipUpdateParameters;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;
import org.hk.doghub.ui.views.app.tips.TipDataProvider;
import org.hk.doghub.ui.views.app.tips.TipsView;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Route(value = TipsView.ROUTE, layout = DogHubAppLayout.class)
@PageTitle(TipView.NAME)
@RolesAllowed({"USER", "ADMIN"})
public class TipView extends VerticalLayout implements HasUrlParameter<Long>, InfoSaveListener, InfoCancelListener {

    public static final String ID_PREFIX = "tip";
    public static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Tip";

    private final EntityViewHeader<DogHubTip> header;
    private final EntityViewBody<DogHubTip, TipUpdateParameters> body;
    private final EntityViewFooter<DogHubTip> footer;

    private final TipDataProvider tipDataProvider;

    private final AuthenticatedUser authenticatedUser;

    public TipView(TipDataProvider tipDataProvider, AuthenticatedUser authenticatedUser, EntityUpdateService<DogHubTip, TipUpdateParameters> entityUpdateService) {
        this.tipDataProvider = tipDataProvider;
        this.authenticatedUser = authenticatedUser;
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        header = new EntityViewHeader<>(tipDataProvider);
        add(header);

        body = new TipViewBody(tipDataProvider, entityUpdateService);
        body.addInfoSaveListener(this);
        body.addInfoCancelListener(this);
        addAndExpand(body);

        footer = new EntityViewFooter<>(tipDataProvider, authenticatedUser, TipView.NAME, TipView.class, TipsView.NAME, TipsView.class);
        add(footer);
    }

    @Override
    public void setParameter(BeforeEvent event, Long parameter) {
        setEntity(parameter);
        if(!tipDataProvider.hasAccess(authenticatedUser, parameter)) {
            throw new NotFoundException();
        }
    }

    private void setEntity(long selectedEntityId) {
        header.selectedEntityChanged(selectedEntityId);
        body.selectedEntityChanged(selectedEntityId);
        footer.selectedEntityChanged(selectedEntityId);
    }

    @Override
    public void saveTriggered(InfoSaveEvent event) {
        header.save();
        body.save();
        footer.save();
    }

    @Override
    public void cancelTriggered(InfoCancelEvent event) {
        header.cancel();
        body.cancel();
        footer.cancel();
    }
}
