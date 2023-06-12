package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.ui.components.shared.OrDivider;

public class SignupDivider extends HorizontalLayout {

    public static final String CLASS_NAME = SignupBody.CLASS_NAME + "-divider";

    public SignupDivider() {
        addClassName(CLASS_NAME);
        OrDivider divider = new OrDivider();
        add(divider);
    }
}
