package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.notification.Notification;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.*;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.vaadin.flow.component.icon.VaadinIcon.MAILBOX;
import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static org.hk.doghub.ui.components.shared.user.UserEmailField.LABEL;


@Slf4j
public class UserInfoContainerForm extends EntityInfoContainerForm<DogHubUser, UserUpdateParameters> {

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

    public UserInfoContainerForm(EntityDataProvider<DogHubUser> entityDataProvider, EntityUpdateService<DogHubUser, UserUpdateParameters> entityUpdateService) {
        super(entityDataProvider, entityUpdateService);
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

    public void setValue(DogHubUser user) {
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
                DogHubUser user = entityUpdateService.update(getUpdateParameters());
                log.info("Save successfully for user with ID '{}'", user.getId());
                showSavedSuccessfullyNotification();
            }
            catch (Exception e) {
                log.error("Unexpected exception was thrown", e);
                showSaveFailedWithUnexpectedErrorNotification();
            }
        }
        else {
            showSaveFailedWithInvalidInputNotification(violations);
        }
        log.info("Save for user with ID '{}' has completed", id.getValue());
    }

    private UserUpdateParameters getUpdateParameters() {
        UserUpdateParameters result = new UserUpdateParameters();
        result.setId(id.getValueAsLong());
        result.setName(name.getValue());
        result.setTitle(title.getValue());
        result.setMobileNumber(mobileNumber.getValue());
        result.setEmail(email.getValue());
        result.setThumbnailPicture(thumbnailPicture.getValue());
        result.setCompany(company.getValue());
        result.setDateOfBirth(dateOfBirth.getValueAsZonedDateTime());
        result.setNumber(streetNumber.getValue());
        result.setStreetName(streetName.getValue());
        result.setCity(city.getValue());
        result.setState(state.getValue());
        result.setCountry(country.getValue());
        result.setPostcode(postcode.getValue());
        return result;
    }

    public void cancel() {
        Optional<DogHubUser> userOptional = entityDataProvider.findById(id.getValue().longValue());
        userOptional.ifPresent(this::setValue);
    }

    private void showSavedSuccessfullyNotification() {
        Notification notification = new SavedSuccessfullyNotification();
        notification.open();
    }

    private void showSaveFailedWithUnexpectedErrorNotification() {
        Notification notification = new SaveFailedWithUnexpectedErrorNotification();
        notification.open();
    }

    private void showSaveFailedWithInvalidInputNotification(List<String> violations) {
        Notification notification = new SaveFailedWithInvalidInputNotification(violations);
        notification.open();
    }

    private List<String> validateInput() {
        List<String> violations = new ArrayList<>();
        violations.addAll(id.validateField());
        violations.addAll(username.validateField());
        violations.addAll(title.validateField());
        violations.addAll(name.validateField());
        violations.addAll(mobileNumber.validateField());
        violations.addAll(email.validateField());
        violations.addAll(thumbnailPicture.validateField());
        violations.addAll(company.validateField());
        violations.addAll(dateOfBirth.validateField());
        violations.addAll(dateOfRegistration.validateField());
        violations.addAll(country.validateField());
        violations.addAll(state.validateField());
        violations.addAll(city.validateField());
        violations.addAll(streetName.validateField());
        violations.addAll(streetNumber.validateField());
        violations.addAll(postcode.validateField());
        return violations;
    }
}
