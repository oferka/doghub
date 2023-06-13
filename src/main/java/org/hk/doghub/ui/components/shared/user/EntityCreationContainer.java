package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.ui.components.shared.*;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Slf4j
public class EntityCreationContainer<T extends NamedEntity, P extends EntityCreationParameters> extends VerticalLayout implements InfoSaveListener {

    public static final String CLASS_NAME = "entity-creation-container";

    private final EntityCreationContainerForm<T, P> form;

    public EntityCreationContainer(EntityCreationContainerForm<T, P> form) {
        this.form = form;
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        EntityCreationButton create = new EntityCreationButton();
        create.addInfoSaveListener(this);
        add(form, create);
    }

    @Override
    public void saveTriggered(InfoSaveEvent event) {
        form.create();
    }
}
