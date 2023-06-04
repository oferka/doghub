package org.hk.doghub.model.user;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
public class DogHubAddress {

    public static final int CITY_MIN_LENGTH = 2;
    public static final int CITY_MAX_LENGTH = 64;

    public static final int STATE_MIN_LENGTH = 2;
    public static final int STATE_MAX_LENGTH = 64;

    public static final int COUNTRY_MIN_LENGTH = 2;
    public static final int COUNTRY_MAX_LENGTH = 64;

    public static final int STREET_NAME_MIN_LENGTH = 2;
    public static final int STREET_NAME_MAX_LENGTH = 64;

    public static final int POSTCODE_MIN_LENGTH = 2;
    public static final int POSTCODE_MAX_LENGTH = 64;

    @Positive
    private Integer number = 0;

    @NotNull
    @Size(min = STREET_NAME_MIN_LENGTH, max = STREET_NAME_MAX_LENGTH)
    @NotBlank
    private String streetName;

    @NotNull
    @Size(min = CITY_MIN_LENGTH, max = CITY_MAX_LENGTH)
    @NotBlank
    private String city;

    @NotNull
    @Size(min = STATE_MIN_LENGTH, max = STATE_MAX_LENGTH)
    @NotBlank
    private String state;

    @NotNull
    @Size(min = COUNTRY_MIN_LENGTH, max = COUNTRY_MAX_LENGTH)
    @NotBlank
    private String country;

    @NotNull
    @Size(min = POSTCODE_MIN_LENGTH, max = POSTCODE_MAX_LENGTH)
    @NotBlank
    private String postcode;
}
