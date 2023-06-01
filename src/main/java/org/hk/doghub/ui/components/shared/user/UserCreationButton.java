package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.users.user.UserView;
import org.hk.doghub.ui.views.site.profile.ProfileView;
import org.springframework.dao.DataIntegrityViolationException;

import static com.vaadin.flow.component.Key.KEY_C;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.notification.Notification.Position.TOP_CENTER;
import static java.lang.String.format;

@Slf4j
public class UserCreationButton extends Button {

    public static final String CLASS_NAME = "user-creation-button";

    private final UserEmailField emailField;

    private final UserPasswordField passwordField;

    private final AuthenticatedUser authenticatedUser;

    private final UserCreationService userCreationService;

    public UserCreationButton(UserEmailField emailField, UserPasswordField passwordField, AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        this.emailField = emailField;
        this.passwordField = passwordField;
        this.authenticatedUser = authenticatedUser;
        this.userCreationService = userCreationService;
        addClassName(CLASS_NAME);
        setText("Continue");
        addClickListener(this::clicked);
        addClickShortcut(KEY_C, ALT);
    }

    private void clicked(ClickEvent<Button> event) {
        String email = emailField.getValue();
        String password = passwordField.getValue();
        log.info("Signup flow for user with email '{}' has started", email);
        if(email.isBlank()) {
            log.warn("Attempt to signup user with blank email");
            Notification notification = Notification.show("Can't signup user with blank email. Please enter your email address", 5000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            return;
        }
        if(emailField.isInvalid()) {
            log.warn("Attempt to signup user with invalid email '{}'", email);
            Notification notification = Notification.show(format("Can't signup user with email '%s'. Please enter a valid email address", email), 5000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            return;
        }
        if(userCreationService.exists(email)) {
            log.warn("Attempt to signup user with existing email '{}'", email);
            emailField.setInvalid(true);
            Notification notification = Notification.show(format("A user with email '%s' already exists. Please use sign in if this is your account, or use a different email address to sign up", email), 10000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            return;
        }
        if(password.isBlank()) {
            log.warn("Attempt to signup user with blank password");
            Notification notification = Notification.show("Can't signup user with blank password. Please a valid password", 5000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            return;
        }
        if(passwordField.isInvalid()) {
            log.warn("Attempt to signup user with invalid password '{}'", password);
            Notification notification = Notification.show("Can't signup user. Please enter a valid password", 5000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            return;
        }
        try {
            DogHubUser user = userCreationService.create(email, password);
            Notification notification = Notification.show(format("User %s is now signed up!", user.getUsername()), 3000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            if(isUserSignup()) {
                navigateToProfilePage();
            }
            else {
                if(isUserCreationByAdmin()) {
                    navigateToCreatedUserView(user);
                }
            }
        }
        catch (DataIntegrityViolationException e) {
            log.warn("Data integrity violation exception was thrown", e);
            Notification notification = Notification.show(format("A user with email '%s' already exists. Please use sign in if this is your account, or use a different email address to sign up", email), 5000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        }
        catch (Exception e) {
            log.error("Unexpected exception was thrown", e);
            Notification notification = Notification.show(format("Failed to sign up user with email %s. Please try again later", email), 5000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        }
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
