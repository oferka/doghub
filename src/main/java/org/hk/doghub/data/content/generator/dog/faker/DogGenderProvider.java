package org.hk.doghub.data.content.generator.dog.faker;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import net.datafaker.Faker;
import org.hk.doghub.data.content.generator.dog.Dog;
import org.springframework.stereotype.Service;

import static org.hk.doghub.data.content.generator.dog.Dog.GENDER_MAX_LENGTH;

@Service
public class DogGenderProvider {

    public @NotNull @NotBlank @Size(max = GENDER_MAX_LENGTH) String get(@NotNull Dog dog) {
        Faker faker = new Faker();
        return faker.dog().gender();
    }
}
