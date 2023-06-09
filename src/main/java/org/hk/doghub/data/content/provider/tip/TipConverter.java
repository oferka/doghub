package org.hk.doghub.data.content.provider.tip;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.hk.doghub.data.content.generator.tip.Tip;
import org.hk.doghub.data.content.provider.AbstractConverter;
import org.hk.doghub.data.service.user.DogHubUserService;
import org.hk.doghub.model.DogHubFeedback;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.model.user.DogHubUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipConverter extends AbstractConverter<Tip, DogHubTip> {

    private final ModelMapper modelMapper;

    private final DogHubUserService dogHubUserService;

    private final UrlFaviconProvider urlFaviconProvider;

    public DogHubTip convert(@NotNull Tip tip) {
        DogHubTip dogHubTip = modelMapper.map(tip, DogHubTip.class);
        dogHubTip.setThumbnailPicture(urlFaviconProvider.get(tip));
        dogHubTip.setFeedback(getFeedback());
        dogHubTip.setCreationTime(getCreationTime());
        dogHubTip.setName(getName(tip));
        Optional<DogHubUser> createdByOptional = getCreatedBy();
        createdByOptional.ifPresent(dogHubTip::setCreatedBy);
        return dogHubTip;
    }

    private @NotNull DogHubFeedback getFeedback() {
        DogHubFeedback result = new DogHubFeedback();
        result.setLikes(getLikes());
        result.setShares(getShares());
        result.setComments(getComments());
        return result;
    }

    private long getLikes() {
        return RandomUtils.nextLong(0, 10000);
    }

    private long getShares() {
        return RandomUtils.nextLong(0, 10000);
    }

    private long getComments() {
        return RandomUtils.nextLong(0, 10000);
    }

    private @NotNull ZonedDateTime getCreationTime() {
        return ZonedDateTime.now().minus(RandomUtils.nextInt(1, 3*365*24*60), ChronoUnit.MINUTES);
    }

    private @NotNull String getName(@NotNull Tip tip) {
        return tip.getTitle();
    }

    private @NotNull Optional<DogHubUser> getCreatedBy() {
        return dogHubUserService.findRandom();
    }
}
