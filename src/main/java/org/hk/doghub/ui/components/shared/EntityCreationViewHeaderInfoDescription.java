package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.Span;
import jakarta.validation.constraints.NotNull;

public class EntityCreationViewHeaderInfoDescription extends Span {

    public static final String CLASS_NAME = "entity-creation-view-header-info-description";

    public EntityCreationViewHeaderInfoDescription(@NotNull String descriptionText) {
        addClassName(CLASS_NAME);
        setDescriptionText(descriptionText);
    }

    public void setDescriptionText(@NotNull String descriptionText) {
        setText(descriptionText);
    }
}
