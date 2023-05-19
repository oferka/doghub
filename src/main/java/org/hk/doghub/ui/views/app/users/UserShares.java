package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.DogHubUser;

import static com.vaadin.flow.component.icon.VaadinIcon.CONNECT_O;
import static java.lang.String.format;

public class UserShares extends HorizontalLayout {

    public static final String CLASS_NAME = "user-shares";

    public UserShares(DogHubUser user) {
        addClassName(CLASS_NAME);

        Icon sharesIcon = CONNECT_O.create();
        sharesIcon.addClassName(format("%s-icon", CLASS_NAME));
        add(sharesIcon);

        Span sharesText = new Span(user.getShares().toString());
        sharesText.addClassName(format("%s-text", CLASS_NAME));
        add(sharesText);
    }
}
