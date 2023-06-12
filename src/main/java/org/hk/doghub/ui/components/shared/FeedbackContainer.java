package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.HasFeedback;
import org.hk.doghub.model.NamedEntity;

public class FeedbackContainer<T extends NamedEntity & HasFeedback> extends HorizontalLayout {

    public static final String CLASS_NAME = "feedback-container";

    public FeedbackContainer(T entity) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");
        LikesContainer likes = new LikesContainer(entity.getFeedback().getLikes());
        CommentsContainer comments = new CommentsContainer(entity.getFeedback().getComments());
        SharesContainer shares = new SharesContainer(entity.getFeedback().getShares());
        add(likes, comments, shares);
    }
}
