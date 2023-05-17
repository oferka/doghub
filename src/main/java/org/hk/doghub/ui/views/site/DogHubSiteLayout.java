package org.hk.doghub.ui.views.site;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.PageTitle;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.security.AuthenticatedUser;

import static java.lang.String.format;

@Slf4j
public class DogHubSiteLayout extends AppLayout {

    public static final String ID_PREFIX = "doghub-site";
    public static final String ID_SUFFIX = "-layout";
    public static final String ID = ID_PREFIX + ID_SUFFIX;

    private final DogHubSiteLayoutHeader header;

    public DogHubSiteLayout(AuthenticatedUser authenticatedUser) {
        setId(ID);
        header = new DogHubSiteLayoutHeader(authenticatedUser);
        addToNavbar(true, header);
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        log.info(format("Selected view page title: %s", getCurrentPageTitle()));
        header.presentTab(getContent());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
