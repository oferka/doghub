package org.hk.doghub.model;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;

@FunctionalInterface
public interface HasCreatedBy {

    @NotNull DogHubUser getCreatedBy();
}
