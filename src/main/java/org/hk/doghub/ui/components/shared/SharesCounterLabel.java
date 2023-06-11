package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.Span;

public class SharesCounterLabel extends Span {

    public static final String CLASS_NAME = "shares-counter-label";

    public SharesCounterLabel(Long sharesCounter) {
        super(sharesCounter.toString());
        addClassName(CLASS_NAME);
    }
}
