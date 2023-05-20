package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.server.auth.AccessAnnotationChecker;
import org.hk.doghub.security.AuthenticatedUser;

public class DogHubAppLayout extends AppLayout {

    public static final String ID_PREFIX = "doghub-app";
    public static final String ID_SUFFIX = "-layout";
    public static final String ID = ID_PREFIX + ID_SUFFIX;

    private final DogHubAppLayoutHeader header;

    private final DogHubAppLayoutDrawer drawer;

    public DogHubAppLayout(AuthenticatedUser authenticatedUser, AccessAnnotationChecker accessChecker) {
        setId(ID);
        setPrimarySection(Section.DRAWER);
        header = new DogHubAppLayoutHeader(authenticatedUser);
        addToNavbar(true, header);
        drawer = new DogHubAppLayoutDrawer(accessChecker);
        addToDrawer(drawer);
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        header.setTitleText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
