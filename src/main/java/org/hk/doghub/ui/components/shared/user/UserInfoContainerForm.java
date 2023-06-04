package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_TERTIARY_INLINE;
import static com.vaadin.flow.component.icon.VaadinIcon.*;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static com.vaadin.flow.component.notification.NotificationVariant.LUMO_ERROR;
import static com.vaadin.flow.component.notification.NotificationVariant.LUMO_SUCCESS;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static org.hk.doghub.ui.components.shared.user.UserEmailField.LABEL;


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
                showSavedSuccessfullyNotification();
            }
            catch (Exception e) {
                log.error("Unexpected exception was thrown", e);
                showSaveFailedWithUnexpectedErrorNotification();
            }
        }
        else {
            showSaveFailedWithInvalidInput(violations);
        }
        log.info("Save for user with ID '{}' has completed", id.getValue());
    }

    private void showSavedSuccessfullyNotification() {
        Notification notification = new Notification();
        notification.addThemeVariants(LUMO_SUCCESS);

        Icon icon = CHECK_CIRCLE.create();
        Div info = new Div(new Text("User saved successfully!"));
        Button viewBtn = new Button("View", clickEvent -> notification.close());
        viewBtn.getStyle().set("margin", "0 0 0 var(--lumo-space-l)");
        HorizontalLayout layout = new HorizontalLayout(icon, info, viewBtn, createCloseBtn(notification));
        layout.setAlignItems(CENTER);

        notification.add(layout);
        notification.setPosition(MIDDLE);
        notification.setDuration(5000);
        notification.open();
    }

    private void showSaveFailedWithUnexpectedErrorNotification() {
        Notification notification = new Notification();
        notification.addThemeVariants(LUMO_ERROR);

        Icon icon = WARNING.create();
        Div info = new Div(new Text("Failed to save user!"));
        Button retryBtn = new Button("Retry", clickEvent -> {
            notification.close();
            save();
        });
        retryBtn.getStyle().set("margin", "0 0 0 var(--lumo-space-l)");
        HorizontalLayout layout = new HorizontalLayout(icon, info, retryBtn, createCloseBtn(notification));
        layout.setAlignItems(CENTER);

        notification.add(layout);
        notification.setPosition(MIDDLE);
        notification.setDuration(5000);
        notification.open();
    }

    private void showSaveFailedWithInvalidInput(List<String> violations) {
        Notification notification = new Notification();
        notification.addThemeVariants(LUMO_ERROR);

        Icon icon = WARNING.create();
        VerticalLayout info = new VerticalLayout();
        Div infoHeader = new Div(new Text("Failed to save user!"));
        info.add(infoHeader);
        for(String violation : violations) {
            info.add(new Div(new Text(violation)));
        }
        HorizontalLayout layout = new HorizontalLayout(icon, info, createCloseBtn(notification));
        layout.setAlignItems(CENTER);

        notification.add(layout);
        notification.setPosition(MIDDLE);
        notification.setDuration(10000);
        notification.open();
    }

    private Button createCloseBtn(Notification notification) {
        Button closeBtn = new Button(CLOSE_SMALL.create(), clickEvent -> notification.close());
        closeBtn.addThemeVariants(LUMO_TERTIARY_INLINE);
        return closeBtn;
    }

    private List<String> validateInput() {
        List<String> violations = new ArrayList<>();
        violations.addAll(id.validateField());
        violations.addAll(username.validateField());
        violations.addAll(title.validateField());
        violations.addAll(name.validateField());
        violations.addAll(mobileNumber.validateField());
        violations.addAll(email.validateUserField());
        violations.addAll(thumbnailPicture.validateField());
        violations.addAll(company.validateField());
        violations.addAll(dateOfBirth.validateUserField());
        violations.addAll(dateOfRegistration.validateUserField());
        violations.addAll(country.validateField());
        violations.addAll(state.validateUserField());
        violations.addAll(city.validateField());
        violations.addAll(streetName.validateField());
        violations.addAll(streetNumber.validateUserField());
        violations.addAll(postcode.validateField());
        return violations;
    }

    public void cancel() {
        Optional<DogHubUser> userOptional = usersDataProvider.findById(id.getValue().longValue());
        userOptional.ifPresent(this::setUser);
    }
}
