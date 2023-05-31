package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.combobox.ComboBoxBase.CustomValueSetEvent;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import org.apache.commons.validator.routines.UrlValidator;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import static com.vaadin.flow.component.icon.VaadinIcon.MAILBOX;
import static com.vaadin.flow.component.icon.VaadinIcon.MAP_MARKER;
import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.EMPTY;
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
    private final DateTimePicker dateOfBirth;
    private final DateTimePicker dateOfRegistration;
    private final ComboBox<String> country;
    private final ComboBox<String> state;
    private final TextField city;
    private final TextField streetName;
    private final IntegerField number;
    private final TextField postcode;

    private final UsersDataProvider usersDataProvider;

    private final UserCreationService userCreationService;

    public UserInfoContainerForm(UsersDataProvider usersDataProvider, AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
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

        dateOfBirth = new DateTimePicker("Date of Birth");

        dateOfRegistration = new DateTimePicker("Date of Registration");
        dateOfRegistration.setReadOnly(true);

        country = new ComboBox<>("Country");
        country.setHelperText("Select or type your country");
        List<String> countryValues = asList("USA", "Canada", "Israel", "Italy", "France", "Australia", "China", "Japan", "Mexico", "Russia", "Germany", "India");
        country.setItems(countryValues);
        country.setPrefixComponent(MAP_MARKER.create());
        country.setAllowCustomValue(true);
        country.addCustomValueSetListener(this::customCountryValueEntered);

        state = new ComboBox<>("State");
        state.setHelperText("Select or type your state");
        state.setPrefixComponent(MAP_MARKER.create());
        state.setClearButtonVisible(true);
        List<String> stateValues = asList("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana",
                "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
                "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");
        state.setItems(stateValues);
        state.addCustomValueSetListener(this::customStateValueEntered);

        city = new TextField("City");
        city.setClearButtonVisible(true);
        city.setMinLength(2);
        city.setMaxLength(64);
        city.setPrefixComponent(MAP_MARKER.create());
        city.setValueChangeMode(EAGER);
        city.addValueChangeListener(this::cityNumberValueChanged);

        streetName = new TextField("Street Name");
        streetName.setClearButtonVisible(true);
        streetName.setMinLength(2);
        streetName.setMaxLength(64);
        streetName.setPrefixComponent(MAP_MARKER.create());
        streetName.setValueChangeMode(EAGER);
        streetName.addValueChangeListener(this::streetNameNumberValueChanged);

        number = new IntegerField("Number");
        number.setMin(1);
        number.setMax(100000);
        number.setStepButtonsVisible(true);
        number.setErrorMessage("Number must be between 1 and 100000");
        number.setValueChangeMode(EAGER);

        postcode = new TextField("Postcode");
        postcode.setClearButtonVisible(true);
        postcode.setMinLength(2);
        postcode.setMaxLength(64);
        postcode.setPrefixComponent(MAP_MARKER.create());
        postcode.setValueChangeMode(EAGER);
        postcode.addValueChangeListener(this::postcodeNumberValueChanged);

        add(id, username, title, name, mobileNumber, email, thumbnailPicture, company, dateOfBirth, dateOfRegistration, country, state, city, streetName, number, postcode);

        setResponsiveSteps(
                // Use one column by default
                new ResponsiveStep("0", 1),
                // Use two columns, if layout's width exceeds 600px
                new ResponsiveStep("500px", 2)
        );
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
        setColspan(number, 1);
        setColspan(postcode, 1);
    }

    private void customCountryValueEntered(CustomValueSetEvent<ComboBox<String>> event) {
        String value = event.getDetail();
        if(value.length() < 2 || value.length() > 64) {
            event.getSource().setInvalid(true);
            event.getSource().setErrorMessage("Country length must be between 2 and 64 characters");
        }
        else {
            event.getSource().setValue(value);
            event.getSource().setInvalid(false);
            event.getSource().setErrorMessage(null);
        }
    }

    private void customStateValueEntered(CustomValueSetEvent<ComboBox<String>> event) {
        String value = event.getDetail();
        if(value.length() < 2 || value.length() > 64) {
            event.getSource().setInvalid(true);
            event.getSource().setErrorMessage("State length must be between 2 and 64 characters");
        }
        else {
            event.getSource().setValue(value);
            event.getSource().setInvalid(false);
            event.getSource().setErrorMessage(null);
        }
    }

    private void thumbnailPictureValueChanged(ComponentValueChangeEvent<TextField, String> event) {
        String value = event.getValue();
        if(!new UrlValidator().isValid(value)) {
            event.getSource().setInvalid(true);
            event.getSource().setErrorMessage("Must be a valid URL");
        }
        else {
            event.getSource().setInvalid(false);
            event.getSource().setErrorMessage(null);
        }
    }

    private void cityNumberValueChanged(ComponentValueChangeEvent<TextField, String> event) {
        String value = event.getValue();
        if(value.length() < 2 || value.length() > 64) {
            event.getSource().setInvalid(true);
            event.getSource().setErrorMessage("City length must be between 2 and 64 characters");
        }
        else {
            event.getSource().setInvalid(false);
            event.getSource().setErrorMessage(null);
        }
    }

    private void streetNameNumberValueChanged(ComponentValueChangeEvent<TextField, String> event) {
        String value = event.getValue();
        if(value.length() < 2 || value.length() > 64) {
            event.getSource().setInvalid(true);
            event.getSource().setErrorMessage("Street Name length must be between 2 and 64 characters");
        }
        else {
            event.getSource().setInvalid(false);
            event.getSource().setErrorMessage(null);
        }
    }

    private void postcodeNumberValueChanged(ComponentValueChangeEvent<TextField, String> event) {
        String value = event.getValue();
        if(value.length() < 2 || value.length() > 64) {
            event.getSource().setInvalid(true);
            event.getSource().setErrorMessage("Postcode length must be between 2 and 64 characters");
        }
        else {
            event.getSource().setInvalid(false);
            event.getSource().setErrorMessage(null);
        }
    }

    public void setUser(DogHubUser user) {
        id.setValue(user);
        username.setValue(user.getUsername());
        title.setValue((user.getTitle() != null)?user.getTitle() : EMPTY);
        name.setValue(user.getName());
        mobileNumber.setValue((user.getMobileNumber() != null)?user.getMobileNumber() : EMPTY);
        email.setValue((user.getEmail() != null)?user.getEmail() : EMPTY);
        thumbnailPicture.setValue((user.getThumbnailPicture() != null)?user.getThumbnailPicture() : EMPTY);
        company.setValue((user.getCompany() != null)?user.getCompany() : EMPTY);
        dateOfBirth.setValue((user.getDateOfBirth() != null)?user.getDateOfBirth().toLocalDateTime() : null);
        dateOfRegistration.setValue((user.getDateOfRegistration() != null)?user.getDateOfRegistration().toLocalDateTime() : null);
        country.setValue((user.getAddress() != null)?user.getAddress().getCountry() : EMPTY);
        state.setValue((user.getAddress() != null)?user.getAddress().getState() : EMPTY);
        city.setValue((user.getAddress() != null)?user.getAddress().getCity() : EMPTY);
        streetName.setValue((user.getAddress() != null)?user.getAddress().getStreetName() : EMPTY);
        number.setValue((user.getAddress() != null)?user.getAddress().getNumber() : 0);
        postcode.setValue((user.getAddress() != null)?user.getAddress().getPostcode() : EMPTY);
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
                (dateOfBirth.getValue() != null)?ZonedDateTime.of(dateOfBirth.getValue(), ZoneId.systemDefault()) : null,
                (dateOfRegistration.getValue() != null)?ZonedDateTime.of(dateOfRegistration.getValue(),ZoneId.systemDefault()): null,
                country.getValue(),
                state.getValue(),
                city.getValue(),
                streetName.getValue(),
                number.getValue(),
                postcode.getValue()
        );
    }

    public void cancel() {
        Optional<DogHubUser> userOptional = usersDataProvider.findById(id.getValue().longValue());
        userOptional.ifPresent(this::setUser);
    }
}
