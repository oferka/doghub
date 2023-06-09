package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.H2;

import static java.lang.String.format;

public class EntitiesViewHeaderInfoTitleCount extends H2 {

    public static final String CLASS_NAME = "entities-view-header-info-title-count";

    public EntitiesViewHeaderInfoTitleCount(long count) {
        addClassName(CLASS_NAME);
        setText(format("(%s)", count));
    }
}
