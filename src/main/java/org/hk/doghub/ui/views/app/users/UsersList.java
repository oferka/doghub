package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;

public class UsersList extends Div {

    public static final String CLASS_NAME = "users-list";

    public UsersList(UserDataProvider userDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setWidthFull();
        Grid<DogHubUser> grid = new Grid<>();
        grid.addClassName("users-list-grid");
        setSizeFull();
        grid.setHeightFull();
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid.addComponentColumn((DogHubUser user) -> createListItem(user, authenticatedUser));
        grid.setItems(userDataProvider.findAll());
        add(grid);
    }

    private HorizontalLayout createListItem(DogHubUser user, AuthenticatedUser authenticatedUser) {
        return new UsersListItem(user, authenticatedUser);
    }
}
