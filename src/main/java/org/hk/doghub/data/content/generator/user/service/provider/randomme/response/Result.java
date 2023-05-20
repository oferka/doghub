package org.hk.doghub.data.content.generator.user.service.provider.randomme.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Result {

    private String gender;

    private Name name;

    private Location location;

    private String email;

    private Login login;

    private DateOfBirth dob;

    private DateOfRegistration registered;

    private String phone;

    private String cell;

    private Id id;

    private Picture picture;

    private String nat;
}
