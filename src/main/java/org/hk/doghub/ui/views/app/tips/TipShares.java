package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.icon.VaadinIcon.CONNECT_O;
import static java.lang.String.format;

public class TipShares extends HorizontalLayout {

    public static final String CLASS_NAME = "tip-shares";

    public TipShares(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        Icon sharesIcon = CONNECT_O.create();
        sharesIcon.addClassName(format("%s-icon", CLASS_NAME));
        add(sharesIcon);

        Span sharesText = new Span(tip.getShares().toString());
        sharesText.addClassName(format("%s-text", CLASS_NAME));
        add(sharesText);
    }
}
