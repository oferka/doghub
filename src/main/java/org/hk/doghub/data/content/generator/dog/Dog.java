package org.hk.doghub.data.content.generator.dog;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hk.doghub.data.content.generator.ProvidedObject;

@Getter
@Setter
@ToString
public class Dog extends ProvidedObject {

    public static final int NAME_MAX_LENGTH = 64;
    public static final int BREED_MAX_LENGTH = 64;
    public static final int SOUND_MAX_LENGTH = 64;
    public static final int AGE_MAX_LENGTH = 32;
    public static final int COAT_LENGTH_MAX_LENGTH = 32;
    public static final int SIZE_MAX_LENGTH = 32;
    public static final int GENDER_MAX_LENGTH = 32;

    @NotNull
    @NotBlank
    @Size(max = NAME_MAX_LENGTH)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = BREED_MAX_LENGTH)
    private String breed;

    @NotNull
    @NotBlank
    @Size(max = SOUND_MAX_LENGTH)
    private String sound;

    @NotNull
    @NotBlank
    @Size(max = AGE_MAX_LENGTH)
    private String age;

    @NotNull
    @NotBlank
    @Size(max = COAT_LENGTH_MAX_LENGTH)
    private String coatLength;

    @NotNull
    @NotBlank
    @Size(max = SIZE_MAX_LENGTH)
    private String size;

    @NotNull
    @NotBlank
    @Size(max = GENDER_MAX_LENGTH)
    private String gender;
}
