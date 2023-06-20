package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.server.auth.AccessAnnotationChecker;
import org.hk.doghub.ui.components.appnav.AppNav;
import org.hk.doghub.ui.components.appnav.AppNavItem;
import org.hk.doghub.ui.views.app.about.AboutView;
import org.hk.doghub.ui.views.app.admin.AdminView;
import org.hk.doghub.ui.views.app.dogs.DogsView;
import org.hk.doghub.ui.views.app.home.AppHomeView;
import org.hk.doghub.ui.views.app.tips.TipsView;
import org.hk.doghub.ui.views.app.users.UsersView;
import org.hk.doghub.ui.views.site.help.HelpView;
import org.hk.doghub.ui.views.site.notifications.NotificationsView;
import org.hk.doghub.ui.views.site.profile.ProfileView;
import org.hk.doghub.ui.views.site.settings.SettingsView;

import static org.vaadin.lineawesome.LineAwesomeIcon.*;

public class DogHubAppLayoutDrawerContentNavigation extends AppNav {

    public static final String CLASS_NAME = DogHubAppLayoutDrawerContent.CLASS_NAME + "-navigation";

    public DogHubAppLayoutDrawerContentNavigation(AccessAnnotationChecker accessChecker) {
        addClassName(CLASS_NAME);
        if (accessChecker.hasAccess(AppHomeView.class)) {
            AppNavItem appHome = new AppNavItem(AppHomeView.NAME, AppHomeView.class, HOME_SOLID.create());
            if (accessChecker.hasAccess(ProfileView.class)) {
                AppNavItem profile = new AppNavItem(ProfileView.NAME, ProfileView.class, ID_BADGE_SOLID.create());
                appHome.addItem(profile);
            }
            if (accessChecker.hasAccess(SettingsView.class)) {
                AppNavItem settings = new AppNavItem(SettingsView.NAME, SettingsView.class, COG_SOLID.create());
                appHome.addItem(settings);
            }
            if (accessChecker.hasAccess(NotificationsView.class)) {
                AppNavItem notifications = new AppNavItem(NotificationsView.NAME, NotificationsView.class, BELL.create());
                appHome.addItem(notifications);
            }
            if (accessChecker.hasAccess(HelpView.class)) {
                AppNavItem help = new AppNavItem(HelpView.NAME, HelpView.class, QUESTION_CIRCLE.create());
                appHome.addItem(help);
            }
            addItem(appHome);
        }
        if (accessChecker.hasAccess(DogsView.class)) {
            AppNavItem dogs = new AppNavItem(DogsView.NAME, DogsView.class, DOG_SOLID.create());
            addItem(dogs);
        }
        if (accessChecker.hasAccess(TipsView.class)) {
            AppNavItem tips = new AppNavItem(TipsView.NAME, TipsView.class, LINK_SOLID.create());
            addItem(tips);
        }
        if (accessChecker.hasAccess(AdminView.class)) {
            AppNavItem admin = new AppNavItem(AdminView.NAME, AdminView.class, TOOLS_SOLID.create());
            if (accessChecker.hasAccess(UsersView.class)) {
                AppNavItem users = new AppNavItem(UsersView.NAME, UsersView.class, USERS_COG_SOLID.create());
                admin.addItem(users);
            }
            addItem(admin);
        }
        if (accessChecker.hasAccess(AboutView.class)) {
            AppNavItem about = new AppNavItem(AboutView.NAME, AboutView.class, INFO_CIRCLE_SOLID.create());
            addItem(about);
        }
        addItem(new AppNavItem("View Code", "https://github.com/oferka/doghub", GITHUB.create()));
    }
}
