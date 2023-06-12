package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.ui.components.shared.EntityCreationViewHeaderActions;
import org.hk.doghub.ui.components.shared.EntityCreationViewHeaderInfo;

import static com.vaadin.flow.component.icon.VaadinIcon.USERS;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserCreationViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = UserCreationView.CLASS_NAME + "-header";

    public UserCreationViewHeader() {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        EntityCreationViewHeaderInfo info = new EntityCreationViewHeaderInfo(USERS, "Create a User", "Add someone you love to DogHub");
        EntityCreationViewHeaderActions actions = new EntityCreationViewHeaderActions();
        add(info, actions);
    }
}
