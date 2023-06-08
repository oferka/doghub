package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.H2;
import jakarta.validation.constraints.NotNull;

public class EntitiesViewHeaderInfoTitleText extends H2 {

    public static final String CLASS_NAME = "entities-view-header-info-title-text";

    public EntitiesViewHeaderInfoTitleText(@NotNull String titleText) {
        addClassName(CLASS_NAME);
        setTitleText(titleText);
    }

    public void setTitleText(@NotNull String titleText) {
        setText(titleText);
    }
}
