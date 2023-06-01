package org.hk.doghub.ui.views.app.tips.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipCreationViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = TipCreationViewHeaderInfo.CLASS_NAME + "-title";

    private final TipCreationViewHeaderInfoTitleIcon icon;
    private final TipCreationViewHeaderInfoTitleText text;

    public TipCreationViewHeaderInfoTitle(AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        icon = new TipCreationViewHeaderInfoTitleIcon(authenticatedUser, tipCreationService);
        add(icon);

        text = new TipCreationViewHeaderInfoTitleText(authenticatedUser, tipCreationService);
        add(text);

        setVerticalComponentAlignment(CENTER, icon, text);
    }
}
