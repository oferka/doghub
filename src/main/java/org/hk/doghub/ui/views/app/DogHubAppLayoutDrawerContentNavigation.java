package org.hk.doghub.ui.views.app;

import com.vaadin.flow.server.auth.AccessAnnotationChecker;
import org.hk.doghub.ui.components.appnav.AppNav;
import org.hk.doghub.ui.components.appnav.AppNavItem;
import org.hk.doghub.ui.views.app.about.AboutView;
import org.hk.doghub.ui.views.app.admin.AdminView;
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
        if (accessChecker.hasAccess(TipsView.class)) {
            AppNavItem urlsNavItem = new AppNavItem(TipsView.NAME, TipsView.class, LINK_SOLID.create());
            addItem(urlsNavItem);
        }
//        if (accessChecker.hasAccess(MinimizeView.class)) {
//            AppNavItem minimizeNavItem = new AppNavItem(MinimizeView.NAME, MinimizeView.class, COMPRESS_SOLID.create());
//            addItem(minimizeNavItem);
//        }
//        if (accessChecker.hasAccess(MonitorView.class)) {
//            AppNavItem monitorNavItem = new AppNavItem(MonitorView.NAME, MonitorView.class, EYE.create());
//            addItem(monitorNavItem);
//        }
//        if (accessChecker.hasAccess(ScrapeView.class)) {
//            AppNavItem scrapeNavItem = new AppNavItem(ScrapeView.NAME, ScrapeView.class, SCROLL_SOLID.create());
//            addItem(scrapeNavItem);
//        }
//        if (accessChecker.hasAccess(AutomateView.class)) {
//            AppNavItem automateNavItem = new AppNavItem(AutomateView.NAME, AutomateView.class, ROBOT_SOLID.create());
//            addItem(automateNavItem);
//        }
//        if (accessChecker.hasAccess(TagView.class)) {
//            AppNavItem tagNavItem = new AppNavItem(TagView.NAME, TagView.class, TAG_SOLID.create());
//            addItem(tagNavItem);
//        }
//        if (accessChecker.hasAccess(ReadView.class)) {
//            AppNavItem readNavItem = new AppNavItem(ReadView.NAME, ReadView.class, BOOK_READER_SOLID.create());
//            addItem(readNavItem);
//        }
//        if (accessChecker.hasAccess(NoteView.class)) {
//            AppNavItem noteNavItem = new AppNavItem(NoteView.NAME, NoteView.class, STICKY_NOTE.create());
//            addItem(noteNavItem);
//        }
//        if (accessChecker.hasAccess(RecommendView.class)) {
//            AppNavItem recommendNavItem = new AppNavItem(RecommendView.NAME, RecommendView.class, BULLSEYE_SOLID.create());
//            addItem(recommendNavItem);
//        }
//        if (accessChecker.hasAccess(BookmarkView.class)) {
//            AppNavItem bookmarkNavItem = new AppNavItem(BookmarkView.NAME, BookmarkView.class, BOOKMARK.create());
//            addItem(bookmarkNavItem);
//        }
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
