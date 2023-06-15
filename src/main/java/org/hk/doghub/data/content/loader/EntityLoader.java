package org.hk.doghub.data.content.loader;

import org.hk.doghub.model.AbstractEntity;

public interface EntityLoader<T extends AbstractEntity> {

    long load();
}
