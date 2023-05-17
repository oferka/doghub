package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class SignupMessageSecondLine extends HorizontalLayout {

    public static final String CLASS_NAME = SignupMessage.CLASS_NAME + "-second-line";

    private final TermsOfServiceAnchor termsOfServiceAnchor;

    private final PrivacyPolicyAnchor privacyPolicyAnchor;

    public SignupMessageSecondLine() {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        termsOfServiceAnchor = new TermsOfServiceAnchor();
        add(termsOfServiceAnchor);

        Label andLabel = new Label("and");
        andLabel.addClassName(CLASS_NAME + "-and");
        add(andLabel);

        privacyPolicyAnchor = new PrivacyPolicyAnchor();
        add(privacyPolicyAnchor);
    }
}
