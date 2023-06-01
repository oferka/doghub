package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.formlayout.FormLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import java.util.Optional;

import static com.vaadin.flow.component.icon.VaadinIcon.MAILBOX;
import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static org.hk.doghub.ui.components.shared.UserEmailField.LABEL;

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

    private final AuthenticatedUser authenticatedUser;

    private final UserCreationService userCreationService;

    public UserInfoContainerForm(UsersDataProvider usersDataProvider, AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        this.usersDataProvider = usersDataProvider;
        this.authenticatedUser = authenticatedUser;
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
    }

    public void cancel() {
        Optional<DogHubUser> userOptional = usersDataProvider.findById(id.getValue().longValue());
        userOptional.ifPresent(this::setUser);
    }
}
