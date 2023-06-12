package org.hk.doghub.ui.views.app.tips.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipCreationViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = TipCreationViewHeaderInfo.CLASS_NAME + "-title";

    public TipCreationViewHeaderInfoTitle(AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        TipCreationViewHeaderInfoTitleIcon icon = new TipCreationViewHeaderInfoTitleIcon(authenticatedUser, tipCreationService);
        TipCreationViewHeaderInfoTitleText text = new TipCreationViewHeaderInfoTitleText(authenticatedUser, tipCreationService);
        add(icon, text);
        setVerticalComponentAlignment(CENTER, icon, text);
    }
}
