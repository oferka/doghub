package org.hk.doghub.data.content.loader;

import org.hk.doghub.model.AbstractEntity;

public interface EntityContentLoader<T extends AbstractEntity> {

    long load();
}
