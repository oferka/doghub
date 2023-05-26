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

    public UserInfoContainer(UsersDataProvider usersDataProvider, AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        this.usersDataProvider = usersDataProvider;
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        id = new Label();
        add(id);

        name = new Label();
        add(name);

        username = new Label();
        add(username);

        email = new Label();
        add(email);

        title = new Label();
        add(title);

        thumbnailPicture = new Label();
        add(thumbnailPicture);
    }

    public void setUser(long userId) {
        Optional<DogHubUser> userOptional = usersDataProvider.findById(userId);
        if(userOptional.isPresent()) {
            id.setText("Id: " + userId);
            DogHubUser user = userOptional.get();
            name.setText("Name: " + user.getName());
            username.setText("Username: " + user.getUsername());
            email.setText("Email: " + user.getEmail());
            email.setText("Title: " + user.getTitle());
            thumbnailPicture.setText("Thumbnail Picture: " + user.getThumbnailPicture());
        }
    }
}
