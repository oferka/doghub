package org.hk.doghub.data.repository.dog;

import org.hk.doghub.data.repository.EntityRepository;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.model.user.DogHubUser;

import java.util.List;
import java.util.Optional;

public interface DogHubDogRepository extends EntityRepository<DogHubDog> {

    List<DogHubDog> findByCreatedBy(DogHubUser user);

    long countByCreatedBy(DogHubUser user);

    boolean existsByIdAndCreatedBy(Long id, DogHubUser user);

    boolean existsByNameAndCreatedBy(String name, DogHubUser user);

    Optional<DogHubDog> findTop1ByIdGreaterThanOrderById(Long id);

    Optional<DogHubDog> findTop1ByIdLessThanOrderByIdDesc(Long id);

    Optional<DogHubDog> findTop1ByIdGreaterThanAndCreatedByOrderById(Long id, DogHubUser user);

    Optional<DogHubDog> findTop1ByIdLessThanAndCreatedByOrderByIdDesc(Long id, DogHubUser user);
}
