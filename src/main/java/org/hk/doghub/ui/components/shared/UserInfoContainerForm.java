package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.vaadin.flow.component.icon.VaadinIcon.MAILBOX;
import static com.vaadin.flow.component.notification.Notification.Position.TOP_CENTER;
import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static java.lang.String.format;
import static org.hk.doghub.ui.components.shared.UserEmailField.LABEL;


@Slf4j
public class UserInfoContainerForm extends FormLayout {

    public static final String CLASS_NAME = UserInfoContainer.CLASS_NAME + "-form";

    private final UserIdField id;
    private final UserUsernameField username;
    private final UserTitleField title;
    private final UserNameField name;
    private final UserMobileNumberField mobileNumber;
    private final UserEmailField email;
    private final UserThumbnailPictureField thumbnailPicture;
    private final UserCompanyField company;
    private final UserDateOfBirthField dateOfBirth;
    private final UserDateOfRegistrationField dateOfRegistration;
    private final UserCountryField country;
    private final UserStateField state;
    private final UserCityField city;
    private final UserStreetNameField streetName;
    private final UserStreetNumberField streetNumber;
    private final UserPostcodeField postcode;

    private final UsersDataProvider usersDataProvider;

    private final UserCreationService userCreationService;

    public UserInfoContainerForm(UsersDataProvider usersDataProvider, UserCreationService userCreationService) {
        this.usersDataProvider = usersDataProvider;
        this.userCreationService = userCreationService;
        addClassName(CLASS_NAME);

        id = new UserIdField();
        username = new UserUsernameField();
        title = new UserTitleField();
        name = new UserNameField();
        mobileNumber = new UserMobileNumberField();
        email = new UserEmailField();
        email.setLabel(LABEL);
        email.setPrefixComponent(MAILBOX.create());
        email.setValueChangeMode(EAGER);
        thumbnailPicture = new UserThumbnailPictureField();
        company = new UserCompanyField();
        dateOfBirth = new UserDateOfBirthField();
        dateOfRegistration = new UserDateOfRegistrationField();
        country = new UserCountryField();
        state = new UserStateField();
        city = new UserCityField();
        streetName = new UserStreetNameField();
        streetNumber = new UserStreetNumberField();
        postcode = new UserPostcodeField();

        setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("500px", 2));
        setColspan(id, 1);
        setColspan(username, 1);
        setColspan(title, 1);
        setColspan(name, 1);
        setColspan(mobileNumber, 1);
        setColspan(email, 1);
        setColspan(thumbnailPicture, 2);
        setColspan(company, 2);
        setColspan(dateOfBirth, 1);
        setColspan(dateOfRegistration, 1);
        setColspan(country, 1);
        setColspan(state, 1);
        setColspan(city, 1);
        setColspan(streetName, 1);
        setColspan(streetNumber, 1);
        setColspan(postcode, 1);
        add(id, username, title, name, mobileNumber, email, thumbnailPicture, company, dateOfBirth, dateOfRegistration, country, state, city, streetName, streetNumber, postcode);
    }

    public void setUser(DogHubUser user) {
        id.setValue(user);
        username.setValue(user);
        title.setValue(user);
        name.setValue(user);
        mobileNumber.setValue(user);
        email.setValue(user);
        thumbnailPicture.setValue(user);
        company.setValue(user);
        dateOfBirth.setValue(user);
        dateOfRegistration.setValue(user);
        country.setValue(user);
        state.setValue(user);
        city.setValue(user);
        streetName.setValue(user);
        streetNumber.setValue(user);
        postcode.setValue(user);
    }

    public void save() {
        log.info("Save for user with ID '{}' has started", id.getValue());
        List<String> violations = validateInput();
        if(violations.isEmpty()) {
            try {
                userCreationService.save(
                        id.getValueAsLong(),
                        username.getValue(),
                        title.getValue(),
                        name.getValue(),
                        mobileNumber.getValue(),
                        email.getValue(),
                        thumbnailPicture.getValue(),
                        company.getValue(),
                        dateOfBirth.getValueAsZonedDateTime(),
                        dateOfRegistration.getValueAsZonedDateTime(),
                        country.getValue(),
                        state.getValue(),
                        city.getValue(),
                        streetName.getValue(),
                        streetNumber.getValue(),
                        postcode.getValue()
                );
                Notification notification = Notification.show(format("User %s saved successfully!", username.getValue()), 3000, TOP_CENTER);
                notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            }
            catch (Exception e) {
                log.error("Unexpected exception was thrown", e);
                Notification notification = Notification.show("Failed to save user!", 5000, TOP_CENTER);
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            }
        }
        else {
            Notification notification = Notification.show("Failed to save user: " + violations, 5000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        }
        log.info("Save for user with ID '{}' has completed", id.getValue());
    }

    private List<String> validateInput() {
        List<String> violations = new ArrayList<>();
        violations.addAll(id.validateUserField());
        violations.addAll(username.validateUserField());
        violations.addAll(title.validateUserField());
        violations.addAll(name.validateUserField());
        violations.addAll(mobileNumber.validateUserField());
        violations.addAll(email.validateUserField());
        violations.addAll(thumbnailPicture.validateUserField());
        violations.addAll(company.validateUserField());
        violations.addAll(dateOfBirth.validateUserField());
        violations.addAll(dateOfRegistration.validateUserField());
        violations.addAll(country.validateUserField());
        violations.addAll(state.validateUserField());
        violations.addAll(city.validateUserField());
        violations.addAll(streetName.validateUserField());
        violations.addAll(streetNumber.validateUserField());
        violations.addAll(postcode.validateUserField());
        return violations;
    }

    public void cancel() {
        Optional<DogHubUser> userOptional = usersDataProvider.findById(id.getValue().longValue());
        userOptional.ifPresent(this::setUser);
    }
}
