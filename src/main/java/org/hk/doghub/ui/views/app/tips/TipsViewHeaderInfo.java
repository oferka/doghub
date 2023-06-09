package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderInfoDescription;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderInfoTitle;

import static com.vaadin.flow.component.icon.VaadinIcon.LINK;

public class TipsViewHeaderInfo extends VerticalLayout {

    public static final String CLASS_NAME = TipsViewHeader.CLASS_NAME + "-info";

    private final EntitiesViewHeaderInfoTitle title;
    private final EntitiesViewHeaderInfoDescription description;

    public TipsViewHeaderInfo(TipDataProvider tipDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setAlignItems(FlexComponent.Alignment.CENTER);

        title = new EntitiesViewHeaderInfoTitle(LINK, TipsView.NAME, tipDataProvider.countForUser(authenticatedUser));
        add(title);

        description = new EntitiesViewHeaderInfoDescription("Tips view description");
        add(description);
    }
}
