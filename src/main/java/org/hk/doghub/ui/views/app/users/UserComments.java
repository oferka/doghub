package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.user.DogHubUser;

import static com.vaadin.flow.component.icon.VaadinIcon.COMMENT_O;
import static java.lang.String.format;

public class UserComments extends HorizontalLayout {

    public static final String CLASS_NAME = "user-comments";

    public UserComments(DogHubUser user) {
        addClassName(CLASS_NAME);

        Icon commentsIcon = COMMENT_O.create();
        commentsIcon.addClassName(format("%s-icon", CLASS_NAME));
        add(commentsIcon);

        Span commentsText = new Span(user.getComments().toString());
        commentsText.addClassName(format("%s-text", CLASS_NAME));
        add(commentsText);
    }
}
