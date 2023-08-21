package org.hk.doghub.data.repository.dog;

import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.RandomUtils;
import org.hk.doghub.data.content.provider.dog.DogHubDogProvider;
import org.hk.doghub.data.content.provider.dog.DogHubDogProviderConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

import static java.time.Duration.ofDays;
import static java.time.ZonedDateTime.now;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hk.doghub.model.HasThumbnailPicture.THUMBNAIL_PICTURE_MAX_LENGTH;
import static org.hk.doghub.model.NamedEntity.NAME_MAX_LENGTH;
import static org.hk.doghub.model.dog.DogHubDog.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DogHubDogDataTest {

    @Autowired
    protected DogHubDogRepository dogHubDogRepository;

    @Autowired
    protected DogHubDogProvider dogHubDogProvider;

    @Autowired
    protected DogHubDogProviderConfiguration dogHubDogProviderConfiguration;

    protected long tipContentCountBefore;

    @BeforeEach
    void captureContentStatus() {
        tipContentCountBefore = dogHubDogRepository.count();
    }

    @AfterEach
    void verifyContentStatusNotChanged() {
        long contentCountAfter = dogHubDogRepository.count();
        assertEquals(tipContentCountBefore, contentCountAfter);
    }

    protected int getNumberOfItemsToLoad() {
        return dogHubDogProviderConfiguration.getNumberOfItems();
    }

    protected @NotNull Long getNonExistingId() {
        return RandomUtils.nextLong();
    }

    protected @NotNull String getNonExistingName() {
        return dogHubDogProvider.get().getName();
    }

    protected @NotNull String getNonExistingBreed() {
        return dogHubDogProvider.get().getBreed();
    }

    protected @NotNull String getNonExistingSound() {
        return dogHubDogProvider.get().getSound();
    }

    protected @NotNull String getNonExistingAge() {
        return dogHubDogProvider.get().getAge();
    }

    protected @NotNull String getNonExistingCoatLength() {
        return dogHubDogProvider.get().getCoatLength();
    }

    protected @NotNull String getNonExistingSize() {
        return dogHubDogProvider.get().getSize();
    }

    protected @NotNull String getNonExistingGender() {
        return dogHubDogProvider.get().getGender();
    }

    protected @NotNull String getNameThatExceedsMaxLength() {
        return randomAlphabetic(NAME_MAX_LENGTH + 1);
    }

    protected @NotNull String getBreedThatExceedsMaxLength() {
        return randomAlphabetic(BREED_MAX_LENGTH + 1);
    }

    protected @NotNull String getSoundThatExceedsMaxLength() {
        return randomAlphabetic(SOUND_MAX_LENGTH + 1);
    }

    protected @NotNull String getAgeThatExceedsMaxLength() {
        return randomAlphabetic(AGE_MAX_LENGTH + 1);
    }

    protected @NotNull String getCoatLengthThatExceedsMaxLength() {
        return randomAlphabetic(COAT_LENGTH_MAX_LENGTH + 1);
    }

    protected @NotNull String getSizeThatExceedsMaxLength() {
        return randomAlphabetic(SIZE_MAX_LENGTH + 1);
    }

    protected @NotNull String getGenderThatExceedsMaxLength() {
        return randomAlphabetic(GENDER_MAX_LENGTH + 1);
    }

    protected @NotNull String getThumbnailPictureThatExceedsMaxLength() {
        return randomAlphabetic(THUMBNAIL_PICTURE_MAX_LENGTH + 1);
    }

    protected @NotNull ZonedDateTime getFutureDateTime() {
        return now().plus(ofDays(10));
    }

    protected @NotNull ZonedDateTime getPastDateTime() {
        return now().minus(ofDays(10));
    }

    protected @NotNull String getThumbnailPictureWithInvalidFormat() {
        return dogHubDogProvider.get().getThumbnailPicture().replace(':', '.');
    }
}
