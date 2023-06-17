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
            AppNavItem appHomeNavItem = new AppNavItem(AppHomeView.NAME, AppHomeView.class, HOME_SOLID.create());
            if (accessChecker.hasAccess(ProfileView.class)) {
                AppNavItem profileAppNavItem = new AppNavItem(ProfileView.NAME, ProfileView.class, ID_BADGE_SOLID.create());
                appHomeNavItem.addItem(profileAppNavItem);
            }
            if (accessChecker.hasAccess(SettingsView.class)) {
                AppNavItem settingsAppNavItem = new AppNavItem(SettingsView.NAME, SettingsView.class, COG_SOLID.create());
                appHomeNavItem.addItem(settingsAppNavItem);
            }
            if (accessChecker.hasAccess(NotificationsView.class)) {
                AppNavItem notificationsAppNavItem = new AppNavItem(NotificationsView.NAME, NotificationsView.class, BELL.create());
                appHomeNavItem.addItem(notificationsAppNavItem);
            }
            if (accessChecker.hasAccess(HelpView.class)) {
                AppNavItem helpAppNavItem = new AppNavItem(HelpView.NAME, HelpView.class, QUESTION_CIRCLE.create());
                appHomeNavItem.addItem(helpAppNavItem);
            }
            addItem(appHomeNavItem);
        }
        if (accessChecker.hasAccess(DogsView.class)) {
            AppNavItem dogsNavItem = new AppNavItem(DogsView.NAME, DogsView.class, DOG_SOLID.create());
            addItem(dogsNavItem);
        }
        if (accessChecker.hasAccess(TipsView.class)) {
            AppNavItem tipsNavItem = new AppNavItem(TipsView.NAME, TipsView.class, LINK_SOLID.create());
            addItem(tipsNavItem);
        }
        if (accessChecker.hasAccess(AboutView.class)) {
            AppNavItem aboutNavItem = new AppNavItem(AboutView.NAME, AboutView.class, INFO_CIRCLE_SOLID.create());
            addItem(aboutNavItem);
        }
        if (accessChecker.hasAccess(AdminView.class)) {
            AppNavItem adminAppNavItem = new AppNavItem(AdminView.NAME, AdminView.class, TOOLS_SOLID.create());
            if (accessChecker.hasAccess(UsersView.class)) {
                AppNavItem usersAppNavItem = new AppNavItem(UsersView.NAME, UsersView.class, USERS_COG_SOLID.create());
                adminAppNavItem.addItem(usersAppNavItem);
            }
            addItem(adminAppNavItem);
        }
    }
}
