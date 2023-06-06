package org.hk.doghub.model.user;

import jakarta.persistence.Embeddable;
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

    public static final int CITY_MAX_LENGTH = 64;

    public static final int STATE_MAX_LENGTH = 64;

    public static final int COUNTRY_MAX_LENGTH = 64;

    public static final int STREET_NAME_MAX_LENGTH = 64;

    public static final int POSTCODE_MAX_LENGTH = 64;

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
