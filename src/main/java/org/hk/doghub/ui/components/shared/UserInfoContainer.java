package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.vaadin.flow.component.icon.VaadinIcon.*;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class UserInfoContainer extends VerticalLayout {

    public static final String CLASS_NAME = "user-info-container";

    private final UsersDataProvider usersDataProvider;

    private final BigDecimalField id;
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

    private final UserInfoContainerButtons buttons;

    public UserInfoContainer(UsersDataProvider usersDataProvider, AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        this.usersDataProvider = usersDataProvider;
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        id = new BigDecimalField("ID");
        id.setReadOnly(true);

        title = new ComboBox<>("Title");
        title.setAllowCustomValue(true);
        List<String> titleValues = asList("Mr.", "Mrs.", "Ms.", "Miss", "Dr.", "Rev.", "Prof.", "Hon.", "Capt.", "Col.", "Lt.", "Sen.", "Rep.", "Gov.", "Pres.", "Sir", "Dame", "Lady", "Lord", "Knight", "Prince", "Princess");
        title.setItems(titleValues);
        title.setHelperText("Select or type your title");

        name = new TextField("Name");
        name.setRequiredIndicatorVisible(true);
        name.setClearButtonVisible(true);
        name.setMinLength(2);
        name.setMaxLength(128);

        username = new TextField("User Name");
        username.setRequiredIndicatorVisible(true);
        username.setReadOnly(true);
        username.setMinLength(5);
        username.setMaxLength(128);
        username.setPrefixComponent(USER.create());

        email = new UserEmailField();
        email.setLabel("Email");
        email.setClearButtonVisible(true);
        email.setMinLength(5);
        email.setMaxLength(128);
        email.setPrefixComponent(MAILBOX.create());

        thumbnailPicture = new TextField("Avatar URL");
        thumbnailPicture.setClearButtonVisible(true);
        thumbnailPicture.setMinLength(5);
        thumbnailPicture.setMaxLength(256);
        thumbnailPicture.setPrefixComponent(PICTURE.create());

        dateOfBirth = new DateTimePicker("Date of Birth");

        dateOfRegistration = new DateTimePicker("Date of Registration");
        dateOfRegistration.setReadOnly(true);

        company = new TextField("Company");
        company.setClearButtonVisible(true);
        company.setMinLength(2);
        company.setMaxLength(64);
        company.setPrefixComponent(FACTORY.create());

        mobileNumber = new TextField("Mobile Phone");
        mobileNumber.setClearButtonVisible(true);
//        mobileNumber.setPattern("^[+]?[(]?[0-9]{3}[)]?[-s.]?[0-9]{3}[-s.]?[0-9]{4,6}$");
        mobileNumber.setAllowedCharPattern("[0-9()+-]");
        mobileNumber.setPrefixComponent(PHONE.create());

        country = new ComboBox<>("Country");
        country.setAllowCustomValue(true);
        List<String> countryValues = asList("USA", "Canada", "Israel", "Italy", "France", "Australia", "China", "Japan", "Mexico", "Russia", "Germany", "India");
        country.setItems(countryValues);
        country.setHelperText("Select or type your country");
        country.setPrefixComponent(MAP_MARKER.create());

        state = new ComboBox<>("State");
        state.setClearButtonVisible(true);
        List<String> stateValues = asList("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana",
                "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
                "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");
        state.setItems(stateValues);
        state.setHelperText("Select or type your state");
        state.setPrefixComponent(MAP_MARKER.create());

        city = new TextField("City");
        city.setClearButtonVisible(true);
        city.setMinLength(2);
        city.setMaxLength(64);
        city.setPrefixComponent(MAP_MARKER.create());

        streetName = new TextField("Street Name");
        streetName.setClearButtonVisible(true);
        streetName.setMinLength(2);
        streetName.setMaxLength(64);
        streetName.setPrefixComponent(MAP_MARKER.create());

        number = new IntegerField("Number");
        number.setClearButtonVisible(true);
        number.setPrefixComponent(MAP_MARKER.create());

        postcode = new TextField("Postcode");
        postcode.setClearButtonVisible(true);
        postcode.setMinLength(2);
        postcode.setMaxLength(64);
        postcode.setPrefixComponent(MAP_MARKER.create());

        add(id, title, name, username, email, thumbnailPicture, dateOfBirth, dateOfRegistration, company, mobileNumber, country, state, city, streetName, number, postcode);

        buttons = new UserInfoContainerButtons(usersDataProvider, authenticatedUser, userCreationService);
        add(buttons);
    }

    public void setUser(long userId) {
        Optional<DogHubUser> userOptional = usersDataProvider.findById(userId);
        if(userOptional.isPresent()) {
            id.setValue(new BigDecimal(userId));
            DogHubUser user = userOptional.get();
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
    }
}
