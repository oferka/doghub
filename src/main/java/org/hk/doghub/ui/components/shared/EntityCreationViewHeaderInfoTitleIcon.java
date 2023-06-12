package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import jakarta.validation.constraints.NotNull;

public class EntityCreationViewHeaderInfoTitleIcon extends Icon {

    public static final String CLASS_NAME = "entity-creation-view-header-info-title-icon";

    public EntityCreationViewHeaderInfoTitleIcon(@NotNull VaadinIcon vaadinIcon) {
        super(vaadinIcon);
        addClassName(CLASS_NAME);
    }
}
