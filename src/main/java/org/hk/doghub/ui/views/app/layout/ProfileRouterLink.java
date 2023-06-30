package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.router.RouterLink;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.ui.views.site.profile.ProfileView;

public class ProfileRouterLink extends RouterLink {

    public static final String CLASS_NAME = "profile-router-link";

    public ProfileRouterLink(@NotNull String text) {
        super(text, ProfileView.class);
        addClassName(CLASS_NAME);
        ProfileButton profile = new ProfileButton();
        add(profile);
    }
}
