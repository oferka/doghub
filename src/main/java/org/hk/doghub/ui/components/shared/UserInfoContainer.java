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
    private final TextField country;
    private final TextField state;
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
        title.setValue(titleValues.get(0));
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

        country = new TextField("Country");
        company.setClearButtonVisible(true);
        country.setMinLength(2);
        country.setMaxLength(64);
        country.setPrefixComponent(MAP_MARKER.create());

        state = new TextField("State");
        state.setClearButtonVisible(true);
        state.setMinLength(2);
        state.setMaxLength(64);
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
            email.setValue(user.getEmail());
            title.setValue(user.getTitle());
            thumbnailPicture.setValue(user.getThumbnailPicture());
            dateOfBirth.setValue(user.getDateOfBirth().toLocalDateTime());
            dateOfRegistration.setValue(user.getDateOfRegistration().toLocalDateTime());
            company.setValue(user.getCompany());
            mobileNumber.setValue(user.getMobileNumber());
            country.setValue(user.getAddress().getCountry());
            state.setValue(user.getAddress().getState());
            city.setValue(user.getAddress().getCity());
            streetName.setValue(user.getAddress().getStreetName());
            number.setValue(user.getAddress().getNumber());
            postcode.setValue(user.getAddress().getPostcode());
        }
    }
}
