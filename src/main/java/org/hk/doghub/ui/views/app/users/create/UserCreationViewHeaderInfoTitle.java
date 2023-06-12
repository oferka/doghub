package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityCreationViewHeaderInfoTitleIcon;
import org.hk.doghub.ui.components.shared.user.UserCreationService;

import static com.vaadin.flow.component.icon.VaadinIcon.USERS;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserCreationViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = UserCreationViewHeaderInfo.CLASS_NAME + "-title";

    public UserCreationViewHeaderInfoTitle() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        EntityCreationViewHeaderInfoTitleIcon icon = new EntityCreationViewHeaderInfoTitleIcon(USERS);
        UserCreationViewHeaderInfoTitleText text = new UserCreationViewHeaderInfoTitleText();
        add(icon, text);
        setVerticalComponentAlignment(CENTER, icon, text);
    }
}
