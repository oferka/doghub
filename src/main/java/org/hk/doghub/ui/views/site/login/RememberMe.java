package org.hk.doghub.ui.views.site.login;

import com.vaadin.flow.component.checkbox.Checkbox;

public class RememberMe extends Checkbox {

    public static final String CLASS_NAME = LoginBody.CLASS_NAME + "-remember-me";

    public RememberMe() {
        addClassName(CLASS_NAME);
        setValue(true);
        setLabel("Remember me for 30 days");
    }
}
