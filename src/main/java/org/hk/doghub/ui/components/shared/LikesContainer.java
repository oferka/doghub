package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static java.lang.String.format;

public class LikesContainer extends HorizontalLayout {

    public static final String CLASS_NAME = "likes-container";

    private final LikesIcon likesIcon;

    public LikesContainer(Long likes) {
        addClassName(CLASS_NAME);

        likesIcon = new LikesIcon();
        add(likesIcon);

        Span likesText = new Span(likes.toString());
        likesText.addClassName(format("%s-text", CLASS_NAME));
        add(likesText);
    }
}
