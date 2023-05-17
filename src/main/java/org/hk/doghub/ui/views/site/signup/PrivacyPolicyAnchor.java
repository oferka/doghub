package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.router.RouteConfiguration;
import org.hk.doghub.ui.views.site.privacy.PrivacyPolicyView;

import static com.vaadin.flow.component.html.AnchorTarget.BLANK;

public class PrivacyPolicyAnchor extends Anchor {

    public static final String CLASS_NAME = SignupMessage.CLASS_NAME + "-privacy-policy";

    public PrivacyPolicyAnchor() {
        addClassName(CLASS_NAME);
        setHref(RouteConfiguration.forSessionScope().getUrl(PrivacyPolicyView.class));
        setText("Privacy Policy");
        setTarget(BLANK);
    }
}
