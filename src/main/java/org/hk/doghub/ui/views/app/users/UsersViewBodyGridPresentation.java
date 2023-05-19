package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UsersViewBodyGridPresentation extends VerticalLayout {

    public static final String CLASS_NAME = UsersViewBody.CLASS_NAME + "-grid-presentation";

    private final UsersGrid usersGrid;

    public UsersViewBodyGridPresentation(UsersDataProvider usersDataProvider) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        usersGrid = new UsersGrid(usersDataProvider);
        addAndExpand(usersGrid);
    }
}
