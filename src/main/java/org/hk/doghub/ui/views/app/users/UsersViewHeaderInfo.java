package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderInfoDescription;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderInfoTitle;

public class UsersViewHeaderInfo extends VerticalLayout {

    public static final String CLASS_NAME = UsersViewHeader.CLASS_NAME + "-info";

    private final EntitiesViewHeaderInfoTitle title;
    private final EntitiesViewHeaderInfoDescription description;

    public UsersViewHeaderInfo(@NotNull VaadinIcon vaadinIcon, @NotNull String titleText, long entityCount, @NotNull String descriptionText) {
        addClassName(CLASS_NAME);

        setAlignItems(FlexComponent.Alignment.CENTER);

        title = new EntitiesViewHeaderInfoTitle(vaadinIcon, titleText, entityCount);
        add(title);

        description = new EntitiesViewHeaderInfoDescription(descriptionText);
        add(description);
    }
}
