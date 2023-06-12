package org.hk.doghub.ui.views.site.login;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.ui.components.shared.OrDivider;

public class LoginDivider extends HorizontalLayout {

    public static final String CLASS_NAME = LoginBody.CLASS_NAME + "-divider";

    public LoginDivider() {
        addClassName(CLASS_NAME);
        OrDivider divider = new OrDivider();
        add(divider);
    }
}
