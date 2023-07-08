package org.hk.doghub.data.repository.user;

import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.RandomUtils;
import org.hk.doghub.data.content.provider.user.DogHubUserProvider;
import org.hk.doghub.data.content.provider.user.DogHubUserProviderConfiguration;
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
import static org.hk.doghub.model.user.DogHubAddress.*;
import static org.hk.doghub.model.user.DogHubUser.*;
import static org.hk.doghub.model.user.DogHubUser.MOBILE_NUMBER_MAX_LENGTH;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DogHubUserDataTest {

    @Autowired
    protected DogHubUserRepository dogHubUserRepository;

    @Autowired
    protected DogHubUserProvider dogHubUserProvider;

    @Autowired
    protected DogHubUserProviderConfiguration dogHubUserProviderConfiguration;

    protected long userContentCountBefore;

    @BeforeEach
    void captureContentStatus() {
        userContentCountBefore = dogHubUserRepository.count();
    }

    @AfterEach
    void verifyContentStatusNotChanged() {
        long contentCountAfter = dogHubUserRepository.count();
        assertEquals(userContentCountBefore, contentCountAfter);
    }

    protected int getNumberOfItemsToLoad() {
        return dogHubUserProviderConfiguration.getNumberOfItems();
    }

    protected @NotNull Long getNonExistingId() {
        return RandomUtils.nextLong();
    }

    protected @NotNull String getNonExistingUsername() {
        return dogHubUserProvider.get().getUsername();
    }

    protected @NotNull String getNameThatExceedsMaxLength() {
        return randomAlphabetic(NAME_MAX_LENGTH + 1);
    }

    protected @NotNull String getUsernameThatExceedsMaxLength() {
        return randomAlphabetic(USER_NAME_MAX_LENGTH + 1);
    }

    protected @NotNull String getEmailThatExceedsMaxLength() {
        return randomAlphabetic(EMAIL_MAX_LENGTH + 1);
    }

    protected @NotNull String getTitleThatExceedsMaxLength() {
        return randomAlphabetic(TITLE_MAX_LENGTH + 1);
    }

    protected @NotNull String getThumbnailPictureThatExceedsMaxLength() {
        return randomAlphabetic(THUMBNAIL_PICTURE_MAX_LENGTH + 1);
    }

    protected @NotNull String getCompanyThatExceedsMaxLength() {
        return randomAlphabetic(COMPANY_MAX_LENGTH + 1);
    }

    protected @NotNull String getCountryThatExceedsMaxLength() {
        return randomAlphabetic(COUNTRY_MAX_LENGTH + 1);
    }

    protected @NotNull String getStateThatExceedsMaxLength() {
        return randomAlphabetic(STATE_MAX_LENGTH + 1);
    }

    protected @NotNull String getCityThatExceedsMaxLength() {
        return randomAlphabetic(CITY_MAX_LENGTH + 1);
    }

    protected @NotNull String getStreetNameThatExceedsMaxLength() {
        return randomAlphabetic(STREET_NAME_MAX_LENGTH + 1);
    }

    protected @NotNull String getPostcodeThatExceedsMaxLength() {
        return randomAlphabetic(POSTCODE_MAX_LENGTH + 1);
    }

    protected @NotNull String getHashedPasswordThatExceedsMaxLength() {
        return randomAlphabetic(PASSWORD_MAX_LENGTH + 1);
    }

    protected @NotNull String getMobileNumberThatExceedsMaxLength() {
        return randomAlphabetic(MOBILE_NUMBER_MAX_LENGTH + 1);
    }

    protected @NotNull ZonedDateTime getFutureDateTime() {
        return now().plus(ofDays(10));
    }

    protected @NotNull ZonedDateTime getPastDateTime() {
        return now().minus(ofDays(10));
    }

    protected @NotNull String getEmailWithInvalidFormat() {
        return dogHubUserProvider.get().getEmail().replace('@', '.');
    }

    protected @NotNull String getThumbnailPictureWithInvalidFormat() {
        return dogHubUserProvider.get().getThumbnailPicture().replace(':', '.');
    }
}
