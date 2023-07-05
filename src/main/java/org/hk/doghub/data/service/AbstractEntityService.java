package org.hk.doghub.data.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.data.repository.EntityRepository;
import org.hk.doghub.model.AbstractEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Validated
public abstract class AbstractEntityService<T extends AbstractEntity> implements EntityService<T> {

    public Optional<T> findById(@NotNull Long id) {
        return getEntityRepository().findById(id);
    }

    public List<T> findAll() {
        return getEntityRepository().findAll();
    }

    public Page<T> findAll(@NotNull Pageable pageable) {
        return getEntityRepository().findAll(pageable);
    }

    public Page<T> findAll(@NotNull Pageable pageable, @NotNull Specification<T> filter) {
        return getEntityRepository().findAll(filter, pageable);
    }

    public T save(@NotNull @Valid T entity) {
        return getEntityRepository().save(entity);
    }

    public int count() {
        return (int)getEntityRepository().count();
    }

    protected abstract EntityRepository<T> getEntityRepository();
}
