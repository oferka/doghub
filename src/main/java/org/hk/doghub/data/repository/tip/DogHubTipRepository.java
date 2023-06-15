package org.hk.doghub.data.repository.tip;

import org.hk.doghub.data.repository.EntityRepository;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.model.user.DogHubUser;

import java.util.List;
import java.util.Optional;

public interface DogHubTipRepository extends EntityRepository<DogHubTip> {

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
