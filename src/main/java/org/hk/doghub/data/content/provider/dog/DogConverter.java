package org.hk.doghub.data.content.provider.dog;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.hk.doghub.data.content.generator.dog.Dog;
import org.hk.doghub.data.content.provider.AbstractConverter;
import org.hk.doghub.data.service.user.DogHubUserService;
import org.hk.doghub.model.DogHubFeedback;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.model.user.DogHubUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DogConverter extends AbstractConverter<Dog, DogHubDog> {

    private final ModelMapper modelMapper;

    private final DogHubUserService dogHubUserService;

    public DogHubDog convert(@NotNull Dog dog) {
        DogHubDog dogHubDog = modelMapper.map(dog, DogHubDog.class);
        dogHubDog.setFeedback(getFeedback());
        dogHubDog.setCreationTime(getCreationTime());
        Optional<DogHubUser> createdByOptional = getCreatedBy();
        createdByOptional.ifPresent(dogHubDog::setCreatedBy);
        return dogHubDog;
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

    private @NotNull Optional<DogHubUser> getCreatedBy() {
        return dogHubUserService.findRandom();
    }
}
