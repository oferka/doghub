package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityAvatar;
import org.hk.doghub.ui.views.site.help.HelpView;
import org.hk.doghub.ui.views.site.notifications.NotificationsView;
import org.hk.doghub.ui.views.site.profile.ProfileView;
import org.hk.doghub.ui.views.site.settings.SettingsView;

import java.util.Optional;

import static com.vaadin.flow.component.menubar.MenuBarVariant.LUMO_TERTIARY_INLINE;

public class UserMenuBar extends MenuBar {

    public static final String CLASS_NAME = "user-menu-bar";

    public UserMenuBar(AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_TERTIARY_INLINE);
        Optional<DogHubUser> maybeUser = authenticatedUser.get();
        if (maybeUser.isPresent()) {
            DogHubUser user = maybeUser.get();
            EntityAvatar<DogHubUser> userAvatar = new EntityAvatar<>(user);
            MenuItem menuItem = addItem(userAvatar);
            SubMenu subMenu = menuItem.getSubMenu();
            subMenu.addItem(new RouterLink(ProfileView.NAME, ProfileView.class));
            subMenu.addItem(new RouterLink(SettingsView.NAME, SettingsView.class));
            subMenu.addItem(new RouterLink(NotificationsView.NAME, NotificationsView.class));
            subMenu.addItem(new RouterLink(HelpView.NAME, HelpView.class));
            subMenu.add(new Hr());
            subMenu.addItem(new SignOutButton(authenticatedUser));
        }
    }
}
