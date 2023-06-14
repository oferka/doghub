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

    @Positive
    private int number;

    @NotNull
    @Size(min = 2, max = 64)
    @NotBlank
    private String streetName;

    @NotNull
    @Size(min = 2, max = 64)
    @NotBlank
    private String city;

    @NotNull
    @Size(min = 2, max = 64)
    @NotBlank
    private String state;

    @NotNull
    @Size(min = 2, max = 64)
    @NotBlank
    private String country;

    @NotNull
    @Size(min = 2, max = 64)
    @NotBlank
    private String postcode;
}
