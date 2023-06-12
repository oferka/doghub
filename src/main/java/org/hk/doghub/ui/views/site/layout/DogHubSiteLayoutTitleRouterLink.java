package org.hk.doghub.ui.views.site.layout;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.views.site.home.SiteHomeView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class DogHubSiteLayoutTitleRouterLink extends RouterLink {

    public static final String CLASS_NAME = DogHubSiteLayout.ID + "-title-router-link";

    public DogHubSiteLayoutTitleRouterLink() {
        super(EMPTY, SiteHomeView.class);
        addClassName(CLASS_NAME);
        DogHubSiteLayoutTitleRouterLinkImage image = new DogHubSiteLayoutTitleRouterLinkImage();
        add(image);
    }
}
