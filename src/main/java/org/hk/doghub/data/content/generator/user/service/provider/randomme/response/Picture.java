package org.hk.doghub.data.content.generator.user.service.provider.randomme.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Picture {

    private String large;

    private String medium;

    private String thumbnail;
}
