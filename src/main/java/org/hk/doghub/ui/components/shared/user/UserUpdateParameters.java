package org.hk.doghub.ui.components.shared.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.hk.doghub.ui.components.shared.EntityUpdateParameters;

import java.time.ZonedDateTime;

import static org.hk.doghub.model.user.DogHubAddress.*;
import static org.hk.doghub.model.user.DogHubUser.*;

@Getter
@Setter
public class UserUpdateParameters extends EntityUpdateParameters {

    @Size(max = TITLE_MAX_LENGTH)
    private String title;

    @Size(max = MOBILE_NUMBER_MAX_LENGTH)
    private String mobileNumber;

    @Size(max = EMAIL_MAX_LENGTH) @Email
    private String email;

    @Size(max = THUMBNAIL_PICTURE_MAX_LENGTH) @URL
    private String thumbnailPicture;

    @Size(max = COMPANY_MAX_LENGTH)
    private String company;

    @Past
    private ZonedDateTime dateOfBirth;

    @Positive
    private Integer number = 0;

    @Size(max = STREET_NAME_MAX_LENGTH)
    private String streetName;

    @Size(max = CITY_MAX_LENGTH)
    private String city;

    @Size(max = STATE_MAX_LENGTH)
    private String state;

    @Size(max = COUNTRY_MAX_LENGTH)
    private String country;

    @Size(max = POSTCODE_MAX_LENGTH)
    private String postcode;
}
