package org.hk.doghub.ui.components.shared.dog;

import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityCreationContainerForm;
import org.hk.doghub.ui.components.shared.EntityCreationParameters;
import org.hk.doghub.ui.components.shared.EntityCreationService;
import org.hk.doghub.ui.views.app.dogs.dog.DogView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@Slf4j
public class DogCreationContainerForm extends EntityCreationContainerForm<DogHubDog, DogCreationParameters> {

    public static final String CLASS_NAME = "dog-creation-container-form";

    private DogNameField name;

    public DogCreationContainerForm(AuthenticatedUser authenticatedUser, EntityCreationService<DogHubDog, DogCreationParameters> entityCreationService) {
        super(authenticatedUser, entityCreationService);
    }

    @Override
    protected void addClassName() {
        addClassName(CLASS_NAME);
    }

    @Override
    protected void createFields() {
        name = new DogNameField();
    }

    @Override
    protected void addFields() {
        add(name);
    }

    @Override
    protected DogHubDog create(EntityCreationParameters creationParameters) {
        return creationService.create(((DogCreationParameters) creationParameters));
    }

    @Override
    protected EntityCreationParameters getCreationParameters() {
        DogCreationParameters result = new DogCreationParameters();
        result.setName(name.getValue());
        result.setCreatedBy(getCreatedBy());
        return result;
    }

    @Override
    protected List<String> validateInput() {
        List<String> result = new ArrayList<>();
        String nameValue = name.getValue();
        if(nameValue.isBlank()) {
            log.warn("Attempt to create a dog with blank name");
            result.add("Can't create a dog with a blank title. Please enter something...");
        }
        if(name.isInvalid()) {
            log.warn("Attempt to create a dog with invalid name '{}'", nameValue);
            result.add(format("Can't create a dog with name '%s'. Please enter a valid name", nameValue));
        }
        EntityCreationParameters creationParameters = getCreationParameters();
        if(creationService.exists((DogCreationParameters) creationParameters)) {
            log.warn("Attempt to create a dog with existing name '{}'", nameValue);
            name.setInvalid(true);
            name.setErrorMessage("You already created a dog with that name. Please enter a unique one.");
            result.add(format("You already created a dog named '%s'. Please use a different name.", nameValue));
        }
        return result;
    }

    @Override
    protected void postSuccessfulCreation(DogHubDog entity) {
        navigateToCreatedDogView(entity);
    }

    private void navigateToCreatedDogView(DogHubDog dog) {
        getUI().ifPresent(ui -> ui.navigate(DogView.class, dog.getId()));
    }

    private @NotNull DogHubUser getCreatedBy() {
        Optional<DogHubUser> userOptional = authenticatedUser.get();
        return userOptional.orElseThrow();
    }
}
