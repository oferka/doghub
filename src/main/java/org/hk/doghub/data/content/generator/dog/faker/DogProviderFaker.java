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

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Slf4j
@RequiredArgsConstructor
@Validated
public class DogProviderFaker implements DogProvider {

    private final DogNameProvider nameProvider;

    private final DogThumbnailPictureProvider thumbnailPictureProvider;

    private final DogBreedProvider breedProvider;

    private final DogSoundProvider soundProvider;

    private final DogAgeProvider ageProvider;

    private final DogCoatLengthProvider coatLengthProvider;

    private final DogSizeProvider sizeProvider;

    private final DogGenderProvider genderProvider;

    @Override
    public @NotNull List<Dog> get(@Min(MIN_NUMBER_OF_ITEMS) @Max(MAX_NUMBER_OF_ITEMS) int numberOfItems) {
        return IntStream.range(0, numberOfItems).mapToObj(x -> get()).collect(Collectors.toList());
    }

    @Override
    public @NotNull Dog get() {
        Dog result = new Dog();
        result.setName(nameProvider.get(result));
        result.setThumbnailPicture(thumbnailPictureProvider.get(result));
        result.setBreed(breedProvider.get(result));
        result.setSound(soundProvider.get(result));
        result.setAge(ageProvider.get(result));
        result.setCoatLength(coatLengthProvider.get(result));
        result.setSize(sizeProvider.get(result));
        result.setGender(genderProvider.get(result));
        return result;
    }
}
