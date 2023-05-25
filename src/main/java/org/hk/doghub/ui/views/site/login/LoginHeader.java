package org.hk.doghub.ui.views.site.login;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.ui.components.shared.ApplicationHeader;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class LoginHeader extends VerticalLayout {

    public static final String CLASS_NAME = "login-header";

    private final ApplicationHeader header;

    public LoginHeader() {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        header = new ApplicationHeader();
        add(header);
    }
}
