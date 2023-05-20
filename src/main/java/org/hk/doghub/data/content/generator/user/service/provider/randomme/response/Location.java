package org.hk.doghub.data.content.generator.user.service.provider.randomme.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Location {

    private Street street;

    private String city;

    private String state;

    private String country;

    private String postcode;

    private Coordinates coordinates;

    private Timezone timezone;
}
