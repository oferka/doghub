package org.hk.doghub.ui.components.shared.dog;

import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.ui.components.shared.EntityInfoContainerForm;
import org.hk.doghub.ui.components.shared.EntityUpdateParameters;
import org.hk.doghub.ui.components.shared.EntityUpdateService;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.ArrayList;
import java.util.List;

public class DogInfoContainerForm extends EntityInfoContainerForm<DogHubDog, DogUpdateParameters> {

    public static final String CLASS_NAME = "dog-info-container-form";

    private DogIdField id;
    private DogNameField name;
    private DogBreedField breed;
    private DogSoundField sound;
    private DogAgeField age;
    private DogCoatLengthField coatLength;
    private DogSizeField size;
    private DogGenderField gender;
    private DogThumbnailPictureField thumbnailPicture;
    private DogCreationTimeField creationTime;
    private DogCreatedByField createdBy;

    public DogInfoContainerForm(EntityDataProvider<DogHubDog> entityDataProvider, EntityUpdateService<DogHubDog, DogUpdateParameters> entityUpdateService) {
        super(entityDataProvider, entityUpdateService);
    }

    protected void addClassName() {
        addClassName(CLASS_NAME);
    }

    protected void createFields() {
        id = new DogIdField();
        name = new DogNameField();
        breed = new DogBreedField();
        sound = new DogSoundField();
        age = new DogAgeField();
        coatLength = new DogCoatLengthField();
        size = new DogSizeField();
        gender = new DogGenderField();
        thumbnailPicture = new DogThumbnailPictureField();
        creationTime = new DogCreationTimeField();
        createdBy = new DogCreatedByField();
    }

    protected void addFields() {
        setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("500px", 2));
        setColspan(id, 1);
        setColspan(name, 1);
        setColspan(createdBy, 1);
        setColspan(creationTime, 1);
        setColspan(breed, 1);
        setColspan(sound, 1);
        setColspan(age, 1);
        setColspan(coatLength, 1);
        setColspan(size, 1);
        setColspan(gender, 1);
        setColspan(thumbnailPicture, 2);
        add(id, name, createdBy, creationTime, breed, sound, age, coatLength, size, gender, thumbnailPicture);
    }

    public void setValue(DogHubDog dog) {
        id.setValue(dog);
        name.setValue(dog);
        breed.setValue(dog);
        sound.setValue(dog);
        age.setValue(dog);
        coatLength.setValue(dog);
        size.setValue(dog);
        gender.setValue(dog);
        thumbnailPicture.setValue(dog);
        creationTime.setValue(dog);
        createdBy.setValue(dog);
    }

    @Override
    protected DogHubDog update(EntityUpdateParameters updateParameters) {
        return entityUpdateService.update((DogUpdateParameters) updateParameters);
    }

    protected DogUpdateParameters getUpdateParameters() {
        DogUpdateParameters result = new DogUpdateParameters();
        result.setId(id.getValueAsLong());
        result.setName(name.getValue());
        result.setBreed(breed.getValue());
        result.setSound(sound.getValue());
        result.setAge(age.getValue());
        result.setCoatLength(coatLength.getValue());
        result.setSize(size.getValue());
        result.setGender(gender.getValue());
        result.setThumbnailPicture(thumbnailPicture.getValue());
        return result;
    }

    protected List<String> validateInput() {
        List<String> violations = new ArrayList<>();
        violations.addAll(id.validateField());
        violations.addAll(name.validateField());
        violations.addAll(breed.validateField());
        violations.addAll(sound.validateField());
        violations.addAll(age.validateField());
        violations.addAll(coatLength.validateField());
        violations.addAll(size.validateField());
        violations.addAll(gender.validateField());
        violations.addAll(thumbnailPicture.validateField());
        violations.addAll(creationTime.validateField());
        violations.addAll(createdBy.validateTipField());
        return violations;
    }
}
