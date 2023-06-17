package org.hk.doghub.ui.views.app.dogs;

import com.vaadin.flow.data.renderer.ComponentRenderer;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesGrid;
import org.hk.doghub.ui.components.shared.user.UserAvatarRouterLink;
import org.hk.doghub.ui.views.app.EntityDataProvider;
import org.hk.doghub.ui.views.app.dogs.dog.DogView;

import java.util.Collection;

public class DogsGrid extends EntitiesGrid<DogHubDog, DogView> {

    public static final String CLASS_NAME = "dogs-grid";

    public DogsGrid(EntityDataProvider<DogHubDog> entityDataProvider, AuthenticatedUser authenticatedUser) {
        super(entityDataProvider, authenticatedUser, DogView.class);
        addClassName(CLASS_NAME);
    }

    @Override
    protected void addSpecificColumns(AuthenticatedUser authenticatedUser, Class<? extends DogView> entityClass) {
        addColumn(new ComponentRenderer<>(DogBreedCell::new)).setHeader("Breed").setComparator(DogHubDog::getBreed);
        addColumn(new ComponentRenderer<>(DogSoundCell::new)).setHeader("Sound").setComparator(DogHubDog::getSound);
        addColumn(new ComponentRenderer<>(DogAgeCell::new)).setHeader("Age").setComparator(DogHubDog::getAge);
        addColumn(new ComponentRenderer<>(DogCoatLengthCell::new)).setHeader("Coat Length").setComparator(DogHubDog::getCoatLength);
        addColumn(new ComponentRenderer<>(DogSizeCell::new)).setHeader("Size").setComparator(DogHubDog::getSize);
        addColumn(new ComponentRenderer<>(DogGenderCell::new)).setHeader("Gender").setComparator(DogHubDog::getGender);
        if(authenticatedUser.hasAdminRole()) {
            addColumn(new ComponentRenderer<>(tip -> new UserAvatarRouterLink(tip.getCreatedBy()))).setHeader("Created By").setComparator(tip -> tip.getCreatedBy().getName());
        }
    }

    @Override
    protected Collection<DogHubDog> getItems(EntityDataProvider<DogHubDog> entityDataProvider, AuthenticatedUser authenticatedUser) {
        return ((DogDataProvider)entityDataProvider).findAllForUser(authenticatedUser);
    }
}
