package org.hk.doghub.data.content.generator.dog.faker;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class DogApiRandomImageResponse {

    private String message;

    private String status;
}
