package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.Span;
import jakarta.validation.constraints.NotNull;

public class EntitiesViewHeaderInfoDescription extends Span {

    public static final String CLASS_NAME = "entities-view-header-info-description";

    public EntitiesViewHeaderInfoDescription(@NotNull String descriptionText) {
        addClassName(CLASS_NAME);
        setText(descriptionText);
    }
}
