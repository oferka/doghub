package org.hk.doghub.ui.components.shared.user;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityCreationContainerForm;
import org.hk.doghub.ui.components.shared.EntityCreationParameters;
import org.hk.doghub.ui.components.shared.EntityCreationService;
import org.hk.doghub.ui.views.app.users.user.UserView;
import org.hk.doghub.ui.views.site.profile.ProfileView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

@Slf4j
public class UserCreationContainerForm extends EntityCreationContainerForm<DogHubUser, UserCreationParameters> {

    public static final String CLASS_NAME = "user-creation-container-form";

    private UserEmailField emailField;

    private UserPasswordField passwordField;

    public UserCreationContainerForm(AuthenticatedUser authenticatedUser, EntityCreationService<DogHubUser, UserCreationParameters> entityCreationService) {
        super(authenticatedUser, entityCreationService);
    }

    @Override
    protected void addClassName() {
        addClassName(CLASS_NAME);
    }

    @Override
    protected void createFields() {
        emailField = new UserEmailField();
        passwordField = new UserPasswordField();
    }

    @Override
    protected void addFields() {
        add(emailField, passwordField);
    }

    @Override
    protected DogHubUser create(EntityCreationParameters creationParameters) {
        return creationService.create(((UserCreationParameters) creationParameters));
    }

    @Override
    protected EntityCreationParameters getCreationParameters() {
        UserCreationParameters result = new UserCreationParameters();
        result.setName(emailField.getValue());
        result.setPassword(passwordField.getValue());
        return result;
    }

    @Override
    protected List<String> validateInput() {
        List<String> result = new ArrayList<>();
        String email = emailField.getValue();
        String password = passwordField.getValue();
        if(email.isBlank()) {
            log.warn("Attempt to create a user with blank email");
            result.add("Can't create a user with a blank email. Please enter your email address");
        }
        if(emailField.isInvalid()) {
            log.warn("Attempt to create a user with invalid email '{}'", email);
            result.add(format("Can't signup a user with email '%s'. Please enter a valid email address", email));
        }
        EntityCreationParameters creationParameters = getCreationParameters();
        if(creationService.exists((UserCreationParameters) creationParameters)) {
            log.warn("Attempt to create a user with existing email '{}'", email);
            emailField.setInvalid(true);
            emailField.setErrorMessage("A user with this email already exists.");
            result.add(format("A user with email '%s' already exists. Please use sign in if this is your account, or use a different email address to sign up", email));
        }
        if(password.isBlank()) {
            log.warn("Attempt to create a user with blank password");
            result.add("Can't signup user with blank password. Please a valid password");
        }
        if(passwordField.isInvalid()) {
            log.warn("Attempt to create a user with invalid password '{}'", password);
            result.add("Can't signup user. Please enter a valid password");
        }
        return result;
    }

    @Override
    protected void postSuccessfulCreation(DogHubUser entity) {
        if(isUserSignup()) {
            navigateToProfilePage();
        }
        else {
            if(isUserCreationByAdmin()) {
                navigateToCreatedUserView(entity);
            }
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
