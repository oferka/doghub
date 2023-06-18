package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.RouterLink;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.model.user.DogHubUser;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public abstract class UserEntitiesRouterLink<T extends NamedEntity> extends RouterLink {

    public static final String CLASS_NAME = "user-entities-router-link";

    public UserEntitiesRouterLink(DogHubUser user, Class<? extends Component> entitiesClass) {
        super(EMPTY, entitiesClass);
        addClassName(CLASS_NAME);
        add(getAvatarGroup(user));
    }

    protected abstract @NotNull UserEntitiesAvatarGroup<T> getAvatarGroup(@NotNull DogHubUser user);
}
