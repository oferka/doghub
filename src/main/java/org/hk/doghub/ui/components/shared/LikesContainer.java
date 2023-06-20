package org.hk.doghub.ui.components.shared;

import static org.vaadin.lineawesome.LineAwesomeIcon.HEART;

public class LikesContainer extends FeedbackAttributeContainer {

    public static final String CLASS_NAME = "likes-container";

    public LikesContainer(Long likes) {
        super(HEART.create(), likes);
        addClassName(CLASS_NAME);
    }
}
