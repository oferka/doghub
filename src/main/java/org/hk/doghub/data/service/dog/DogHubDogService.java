package org.hk.doghub.data.service.dog;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.repository.EntityRepository;
import org.hk.doghub.data.repository.dog.DogHubDogRepository;
import org.hk.doghub.data.service.AbstractEntityService;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DogHubDogService extends AbstractEntityService<DogHubDog> {

    private final DogHubDogRepository repository;

    @Override
    protected EntityRepository<DogHubDog> getEntityRepository() {
        return repository;
    }

    @Override
    public boolean exists(@NotNull DogHubDog entity) {
        return existsByIdAndCreatedBy(entity.getId(), entity.getCreatedBy());
    }

    public Optional<DogHubDog> findPrevious(@NotNull Long id) {
        return repository.findTop1ByIdLessThanOrderByIdDesc(id);
    }

    public Optional<DogHubDog> findNext(@NotNull Long id) {
        return repository.findTop1ByIdGreaterThanOrderById(id);
    }

    public List<DogHubDog> findByCreatedBy(@NotNull DogHubUser user) {
        return repository.findByCreatedBy(user);
    }

    public long countByCreatedBy(@NotNull DogHubUser user) {
        return repository.countByCreatedBy(user);
    }

    public boolean existsByIdAndCreatedBy(@NotNull Long id, @NotNull DogHubUser user) {
        return repository.existsByIdAndCreatedBy(id, user);
    }

    public boolean existsByNameAndCreatedBy(@NotNull String name, @NotNull DogHubUser user) {
        return repository.existsByNameAndCreatedBy(name, user);
    }

    public Optional<DogHubDog> findPreviousByCreatedBy(@NotNull Long id, @NotNull DogHubUser user) {
        return repository.findTop1ByIdLessThanAndCreatedByOrderByIdDesc(id, user);
    }

    public Optional<DogHubDog> findNextByCreatedBy(@NotNull Long id, @NotNull DogHubUser user) {
        return repository.findTop1ByIdGreaterThanAndCreatedByOrderById(id, user);
    }
}
