package org.hk.doghub.model;

import jakarta.validation.constraints.NotNull;

@FunctionalInterface
public interface HasFeedback {

    @NotNull DogHubFeedback getFeedback();
}
