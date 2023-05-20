package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.views.site.profile.ProfileView;
import org.springframework.dao.DataIntegrityViolationException;

import static com.vaadin.flow.component.notification.Notification.Position.TOP_CENTER;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static java.lang.String.format;

@Slf4j
public class SignupWithEmail extends VerticalLayout {

    public static final String CLASS_NAME = SignupBody.CLASS_NAME + "-signup-with-email";

    private final EmailContainer emailContainer;

    private final PasswordContainer passwordContainer;

    private final SignupWithEmailButton button;

    private final SignupService signupService;

    public SignupWithEmail(SignupService signupService) {
        this.signupService = signupService;
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        emailContainer = new EmailContainer();
        add(emailContainer);

        passwordContainer = new PasswordContainer();
        add(passwordContainer);

        button = new SignupWithEmailButton();
        button.addClickListener(this::continueClicked);
        add(button);
    }

    private void continueClicked(ClickEvent<Button> event) {
        String email = emailContainer.getValue();
        String password = passwordContainer.getValue();
        log.info("Signup flow for user with email '{}' has started", email);
        if(email.isBlank()) {
            log.warn("Attempt to signup user with blank email");
            Notification notification = Notification.show("Can't signup user with blank email. Please enter your email address", 5000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            return;
        }
        if(emailContainer.isInvalid()) {
            log.warn("Attempt to signup user with invalid email '{}'", email);
            Notification notification = Notification.show(format("Can't signup user with email '%s'. Please enter a valid email address", email), 5000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            return;
        }
        if(signupService.exists(email)) {
            log.warn("Attempt to signup user with existing email '{}'", email);
            emailContainer.setInvalid(true);
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
        if(passwordContainer.isInvalid()) {
            log.warn("Attempt to signup user with invalid password '{}'", password);
            Notification notification = Notification.show("Can't signup user. Please enter a valid password", 5000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            return;
        }
        try {
            DogHubUser user = signupService.signupWithEmailAndPassword(email, password);
            Notification notification = Notification.show(format("User %s is now signed up!", user.getUsername()), 3000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            button.getUI().ifPresent(ui -> ui.navigate(ProfileView.class));
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
}
