package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import java.util.Optional;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserInfoContainer extends VerticalLayout {

    public static final String CLASS_NAME = "user-info-container";

    private final UsersDataProvider usersDataProvider;

    private final Label id;
    private final Label name;
    private final Label username;
    private final Label email;
    private final Label title;
    private final Label thumbnailPicture;
    private final Label dateOfBirth;
    private final Label dateOfRegistration;
    private final Label company;
    private final Label mobileNumber;
    private final Label country;
    private final Label state;
    private final Label city;
    private final Label streetName;
    private final Label number;
    private final Label postcode;

    private final UserInfoContainerButtons buttons;

    public UserInfoContainer(UsersDataProvider usersDataProvider, AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        this.usersDataProvider = usersDataProvider;
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        id = new Label();
        name = new Label();
        username = new Label();
        email = new Label();
        title = new Label();
        thumbnailPicture = new Label();
        dateOfBirth = new Label();
        dateOfRegistration = new Label();
        company = new Label();
        mobileNumber = new Label();
        country = new Label();
        state = new Label();
        city = new Label();
        streetName = new Label();
        number = new Label();
        postcode = new Label();
        add(id, name, username, email, title, thumbnailPicture, dateOfBirth, dateOfRegistration, company, mobileNumber, country, state, city, streetName, number, postcode);

        buttons = new UserInfoContainerButtons(usersDataProvider, authenticatedUser, userCreationService);
        add(buttons);
    }

    public void setUser(long userId) {
        Optional<DogHubUser> userOptional = usersDataProvider.findById(userId);
        if(userOptional.isPresent()) {
            id.setText("Id: " + userId);
            DogHubUser user = userOptional.get();
            name.setText("Name: " + user.getName());
            username.setText("Username: " + user.getUsername());
            email.setText("Email: " + user.getEmail());
            title.setText("Title: " + user.getTitle());
            thumbnailPicture.setText("Thumbnail Picture: " + user.getThumbnailPicture());
            dateOfBirth.setText("Date Of Birth: " + user.getDateOfBirth());
            dateOfRegistration.setText("Date Of Registration: " + user.getDateOfRegistration());
            company.setText("Company: " + user.getCompany());
            mobileNumber.setText("Mobile Number: " + user.getMobileNumber());
            country.setText("Country: " + user.getAddress().getCountry());
            state.setText("State: " + user.getAddress().getState());
            city.setText("City: " + user.getAddress().getCity());
            streetName.setText("Street Name: " + user.getAddress().getStreetName());
            number.setText("Number: " + user.getAddress().getNumber());
            postcode.setText("Postcode: " + user.getAddress().getPostcode());
        }
    }
}
