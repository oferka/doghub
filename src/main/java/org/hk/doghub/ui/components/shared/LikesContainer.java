package org.hk.doghub.ui.components.shared;

import static com.vaadin.flow.component.icon.VaadinIcon.HEART_O;

public class LikesContainer extends FeedbackAttributeContainer {

    public static final String CLASS_NAME = "likes-container";

    public LikesContainer(Long likes) {
        super(HEART_O, likes);
        addClassName(CLASS_NAME);
    }
}
