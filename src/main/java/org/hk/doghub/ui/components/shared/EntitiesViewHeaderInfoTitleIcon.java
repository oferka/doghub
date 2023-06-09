package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import jakarta.validation.constraints.NotNull;

public class EntitiesViewHeaderInfoTitleIcon extends Icon {

    public static final String CLASS_NAME = "entities-view-header-info-title-icon";

    public EntitiesViewHeaderInfoTitleIcon(@NotNull VaadinIcon icon) {
        super(icon);
        addClassName(CLASS_NAME);
    }
}
