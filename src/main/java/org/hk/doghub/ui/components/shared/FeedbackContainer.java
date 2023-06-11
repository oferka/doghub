package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.HasFeedback;
import org.hk.doghub.model.NamedEntity;

public class FeedbackContainer<T extends NamedEntity & HasFeedback> extends HorizontalLayout {

    public static final String CLASS_NAME = "feedback-container";

    private final LikesContainer likes;
    private final CommentsContainer comments;
    private final SharesContainer shares;

    public FeedbackContainer(T entity) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");
        likes = new LikesContainer(entity.getFeedback().getLikes());
        comments = new CommentsContainer(entity.getFeedback().getComments());
        shares = new SharesContainer(entity.getFeedback().getShares());
        add(likes, comments, shares);
    }
}
