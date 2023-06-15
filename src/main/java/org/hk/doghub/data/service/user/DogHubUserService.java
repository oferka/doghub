package org.hk.doghub.data.service.user;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.hk.doghub.data.repository.EntityRepository;
import org.hk.doghub.data.repository.user.DogHubUserRepository;
import org.hk.doghub.data.service.AbstractEntityService;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DogHubUserService extends AbstractEntityService<DogHubUser> {

    private final DogHubUserRepository repository;

    @Override
    protected EntityRepository<DogHubUser> getEntityRepository() {
        return repository;
    }

    public boolean exists(@NotNull DogHubUser user) {
        return repository.existsByUsername(user.getUsername());
    }

    public Optional<DogHubUser> findPrevious(@NotNull Long id) {
        return repository.findTop1ByIdLessThanOrderByIdDesc(id);
    }

    public Optional<DogHubUser> findNext(@NotNull Long id) {
        return repository.findTop1ByIdGreaterThanOrderById(id);
    }

    public Optional<DogHubUser> findRandom() {
        long count = repository.count();
        Page<DogHubUser> page = repository.findAll(PageRequest.of(RandomUtils.nextInt(0, (int)count), 1, Sort.by(Sort.Direction.ASC, "id")));
        if(page.iterator().hasNext()) {
            return Optional.of(page.iterator().next());
        }
        return Optional.empty();
    }

    public Optional<DogHubUser> findByUsername(@NotNull String username) {
        return repository.findByUsername(username);
    }

    public boolean existsByUsername(@NotNull String username) {
        return repository.existsByUsername(username);
    }
}
