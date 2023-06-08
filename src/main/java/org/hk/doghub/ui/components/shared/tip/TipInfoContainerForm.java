package org.hk.doghub.ui.components.shared.tip;

import com.vaadin.flow.component.notification.Notification;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.ui.components.shared.*;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class TipInfoContainerForm extends EntityInfoContainerForm<DogHubTip, TipUpdateParameters> {

    public static final String CLASS_NAME = TipInfoContainer.CLASS_NAME + "-form";

    private final TipIdField id;
    private final TipNameField name;
    private final TipTitleField title;
    private final TipContentField content;
    private final TipMoreInfoField moreInfo;
    private final TipThumbnailPictureField thumbnailPicture;
    private final TipCreationTimeField creationTime;
    private final TipCreatedByField createdBy;

    public TipInfoContainerForm(EntityDataProvider<DogHubTip> entityDataProvider, EntityUpdateService<DogHubTip, TipUpdateParameters> entityUpdateService) {
        super(entityDataProvider, entityUpdateService);
        addClassName(CLASS_NAME);

        id = new TipIdField();
        name = new TipNameField();
        title = new TipTitleField();
        content = new TipContentField();
        moreInfo = new TipMoreInfoField();
        thumbnailPicture = new TipThumbnailPictureField();
        creationTime = new TipCreationTimeField();
        createdBy = new TipCreatedByField();

        setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("500px", 2));
        setColspan(id, 1);
        setColspan(name, 1);
        setColspan(createdBy, 1);
        setColspan(creationTime, 1);
        setColspan(title, 2);
        setColspan(content, 2);
        setColspan(thumbnailPicture, 2);
        setColspan(moreInfo, 2);
        add(id, name, createdBy, creationTime, title, content, thumbnailPicture, moreInfo);
    }

    public void setValue(DogHubTip tip) {
        id.setValue(tip);
        name.setValue(tip);
        title.setValue(tip);
        content.setValue(tip);
        moreInfo.setValue(tip);
        thumbnailPicture.setValue(tip);
        creationTime.setValue(tip);
        createdBy.setValue(tip);
    }

    public void save() {
        log.info("Save for tip with ID '{}' has started", id.getValue());
        List<String> violations = validateInput();
        if(violations.isEmpty()) {
            try {
                DogHubTip tip = entityUpdateService.update(getUpdateParameters());
                log.info("Save successfully for tip with ID '{}'", tip.getId());
                showSavedSuccessfullyNotification();
            }
            catch (Exception e) {
                log.error("Unexpected exception was thrown", e);
                showSaveFailedWithUnexpectedErrorNotification();
            }
        }
        else {
            showSaveFailedWithInvalidInputNotification(violations);
        }
        log.info("Save for tip with ID '{}' has completed", id.getValue());
    }

    private TipUpdateParameters getUpdateParameters() {
        TipUpdateParameters result = new TipUpdateParameters();
        result.setId(id.getValueAsLong());
        result.setName(name.getValue());
        result.setTitle(title.getValue());
        result.setContent(content.getValue());
        result.setMoreInfo(moreInfo.getValue());
        result.setThumbnailPicture(thumbnailPicture.getValue());
        return result;
    }

    public void cancel() {
        Optional<DogHubTip> tipOptional = entityDataProvider.findById(id.getValue().longValue());
        tipOptional.ifPresent(this::setValue);
    }

    private void showSavedSuccessfullyNotification() {
        Notification notification = new SavedSuccessfullyNotification();
        notification.open();
    }

    private void showSaveFailedWithUnexpectedErrorNotification() {
        Notification notification = new SaveFailedWithUnexpectedErrorNotification();
        notification.open();
    }

    private void showSaveFailedWithInvalidInputNotification(List<String> violations) {
        Notification notification = new SaveFailedWithInvalidInputNotification(violations);
        notification.open();
    }

    private List<String> validateInput() {
        List<String> violations = new ArrayList<>();
        violations.addAll(id.validateField());
        violations.addAll(name.validateField());
        violations.addAll(title.validateField());
        violations.addAll(content.validateField());
        violations.addAll(moreInfo.validateField());
        violations.addAll(thumbnailPicture.validateField());
        violations.addAll(creationTime.validateField());
        violations.addAll(createdBy.validateTipField());
        return violations;
    }
}
