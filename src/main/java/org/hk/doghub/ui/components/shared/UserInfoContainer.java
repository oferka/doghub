package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import java.util.Optional;

import static com.vaadin.flow.component.icon.VaadinIcon.MAP_MARKER;
import static com.vaadin.flow.component.icon.VaadinIcon.PHONE;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserInfoContainer extends VerticalLayout {

    public static final String CLASS_NAME = "user-info-container";

    private final UsersDataProvider usersDataProvider;

    private final TextField id;
    private final TextField name;
    private final TextField username;
    private final TextField email;
    private final TextField title;
    private final TextField thumbnailPicture;
    private final TextField dateOfBirth;
    private final TextField dateOfRegistration;
    private final TextField company;
    private final TextField mobileNumber;
    private final TextField country;
    private final TextField state;
    private final TextField city;
    private final TextField streetName;
    private final TextField number;
    private final TextField postcode;

    private final UserInfoContainerButtons buttons;

    public UserInfoContainer(UsersDataProvider usersDataProvider, AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        this.usersDataProvider = usersDataProvider;
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        id = new TextField("ID");
        id.setRequiredIndicatorVisible(true);
        id.setEnabled(false);

        title = new TextField("Title");
        title.setClearButtonVisible(true);
        title.setMinLength(2);
        title.setMaxLength(64);

        name = new TextField("Name");
        name.setRequiredIndicatorVisible(true);
        name.setClearButtonVisible(true);
        name.setMinLength(2);
        name.setMaxLength(128);

        username = new TextField("User Name");
        username.setRequiredIndicatorVisible(true);
        username.setEnabled(false);
        name.setMinLength(5);
        name.setMaxLength(128);

        email = new TextField("Email");
        email.setRequiredIndicatorVisible(true);
        email.setClearButtonVisible(true);
        name.setMinLength(5);
        name.setMaxLength(128);

        thumbnailPicture = new TextField("Avatar URL");
        thumbnailPicture.setClearButtonVisible(true);
        thumbnailPicture.setMinLength(5);
        thumbnailPicture.setMaxLength(256);

        dateOfBirth = new TextField("Date of Birth");
        dateOfBirth.setClearButtonVisible(true);
        dateOfBirth.setMinLength(5);
        dateOfBirth.setMaxLength(128);

        dateOfRegistration = new TextField("Date of Registration");
        dateOfRegistration.setClearButtonVisible(true);
        dateOfRegistration.setEnabled(false);
        dateOfRegistration.setMinLength(5);
        dateOfRegistration.setMaxLength(128);

        company = new TextField("Company");
        company.setClearButtonVisible(true);
        company.setMinLength(2);
        company.setMaxLength(64);

        mobileNumber = new TextField("Mobile Phone");
        mobileNumber.setClearButtonVisible(true);
//        mobileNumber.setPattern("^[+]?[(]?[0-9]{3}[)]?[-s.]?[0-9]{3}[-s.]?[0-9]{4,6}$");
        mobileNumber.setAllowedCharPattern("[0-9()+-]");
        mobileNumber.setPrefixComponent(PHONE.create());

        country = new TextField("Counter");
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

        number = new TextField("Number");
        number.setClearButtonVisible(true);
        number.setMinLength(2);
        number.setMaxLength(64);
        number.setPrefixComponent(MAP_MARKER.create());

        postcode = new TextField("Postcode");
        postcode.setClearButtonVisible(true);
        postcode.setMinLength(2);
        postcode.setMaxLength(64);
        postcode.setPrefixComponent(MAP_MARKER.create());

        add(id, name, username, email, title, thumbnailPicture, dateOfBirth, dateOfRegistration, company, mobileNumber, country, state, city, streetName, number, postcode);

        buttons = new UserInfoContainerButtons(usersDataProvider, authenticatedUser, userCreationService);
        add(buttons);
    }

    public void setUser(long userId) {
        Optional<DogHubUser> userOptional = usersDataProvider.findById(userId);
        if(userOptional.isPresent()) {
            id.setValue(Long.toString(userId));
            DogHubUser user = userOptional.get();
            name.setValue(user.getName());
            username.setValue(user.getUsername());
            email.setValue(user.getEmail());
            title.setValue(user.getTitle());
            thumbnailPicture.setValue(user.getThumbnailPicture());
            dateOfBirth.setValue(user.getDateOfBirth().toString());
            dateOfRegistration.setValue(user.getDateOfRegistration().toString());
            company.setValue(user.getCompany());
            mobileNumber.setValue(user.getMobileNumber());
            country.setValue(user.getAddress().getCountry());
            state.setValue(user.getAddress().getState());
            city.setValue(user.getAddress().getCity());
            streetName.setValue(user.getAddress().getStreetName());
            number.setValue(Integer.toString(user.getAddress().getNumber()));
            postcode.setValue(user.getAddress().getPostcode());
        }
    }
}
