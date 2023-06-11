package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.icon.VaadinIcon.COMMENT_O;
import static java.lang.String.format;

public class TipComments extends HorizontalLayout {

    public static final String CLASS_NAME = "tip-comments";

    public TipComments(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        Icon commentsIcon = COMMENT_O.create();
        commentsIcon.addClassName(format("%s-icon", CLASS_NAME));
        add(commentsIcon);

        Span commentsText = new Span(tip.getFeedback().getComments().toString());
        commentsText.addClassName(format("%s-text", CLASS_NAME));
        add(commentsText);
    }
}
