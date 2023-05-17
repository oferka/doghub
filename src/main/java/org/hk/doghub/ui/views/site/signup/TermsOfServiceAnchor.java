package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.router.RouteConfiguration;
import org.hk.doghub.ui.views.site.tos.TermsOfServiceView;

import static com.vaadin.flow.component.html.AnchorTarget.BLANK;

public class TermsOfServiceAnchor extends Anchor {

    public static final String CLASS_NAME = SignupMessage.CLASS_NAME + "-terms-of-service";

    public TermsOfServiceAnchor() {
        addClassName(CLASS_NAME);
        setHref(RouteConfiguration.forSessionScope().getUrl(TermsOfServiceView.class));
        setText("Terms of Service");
        setTarget(BLANK);
    }
}
