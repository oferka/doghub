package org.hk.doghub.data.content.generator.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {

    public static final int STREET_NAME_MAX_LENGTH = 64;
    public static final int CITY_MAX_LENGTH = 64;
    public static final int STATE_NAME_MAX_LENGTH = 64;
    public static final int COUNTRY_NAME_MAX_LENGTH = 64;
    public static final int POSTCODE_MAX_LENGTH = 64;

    @Positive
    private int number;

    @NotNull @NotBlank @Size(max = STREET_NAME_MAX_LENGTH)
    private String streetName;

    @NotNull @NotBlank @Size(max = CITY_MAX_LENGTH)
    private String city;

    @NotNull @NotBlank @Size(max = STATE_NAME_MAX_LENGTH)
    private String state;

    @NotNull @NotBlank @Size(max = COUNTRY_NAME_MAX_LENGTH)
    private String country;

    @NotNull @NotBlank @Size(max = POSTCODE_MAX_LENGTH)
    private String postcode;
}
