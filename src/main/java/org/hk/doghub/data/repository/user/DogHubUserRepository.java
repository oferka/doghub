package org.hk.doghub.data.repository.user;

import org.hk.doghub.data.repository.EntityRepository;
import org.hk.doghub.model.user.DogHubUser;

import java.util.Optional;

public interface DogHubUserRepository extends EntityRepository<DogHubUser> {

    Optional<DogHubUser> findByUsername(String username);

    boolean existsByUsername(String username);

    Optional<DogHubUser> findTop1ByIdGreaterThanOrderById(Long id);

    Optional<DogHubUser> findTop1ByIdLessThanOrderByIdDesc(Long id);
}
