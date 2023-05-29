package org.hk.doghub.data.repository.user;

import org.hk.doghub.model.user.DogHubUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface DogHubUserRepository extends JpaRepository<DogHubUser, Long>, JpaSpecificationExecutor<DogHubUser> {

    Optional<DogHubUser> findByUsername(String username);

    boolean existsByUsername(String username);

    Optional<DogHubUser> findTop1ByIdGreaterThanOrderById(Long id);

    Optional<DogHubUser> findTop1ByIdLessThanOrderByIdDesc(Long id);
}
