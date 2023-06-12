package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.H2;
import jakarta.validation.constraints.NotNull;

public class EntityCreationViewHeaderInfoTitleText extends H2 {

    public static final String CLASS_NAME = "entity-creation-view-header-info-title-text";

    public EntityCreationViewHeaderInfoTitleText(@NotNull String titleText) {
        addClassName(CLASS_NAME);
        setTitleText(titleText);
    }

    public void setTitleText(@NotNull String titleText) {
        setText(titleText);
    }
}
