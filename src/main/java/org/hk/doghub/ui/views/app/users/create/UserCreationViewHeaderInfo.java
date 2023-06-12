package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.ui.components.shared.EntityCreationViewHeaderInfoTitle;

import static com.vaadin.flow.component.icon.VaadinIcon.USERS;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserCreationViewHeaderInfo extends VerticalLayout {

    public static final String CLASS_NAME = UserCreationViewHeader.CLASS_NAME + "-info";

    public UserCreationViewHeaderInfo() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        EntityCreationViewHeaderInfoTitle title = new EntityCreationViewHeaderInfoTitle(USERS, "Create a User");
        UserCreationViewHeaderInfoDescription description = new UserCreationViewHeaderInfoDescription();
        add(title, description);
    }
}
