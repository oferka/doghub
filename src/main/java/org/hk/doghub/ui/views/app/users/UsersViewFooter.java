package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UsersViewFooter extends VerticalLayout {

    public static final String CLASS_NAME = UsersView.CLASS_NAME + "-footer";

    public UsersViewFooter(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        add(new H2("Users View Footer"));
    }
}
