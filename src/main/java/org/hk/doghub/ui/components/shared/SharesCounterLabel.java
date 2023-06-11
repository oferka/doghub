package org.hk.doghub.ui.components.shared;

public class SharesCounterLabel extends FeedbackAttributeCounterLabel {

    public static final String CLASS_NAME = "shares-counter-label";

    public SharesCounterLabel(Long sharesCounter) {
        super(sharesCounter);
        addClassName(CLASS_NAME);
    }
}
