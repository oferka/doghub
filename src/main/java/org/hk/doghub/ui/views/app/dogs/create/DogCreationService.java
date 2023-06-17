package org.hk.doghub.ui.views.app.dogs.create;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.service.dog.DogHubDogService;
import org.hk.doghub.model.DogHubFeedback;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EntityCreationService;
import org.hk.doghub.ui.components.shared.dog.DogCreationParameters;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

import static org.hk.doghub.model.NamedEntity.NAME_MAX_LENGTH;

@Slf4j
@Service
@RequiredArgsConstructor
public class DogCreationService implements EntityCreationService<DogHubDog, DogCreationParameters> {

    private final DogHubDogService dogService;

    @Override
    public @NotNull DogHubDog create(@NotNull DogCreationParameters creationParameters) {
        return create(creationParameters.getName(), creationParameters.getCreatedBy());
    }

    @Override
    public boolean exists(@NotNull DogCreationParameters creationParameters) {
        return exists(creationParameters.getName(), creationParameters.getCreatedBy());
    }

    private DogHubDog create(@NotNull @Size(max = NAME_MAX_LENGTH) String name, @NotNull DogHubUser createdBy) {
        return dogService.save(getTipEntity(name, createdBy));
    }

    private @NotNull DogHubDog getTipEntity(@NotNull @Size(max = NAME_MAX_LENGTH) String name, @NotNull DogHubUser createdBy) {
        DogHubDog result = new DogHubDog();
        result.setName(name);
        result.setCreationTime(ZonedDateTime.now());
        result.setCreatedBy(createdBy);
        result.setFeedback(new DogHubFeedback());
        return result;
    }

    private boolean exists(@NotNull @Size(max = NAME_MAX_LENGTH) String name, @NotNull DogHubUser createdBy) {
        return dogService.existsByNameAndCreatedBy(name, createdBy);
    }
}
