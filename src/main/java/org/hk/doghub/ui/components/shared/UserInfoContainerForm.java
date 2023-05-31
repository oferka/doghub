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

import static com.vaadin.flow.component.icon.VaadinIcon.*;
import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class UserInfoContainerForm extends FormLayout {

    public static final String CLASS_NAME = UserInfoContainer.CLASS_NAME + "-form";

    private final UserIdField id;
    private final TextField name;
    private final TextField username;
    private final UserEmailField email;
    private final ComboBox<String> title;
    private final TextField thumbnailPicture;
    private final DateTimePicker dateOfBirth;
    private final DateTimePicker dateOfRegistration;
    private final TextField company;
    private final TextField mobileNumber;
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

        username = new TextField("User Name");
        username.setRequiredIndicatorVisible(true);
        username.setReadOnly(true);
        username.setMinLength(5);
        username.setMaxLength(128);
        username.setPrefixComponent(USER.create());
        username.setValueChangeMode(EAGER);
        username.addValueChangeListener(this::usernameValueChanged);

        title = new ComboBox<>("Title");
        title.setHelperText("Select or type your title");
        List<String> titleValues = asList("Mr.", "Mrs.", "Ms.", "Miss", "Dr.", "Rev.", "Prof.", "Hon.", "Capt.", "Col.", "Lt.", "Sen.", "Rep.", "Gov.", "Pres.", "Sir", "Dame", "Lady", "Lord", "Knight", "Prince", "Princess");
        title.setItems(titleValues);
        title.setAllowCustomValue(true);
        title.addCustomValueSetListener(this::customTitleValueEntered);

        name = new TextField("Name");
        name.setRequiredIndicatorVisible(true);
        name.setClearButtonVisible(true);
        name.setMinLength(2);
        name.setMaxLength(128);
        name.setValueChangeMode(EAGER);
        name.addValueChangeListener(this::nameValueChanged);

        email = new UserEmailField();
        email.setLabel("Email");
        email.setClearButtonVisible(true);
        email.setMinLength(5);
        email.setMaxLength(128);
        email.setPrefixComponent(MAILBOX.create());
        email.setValueChangeMode(EAGER);

        thumbnailPicture = new TextField("Avatar URL");
        thumbnailPicture.setClearButtonVisible(true);
        thumbnailPicture.setMinLength(5);
        thumbnailPicture.setMaxLength(256);
        thumbnailPicture.setPrefixComponent(PICTURE.create());
        thumbnailPicture.setValueChangeMode(EAGER);
        thumbnailPicture.addValueChangeListener(this::thumbnailPictureValueChanged);

        company = new TextField("Company");
        company.setClearButtonVisible(true);
        company.setMinLength(2);
        company.setMaxLength(64);
        company.setPrefixComponent(FACTORY.create());
        company.setValueChangeMode(EAGER);
        company.addValueChangeListener(this::companyValueChanged);

        dateOfBirth = new DateTimePicker("Date of Birth");

        dateOfRegistration = new DateTimePicker("Date of Registration");
        dateOfRegistration.setReadOnly(true);

        mobileNumber = new TextField("Mobile Phone");
        mobileNumber.setClearButtonVisible(true);
        mobileNumber.setAllowedCharPattern("[0-9()+-]");
        mobileNumber.setPrefixComponent(PHONE.create());
        mobileNumber.setValueChangeMode(EAGER);
        mobileNumber.addValueChangeListener(this::mobileNumberValueChanged);

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

    private void usernameValueChanged(ComponentValueChangeEvent<TextField, String> event) {
        String value = event.getValue();
        if(value.length() < 5 || value.length() > 128) {
            event.getSource().setInvalid(true);
            event.getSource().setErrorMessage("User name length must be between 5 and 128 characters");
        }
        else {
            event.getSource().setInvalid(false);
            event.getSource().setErrorMessage(null);
        }
    }

    private void customTitleValueEntered(CustomValueSetEvent<ComboBox<String>> event) {
        String value = event.getDetail();
        if(value.length() < 2 || value.length() > 64) {
            event.getSource().setInvalid(true);
            event.getSource().setErrorMessage("Title length must be between 2 and 64 characters");
        }
        else {
            event.getSource().setValue(value);
            event.getSource().setInvalid(false);
            event.getSource().setErrorMessage(null);
        }
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

    private void nameValueChanged(ComponentValueChangeEvent<TextField, String> event) {
        String value = event.getValue();
        if(value.length() < 2 || value.length() > 128) {
            event.getSource().setInvalid(true);
            event.getSource().setErrorMessage("Name length must be between 2 and 128 characters");
        }
        else {
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

    private void companyValueChanged(ComponentValueChangeEvent<TextField, String> event) {
        String value = event.getValue();
        if(value.length() < 2 || value.length() > 64) {
            event.getSource().setInvalid(true);
            event.getSource().setErrorMessage("Company length must be between 2 and 64 characters");
        }
        else {
            event.getSource().setInvalid(false);
            event.getSource().setErrorMessage(null);
        }
    }

    private void mobileNumberValueChanged(ComponentValueChangeEvent<TextField, String> event) {
        String value = event.getValue();
        if(value.length() < 2 || value.length() > 64) {
            event.getSource().setInvalid(true);
            event.getSource().setErrorMessage("Mobile number length must be between 2 and 64 characters");
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
        name.setValue(user.getName());
        username.setValue(user.getUsername());
        email.setValue((user.getEmail() != null)?user.getEmail() : EMPTY);
        title.setValue((user.getTitle() != null)?user.getTitle() : EMPTY);
        thumbnailPicture.setValue((user.getThumbnailPicture() != null)?user.getThumbnailPicture() : EMPTY);
        dateOfBirth.setValue((user.getDateOfBirth() != null)?user.getDateOfBirth().toLocalDateTime() : null);
        dateOfRegistration.setValue((user.getDateOfRegistration() != null)?user.getDateOfRegistration().toLocalDateTime() : null);
        company.setValue((user.getCompany() != null)?user.getCompany() : EMPTY);
        mobileNumber.setValue((user.getMobileNumber() != null)?user.getMobileNumber() : EMPTY);
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
                name.getValue(),
                username.getValue(),
                email.getValue(),
                title.getValue(),
                thumbnailPicture.getValue(),
                (dateOfBirth.getValue() != null)?ZonedDateTime.of(dateOfBirth.getValue(), ZoneId.systemDefault()) : null,
                (dateOfRegistration.getValue() != null)?ZonedDateTime.of(dateOfRegistration.getValue(),ZoneId.systemDefault()): null,
                company.getValue(),
                mobileNumber.getValue(),
                number.getValue(),
                streetName.getValue(),
                city.getValue(),
                state.getValue(),
                country.getValue(),
                postcode.getValue()
        );
    }

    public void cancel() {
        Optional<DogHubUser> userOptional = usersDataProvider.findById(id.getValue().longValue());
        userOptional.ifPresent(this::setUser);
    }
}