package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class CommentsContainer extends HorizontalLayout {

    public static final String CLASS_NAME = "comments-container";

    private final CommentsIcon commentsIcon;

    private final CommentsCounterLabel commentsCounterLabel;

    public CommentsContainer(Long comments) {
        addClassName(CLASS_NAME);

        commentsIcon = new CommentsIcon();
        add(commentsIcon);

        commentsCounterLabel = new CommentsCounterLabel(comments);
        add(commentsCounterLabel);
    }
}
