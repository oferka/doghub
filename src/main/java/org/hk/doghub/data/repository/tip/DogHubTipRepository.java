package org.hk.doghub.data.repository.tip;

import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface DogHubTipRepository extends JpaRepository<DogHubTip, Long>, JpaSpecificationExecutor<DogHubTip> {

    Optional<DogHubTip> findByTitle(String title);

    boolean existsByTitle(String title);

    List<DogHubTip> findByCreatedBy(DogHubUser user);

    long countByCreatedBy(DogHubUser user);

    boolean existsByIdAndCreatedBy(Long id, DogHubUser user);

    boolean existsByTitleAndCreatedBy(String title, DogHubUser user);

    Optional<DogHubTip> findTop1ByIdGreaterThanOrderById(Long id);

    Optional<DogHubTip> findTop1ByIdLessThanOrderByIdDesc(Long id);

    Optional<DogHubTip> findTop1ByIdGreaterThanAndCreatedByOrderById(Long id, DogHubUser user);

    Optional<DogHubTip> findTop1ByIdLessThanAndCreatedByOrderByIdDesc(Long id, DogHubUser user);
}
