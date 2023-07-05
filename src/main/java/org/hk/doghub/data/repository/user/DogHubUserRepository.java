package org.hk.doghub.data.repository.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hk.doghub.data.repository.EntityRepository;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

import static org.hk.doghub.model.user.DogHubUser.USER_NAME_MAX_LENGTH;

@Validated
public interface DogHubUserRepository extends EntityRepository<DogHubUser> {

    Optional<DogHubUser> findByUsername(@NotNull @Size(max = USER_NAME_MAX_LENGTH) String username);

    boolean existsByUsername(@NotNull @Size(max = USER_NAME_MAX_LENGTH) String username);

    Optional<DogHubUser> findTop1ByIdGreaterThanOrderById(@NotNull Long id);

    Optional<DogHubUser> findTop1ByIdLessThanOrderByIdDesc(@NotNull Long id);
}
