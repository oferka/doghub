package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.views.site.profile.ProfileView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class DogHubAppLayoutUserProfileRouterLink extends RouterLink {

    public static final String CLASS_NAME = DogHubAppLayoutHeader.CLASS_NAME + "-user-profile-router-link";

    public DogHubAppLayoutUserProfileRouterLink() {
        super(EMPTY, ProfileView.class);
        addClassName(CLASS_NAME);
        DogHubAppLayoutUserProfileButton profile = new DogHubAppLayoutUserProfileButton();
        add(profile);
    }
}
