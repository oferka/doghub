package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.html.H2;

import static java.lang.String.format;

public class TipsViewHeaderInfoTitleCount extends H2 {

    public static final String CLASS_NAME = TipsViewHeaderInfoTitle.CLASS_NAME + "-count";

    public TipsViewHeaderInfoTitleCount(long count) {
        addClassName(CLASS_NAME);
        setText(format("(%s)", count));
    }
}
