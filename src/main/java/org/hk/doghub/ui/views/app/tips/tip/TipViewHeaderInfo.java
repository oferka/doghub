package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityViewHeaderInfoTitle;
import org.hk.doghub.ui.views.app.tips.TipDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipViewHeaderInfo extends VerticalLayout {

    public static final String CLASS_NAME = TipViewHeader.CLASS_NAME + "-info";

    private final EntityViewHeaderInfoTitle<DogHubTip> title;
    private final TipViewHeaderInfoDescription description;

    public TipViewHeaderInfo(TipDataProvider tipDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        title = new EntityViewHeaderInfoTitle<>(tipDataProvider);
        add(title);

        description = new TipViewHeaderInfoDescription(tipDataProvider, authenticatedUser);
        add(description);
    }

    public void selectedTipChanged(long selectedTipId) {
        title.selectedEntityChanged(selectedTipId);
        description.selectedTipChanged(selectedTipId);
    }
}
