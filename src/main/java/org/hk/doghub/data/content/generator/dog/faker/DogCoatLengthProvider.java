package org.hk.doghub.data.content.generator.dog.faker;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import net.datafaker.Faker;
import org.hk.doghub.data.content.generator.dog.Dog;
import org.springframework.stereotype.Service;

import static org.hk.doghub.data.content.generator.dog.Dog.COAT_LENGTH_MAX_LENGTH;

@Service
public class DogCoatLengthProvider {

    public @NotNull @NotBlank @Size(max = COAT_LENGTH_MAX_LENGTH) String get(@NotNull Dog dog) {
        return new Faker().dog().coatLength();
    }
}
