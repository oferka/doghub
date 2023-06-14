package org.hk.doghub.data.content.generator.user.randomme.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Timezone {

    private String offset;

    private String description;
}
