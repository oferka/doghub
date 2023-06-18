package org.hk.doghub.ui.views.app.dogs;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.ui.views.app.CreatedByEntityDataProvider;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface DogDataProvider extends CreatedByEntityDataProvider<DogHubDog> {

    @NotNull List<String> getAllBreeds() throws URISyntaxException, IOException;
}
