package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.icon.Icon;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.icon.VaadinIcon.LINK;

public class TipsViewHeaderInfoTitleIcon extends Icon {

    public static final String CLASS_NAME = TipsViewHeaderInfoTitle.CLASS_NAME + "-icon";

    public TipsViewHeaderInfoTitleIcon(TipsDataProvider tipsDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        super(LINK);
        setSize("60px");
        addClassName(CLASS_NAME);
    }
}
