package org.hk.doghub.data.repository.tip;

import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.RandomUtils;
import org.hk.doghub.data.content.provider.tip.DogHubTipProvider;
import org.hk.doghub.data.content.provider.tip.DogHubTipProviderConfiguration;
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
import static org.hk.doghub.model.tip.DogHubTip.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DogHubTipDataTest {

    @Autowired
    protected DogHubTipRepository dogHubTipRepository;

    @Autowired
    protected DogHubTipProvider dogHubTipProvider;

    @Autowired
    protected DogHubTipProviderConfiguration dogHubTipProviderConfiguration;

    protected long tipContentCountBefore;

    @BeforeEach
    void captureContentStatus() {
        tipContentCountBefore = dogHubTipRepository.count();
    }

    @AfterEach
    void verifyContentStatusNotChanged() {
        long contentCountAfter = dogHubTipRepository.count();
        assertEquals(tipContentCountBefore, contentCountAfter);
    }

    protected int getNumberOfItemsToLoad() {
        return dogHubTipProviderConfiguration.getNumberOfItems();
    }

    protected @NotNull Long getNonExistingId() {
        return RandomUtils.nextLong();
    }

    protected @NotNull String getNonExistingTitle() {
        return dogHubTipProvider.get().getTitle();
    }

    protected @NotNull String getNameThatExceedsMaxLength() {
        return randomAlphabetic(NAME_MAX_LENGTH + 1);
    }

    protected @NotNull String getTitleThatExceedsMaxLength() {
        return randomAlphabetic(TITLE_MAX_LENGTH + 1);
    }

    protected @NotNull String getContentThatExceedsMaxLength() {
        return randomAlphabetic(CONTENT_MAX_LENGTH + 1);
    }

    protected @NotNull String getThumbnailPictureThatExceedsMaxLength() {
        return randomAlphabetic(THUMBNAIL_PICTURE_MAX_LENGTH + 1);
    }

    protected @NotNull String getMoreInfoThatExceedsMaxLength() {
        return randomAlphabetic(MORE_INFO_MAX_LENGTH + 1);
    }

    protected @NotNull ZonedDateTime getFutureDateTime() {
        return now().plus(ofDays(10));
    }

    protected @NotNull ZonedDateTime getPastDateTime() {
        return now().minus(ofDays(10));
    }

    protected @NotNull String getThumbnailPictureWithInvalidFormat() {
        return dogHubTipProvider.get().getThumbnailPicture().replace(':', '.');
    }
}
