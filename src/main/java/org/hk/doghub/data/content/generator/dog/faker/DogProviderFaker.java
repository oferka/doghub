package org.hk.doghub.data.content.generator.dog.faker;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.dog.Dog;
import org.hk.doghub.data.content.generator.dog.DogProvider;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Validated
public class DogProviderFaker implements DogProvider {

    private final DogNameProvider nameProvider;
    private final DogBreedProvider breedProvider;
    private final DogSoundProvider soundProvider;
    private final DogAgeProvider ageProvider;
    private final DogCoatLengthProvider coatLengthProvider;
    private final DogSizeProvider sizeProvider;
    private final DogGenderProvider genderProvider;

    @Override
    public @NotNull List<Dog> get(@Min(MIN_NUMBER_OF_ITEMS) @Max(MAX_NUMBER_OF_ITEMS) int numberOfItems) {
        List<Dog> result = new ArrayList<>();
        for(int i = 0; i< numberOfItems; i++) {
            result.add(get());
        }
        return result;
    }

    @Override
    public @NotNull Dog get() {
        Dog result = new Dog();
        result.setName(nameProvider.get(result));
        result.setBreed(breedProvider.get(result));
        result.setSound(soundProvider.get(result));
        result.setAge(ageProvider.get(result));
        result.setCoatLength(coatLengthProvider.get(result));
        result.setSize(sizeProvider.get(result));
        result.setGender(genderProvider.get(result));
        return result;
    }
}
