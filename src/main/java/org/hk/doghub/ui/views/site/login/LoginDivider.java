package org.hk.doghub.ui.views.site.login;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.ui.components.shared.OrDivider;

public class LoginDivider extends HorizontalLayout {

    public static final String CLASS_NAME = LoginBody.CLASS_NAME + "-divider";

    private final OrDivider divider;

    public LoginDivider() {
        addClassName(CLASS_NAME);

        divider = new OrDivider();
        add(divider);
    }
}
