package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.H2;
import jakarta.validation.constraints.NotNull;

public class EntitiesViewHeaderInfoTitleText extends H2 {

    public static final String CLASS_NAME = EntitiesViewHeaderInfoTitle.CLASS_NAME + "-text";

    public EntitiesViewHeaderInfoTitleText(@NotNull String titleText) {
        addClassName(CLASS_NAME);
        setText(titleText);
    }
}
