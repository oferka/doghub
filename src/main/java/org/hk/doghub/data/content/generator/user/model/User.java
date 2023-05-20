package org.hk.doghub.data.content.generator.user.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;

import java.time.ZonedDateTime;

import static java.lang.String.format;

@Getter
@Setter
@ToString
public class User {

    @NotNull
    @Size(min = 2, max = 64)
    @NotBlank
    private String firstName;

    @NotNull
    @Size(min = 2, max = 64)
    @NotBlank
    private String lastName;

    @Email
    private String email;

    @NotNull
    @Size(min = 2, max = 64)
    @NotBlank
    private String title;

    @NotNull
    @Size(min = 2, max = 64)
    @NotBlank
    private String password;

    @NotNull
    @URL
    private String thumbnailPicture;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @NotNull
    @Past
    private ZonedDateTime dateOfBirth;

    @NotNull
    @Size(min = 2, max = 64)
    @NotBlank
    private String company;

    @NotNull
    private Address address;

    @NotNull
    @Size(min = 2, max = 64)
    @NotBlank
    private String mobileNumber;

    public @NotNull @NotBlank @Size(min = 4, max = 128) String getName() {
        return format("%s %s", firstName, lastName);
    }
}
