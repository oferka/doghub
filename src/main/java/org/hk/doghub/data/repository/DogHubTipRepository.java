package org.hk.doghub.data.repository;

import org.hk.doghub.model.DogHubTip;
import org.hk.doghub.model.DogHubUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface DogHubTipRepository extends JpaRepository<DogHubTip, Long>, JpaSpecificationExecutor<DogHubTip> {

    Optional<DogHubTip> findByValue(String value);

    boolean existsByValue(String value);

    List<DogHubTip> findByCreatedBy(DogHubUser user);

    long countByCreatedBy(DogHubUser user);

    boolean existsByIdAndCreatedBy(Long id, DogHubUser user);
}
