package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.user.UserCreationService;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserCreationViewFooter extends HorizontalLayout {

    public static final String CLASS_NAME = UserCreationView.CLASS_NAME + "-footer";

    public UserCreationViewFooter() {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        add(new Span("user creation footer"));
    }
}
