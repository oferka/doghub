package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EntitiesListItemInfoCreationTime;

public class UsersListItemInfoSummary extends VerticalLayout {

    public static final String CLASS_NAME = UsersListItemInfo.CLASS_NAME + "-summary";

    private final EntitiesListItemInfoCreationTime<DogHubUser> creationDate;

    private final Span summary;

    public UsersListItemInfoSummary(DogHubUser user) {
        addClassName(CLASS_NAME);
        creationDate = new EntitiesListItemInfoCreationTime<>(user);
        add(creationDate);

        summary = new Span(getSummary(user));
        add(summary);
    }

    private @NotNull String getSummary(DogHubUser user) {
        return user.getCompany();
    }
}
