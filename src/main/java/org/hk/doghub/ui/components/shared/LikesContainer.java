package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.icon.VaadinIcon.HEART_O;
import static java.lang.String.format;

public class LikesContainer extends HorizontalLayout {

    public static final String CLASS_NAME = "likes-container";

    public LikesContainer(Long likes) {
        addClassName(CLASS_NAME);

        Icon likesIcon = HEART_O.create();
        likesIcon.addClassName(format("%s-icon", CLASS_NAME));
        add(likesIcon);

        Span likesText = new Span(likes.toString());
        likesText.addClassName(format("%s-text", CLASS_NAME));
        add(likesText);
    }
}
