package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class SharesContainer extends HorizontalLayout {

    public static final String CLASS_NAME = "shares-container";

    private final SharesIcon sharesIcon;

    private final SharesCounterLabel sharesCounterLabel;

    public SharesContainer(Long shares) {
        addClassName(CLASS_NAME);

        sharesIcon = new SharesIcon();
        add(sharesIcon);

        sharesCounterLabel = new SharesCounterLabel(shares);
        add(sharesCounterLabel);
    }
}
