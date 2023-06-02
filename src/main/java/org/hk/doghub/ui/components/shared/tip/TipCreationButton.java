package org.hk.doghub.ui.components.shared.tip;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.create.TipCreationService;
import org.hk.doghub.ui.views.app.users.user.UserView;
import org.hk.doghub.ui.views.site.profile.ProfileView;

import static com.vaadin.flow.component.Key.KEY_C;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.notification.Notification.Position.TOP_CENTER;
import static java.lang.String.format;

@Slf4j
public class TipCreationButton extends Button {

    public static final String CLASS_NAME = "tip-creation-button";

    private final TipTitleField title;

    private final AuthenticatedUser authenticatedUser;

    private final TipCreationService tipCreationService;

    public TipCreationButton(TipTitleField title, AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        this.title = title;
        this.authenticatedUser = authenticatedUser;
        this.tipCreationService = tipCreationService;
        addClassName(CLASS_NAME);
        setText("Continue");
        addClickListener(this::clicked);
        addClickShortcut(KEY_C, ALT);
    }

    private void clicked(ClickEvent<Button> event) {
        String titleValue = title.getValue();
        log.info("Tip creation flow for tip with title '{}' has started", titleValue);
        if(titleValue.isBlank()) {
            log.warn("Attempt to create a tip with blank title");
            Notification notification = Notification.show("Can't create a tip with a blank title. Please enter something...", 5000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            return;
        }
        if(title.isInvalid()) {
            log.warn("Attempt to create a tip with invalid title '{}'", titleValue);
            Notification notification = Notification.show(format("Can't create a tip with title '%s'. Please enter a valid title", titleValue), 5000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            return;
        }
//        if(userCreationService.exists(email)) {
//            log.warn("Attempt to signup user with existing email '{}'", email);
//            emailField.setInvalid(true);
//            Notification notification = Notification.show(format("A user with email '%s' already exists. Please use sign in if this is your account, or use a different email address to sign up", email), 10000, TOP_CENTER);
//            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
//            return;
//        }
//        if(password.isBlank()) {
//            log.warn("Attempt to signup user with blank password");
//            Notification notification = Notification.show("Can't signup user with blank password. Please a valid password", 5000, TOP_CENTER);
//            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
//            return;
//        }
//        if(passwordField.isInvalid()) {
//            log.warn("Attempt to signup user with invalid password '{}'", password);
//            Notification notification = Notification.show("Can't signup user. Please enter a valid password", 5000, TOP_CENTER);
//            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
//            return;
//        }
//        try {
//            DogHubUser user = userCreationService.create(email, password);
//            Notification notification = Notification.show(format("User %s is now signed up!", user.getUsername()), 3000, TOP_CENTER);
//            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
//            if(isUserSignup()) {
//                navigateToProfilePage();
//            }
//            else {
//                if(isUserCreationByAdmin()) {
//                    navigateToCreatedUserView(user);
//                }
//            }
//        }
//        catch (DataIntegrityViolationException e) {
//            log.warn("Data integrity violation exception was thrown", e);
//            Notification notification = Notification.show(format("A user with email '%s' already exists. Please use sign in if this is your account, or use a different email address to sign up", email), 5000, TOP_CENTER);
//            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
//        }
//        catch (Exception e) {
//            log.error("Unexpected exception was thrown", e);
//            Notification notification = Notification.show(format("Failed to sign up user with email %s. Please try again later", email), 5000, TOP_CENTER);
//            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
//        }
    }

    private boolean isUserSignup() {
        return authenticatedUser.get().isEmpty();
    }

    private boolean isUserCreationByAdmin() {
        return  authenticatedUser.hasAdminRole();
    }

    private void navigateToProfilePage() {
        getUI().ifPresent(ui -> ui.navigate(ProfileView.class));
    }

    private void navigateToCreatedUserView(DogHubUser user) {
        getUI().ifPresent(ui -> ui.navigate(UserView.class, user.getId()));
    }
}
