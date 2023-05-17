package org.hk.doghub.ui.views.site;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.views.site.home.SiteHomeView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class DogHubSiteLayoutTitleRouterLink extends RouterLink {

    public static final String CLASS_NAME = DogHubSiteLayout.ID + "-title-router-link";

    private final DogHubSiteLayoutTitleRouterLinkImage image;

    public DogHubSiteLayoutTitleRouterLink() {
        super(EMPTY, SiteHomeView.class);
        addClassName(CLASS_NAME);

        image = new DogHubSiteLayoutTitleRouterLinkImage();
        add(image);
    }
}
