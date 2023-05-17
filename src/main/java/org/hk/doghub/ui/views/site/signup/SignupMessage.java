package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class SignupMessage extends VerticalLayout {

    public static final String CLASS_NAME = SignupBody.CLASS_NAME + "-message";

    private final SignupMessageFirstLine firstLine;

    private final SignupMessageSecondLine secondLine;

    public SignupMessage() {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);
        setSpacing(false);

        firstLine = new SignupMessageFirstLine();
        add(firstLine);

        secondLine = new SignupMessageSecondLine();
        add(secondLine);
    }
}
