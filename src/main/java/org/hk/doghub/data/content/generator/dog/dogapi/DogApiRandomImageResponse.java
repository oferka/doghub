package org.hk.doghub.data.content.generator.dog.dogapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class DogApiRandomImageResponse {

    private String message;

    private String status;
}
