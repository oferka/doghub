package org.hk.doghub.data.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.AbstractEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface EntityService<T extends AbstractEntity> {

    Optional<T> findById(@NotNull Long id);

    List<T> findAll();

    Page<T> findAll(@NotNull Pageable pageable);

    T save(@NotNull @Valid T entity);

    Page<T> findAll(@NotNull Pageable pageable, @NotNull Specification<T> filter);

    int count();

    boolean exists(@NotNull @Valid T entity);

    Optional<T> findPrevious(@NotNull Long id);

    Optional<T> findNext(@NotNull Long id);
}
