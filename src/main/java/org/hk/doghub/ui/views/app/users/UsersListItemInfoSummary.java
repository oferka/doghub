package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.DogHubLabel;
import org.hk.doghub.ui.components.shared.EntitiesListItemInfoCreationTime;

public class UsersListItemInfoSummary extends VerticalLayout {

    public static final String CLASS_NAME = UsersListItemInfo.CLASS_NAME + "-summary";

    private final EntitiesListItemInfoCreationTime<DogHubUser> creationTime;

    private final DogHubLabel company;

    public UsersListItemInfoSummary(DogHubUser user) {
        addClassName(CLASS_NAME);
        creationTime = new EntitiesListItemInfoCreationTime<>(user);
        add(creationTime);
        company = new DogHubLabel(user.getCompany());
        add(company);
    }
}
