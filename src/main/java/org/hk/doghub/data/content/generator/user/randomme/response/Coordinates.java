package org.hk.doghub.data.content.generator.user.randomme.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Coordinates {

    private String latitude;

    private String longitude;
}
