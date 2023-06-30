package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.router.RouterLink;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.ui.views.site.profile.ProfileView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class ProfileRouterLink extends RouterLink {

    public static final String CLASS_NAME = "profile-router-link";

    public ProfileRouterLink(@NotNull String text) {
        super(EMPTY, ProfileView.class);
        addClassName(CLASS_NAME);
        ProfileButton profile = new ProfileButton(text);
        add(profile);
    }
}
