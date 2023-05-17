package org.hk.doghub.data.repository;

import org.hk.doghub.model.DogHubUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface DogHubUserRepository extends JpaRepository<DogHubUser, Long>, JpaSpecificationExecutor<DogHubUser> {

    Optional<DogHubUser> findByUsername(String username);

    boolean existsByUsername(String username);
}
