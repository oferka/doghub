package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.user.DogHubUser;

import static com.vaadin.flow.component.icon.VaadinIcon.HEART_O;
import static java.lang.String.format;

public class UserLikes extends HorizontalLayout {

    public static final String CLASS_NAME = "user-likes";

    public UserLikes(DogHubUser user) {
        addClassName(CLASS_NAME);

        Icon likesIcon = HEART_O.create();
        likesIcon.addClassName(format("%s-icon", CLASS_NAME));
        add(likesIcon);

        Span likesText = new Span(user.getFeedback().getLikes().toString());
        likesText.addClassName(format("%s-text", CLASS_NAME));
        add(likesText);
    }
}
