package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.icon.Icon;

import static com.vaadin.flow.component.icon.VaadinIcon.LINK;

public class TipsViewHeaderInfoTitleIcon extends Icon {

    public static final String CLASS_NAME = TipsViewHeaderInfoTitle.CLASS_NAME + "-icon";

    public TipsViewHeaderInfoTitleIcon() {
        super(LINK);
        addClassName(CLASS_NAME);
    }
}
