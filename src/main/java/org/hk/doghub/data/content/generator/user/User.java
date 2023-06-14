package org.hk.doghub.data.content.generator.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;
import org.hk.doghub.data.content.generator.ProvidedObject;

import java.time.ZonedDateTime;

import static java.lang.String.format;

@Getter
@Setter
@ToString
public class User extends ProvidedObject {

    public static final int FIRST_NAME_MAX_LENGTH = 64;
    public static final int LAST_NAME_MAX_LENGTH = 64;
    public static final int EMAIL_MAX_LENGTH = 128;
    public static final int TITLE_MAX_LENGTH = 64;
    public static final int PASSWORD_MAX_LENGTH = 128;
    public static final int COMPANY_MAX_LENGTH = 64;
    public static final int MOBILE_NUMBER_MAX_LENGTH = 64;

    @NotNull @NotBlank @Size(max = FIRST_NAME_MAX_LENGTH)
    private String firstName;

    @NotNull @NotBlank @Size(max = LAST_NAME_MAX_LENGTH)
    private String lastName;

    @Email @NotBlank @Size(max = EMAIL_MAX_LENGTH)
    private String email;

    @NotNull @NotBlank @Size(max = TITLE_MAX_LENGTH)
    private String title;

    @NotNull @NotBlank @Size(max = PASSWORD_MAX_LENGTH)
    private String password;

    @NotNull @URL
    private String thumbnailPicture;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @NotNull @Past
    private ZonedDateTime dateOfBirth;

    @NotNull @NotBlank @Size(max = COMPANY_MAX_LENGTH)
    private String company;

    @NotNull
    private Address address;

    @NotNull @NotBlank @Size(max = MOBILE_NUMBER_MAX_LENGTH)
    private String mobileNumber;

    public @NotNull @NotBlank @Size(max = FIRST_NAME_MAX_LENGTH + LAST_NAME_MAX_LENGTH + 1) String getName() {
        return format("%s %s", firstName, lastName);
    }
}
