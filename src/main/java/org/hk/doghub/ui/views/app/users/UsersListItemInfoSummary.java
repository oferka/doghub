package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.html.Span;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.DogHubUser;

public class UsersListItemInfoSummary extends Span {

    public static final String CLASS_NAME = UsersListItemInfo.CLASS_NAME + "-summary";

    public UsersListItemInfoSummary(DogHubUser user) {
        addClassName(CLASS_NAME);
        setText(getSummary(user));
    }

    private @NotNull String getSummary(DogHubUser user) {
        return user.getCompany();
    }
}
