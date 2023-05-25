package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.ui.components.shared.ApplicationHeader;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class SignupHeader extends VerticalLayout {

    public static final String CLASS_NAME = "signup-header";

    private final ApplicationHeader header;

    public SignupHeader() {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        header = new ApplicationHeader();
        add(header);
    }
}
