package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.components.shared.EntitiesButton;
import org.hk.doghub.ui.views.app.users.UsersView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class UsersRouterLink extends RouterLink {

    public static final String CLASS_NAME = "users-router-link";

    public UsersRouterLink() {
        super(EMPTY, UsersView.class);
        addClassName(CLASS_NAME);
        add(new EntitiesButton("Users"));
    }
}
