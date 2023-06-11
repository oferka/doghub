package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class LikesContainer extends HorizontalLayout {

    public static final String CLASS_NAME = "likes-container";

    private final LikesIcon likesIcon;

    private final LikesCounterLabel likesCounterLabel;

    public LikesContainer(Long likes) {
        addClassName(CLASS_NAME);

        likesIcon = new LikesIcon();
        add(likesIcon);

        likesCounterLabel = new LikesCounterLabel(likes);
        add(likesCounterLabel);
    }
}
