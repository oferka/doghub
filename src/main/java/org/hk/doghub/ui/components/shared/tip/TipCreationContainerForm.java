package org.hk.doghub.ui.components.shared.tip;

import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityCreationContainerForm;
import org.hk.doghub.ui.components.shared.EntityCreationParameters;
import org.hk.doghub.ui.components.shared.EntityCreationService;
import org.hk.doghub.ui.views.app.tips.tip.TipView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@Slf4j
public class TipCreationContainerForm extends EntityCreationContainerForm<DogHubTip, TipCreationParameters> {

    public static final String CLASS_NAME = "tip-creation-container-form";

    private TipTitleField title;

    public TipCreationContainerForm(AuthenticatedUser authenticatedUser, EntityCreationService<DogHubTip, TipCreationParameters> entityCreationService) {
        super(authenticatedUser, entityCreationService);
    }

    @Override
    protected void addClassName() {
        addClassName(CLASS_NAME);
    }

    @Override
    protected void createFields() {
        title = new TipTitleField();
    }

    @Override
    protected void addFields() {
        add(title);
    }

    @Override
    protected DogHubTip create(EntityCreationParameters creationParameters) {
        return creationService.create(((TipCreationParameters) creationParameters));
    }

    @Override
    protected EntityCreationParameters getCreationParameters() {
        TipCreationParameters result = new TipCreationParameters();
        result.setTitle(title.getValue());
        result.setName(title.getValue());
        result.setCreatedBy(getCreatedBy());
        return result;
    }

    @Override
    protected List<String> validateInput() {
        List<String> result = new ArrayList<>();
        String titleValue = title.getValue();
        if(titleValue.isBlank()) {
            log.warn("Attempt to create a tip with blank title");
            result.add("Can't create a tip with a blank title. Please enter something...");
        }
        if(title.isInvalid()) {
            log.warn("Attempt to create a tip with invalid title '{}'", titleValue);
            result.add(format("Can't create a tip with title '%s'. Please enter a valid title", titleValue));
        }
        EntityCreationParameters creationParameters = getCreationParameters();
        if(creationService.exists((TipCreationParameters) creationParameters)) {
            log.warn("Attempt to create a tip with existing title '{}'", titleValue);
            title.setInvalid(true);
            title.setErrorMessage("You already created a tip with that title. Please enter a unique one.");
            result.add(format("You already created a tip titled '%s'. Please use a different title.", titleValue));
        }
        return result;
    }

    @Override
    protected void postSuccessfulCreation(DogHubTip entity) {
        navigateToCreatedTipView(entity);
    }

    private void navigateToCreatedTipView(DogHubTip tip) {
        getUI().ifPresent(ui -> ui.navigate(TipView.class, tip.getId()));
    }

    private @NotNull DogHubUser getCreatedBy() {
        Optional<DogHubUser> userOptional = authenticatedUser.get();
        return userOptional.orElseThrow();
    }
}
