package org.hk.doghub.ui.components.shared.tip;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.ui.components.shared.EntityInfoContainerForm;
import org.hk.doghub.ui.components.shared.EntityUpdateParameters;
import org.hk.doghub.ui.components.shared.EntityUpdateService;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TipInfoContainerForm extends EntityInfoContainerForm<DogHubTip, TipUpdateParameters> {

    public static final String CLASS_NAME = TipInfoContainer.CLASS_NAME + "-form";

    private TipIdField id;
    private TipNameField name;
    private TipTitleField title;
    private TipContentField content;
    private TipMoreInfoField moreInfo;
    private TipThumbnailPictureField thumbnailPicture;
    private TipCreationTimeField creationTime;
    private TipCreatedByField createdBy;

    public TipInfoContainerForm(EntityDataProvider<DogHubTip> entityDataProvider, EntityUpdateService<DogHubTip, TipUpdateParameters> entityUpdateService) {
        super(entityDataProvider, entityUpdateService);
    }

    protected void addClassName() {
        addClassName(CLASS_NAME);
    }

    protected void createFields() {
        id = new TipIdField();
        name = new TipNameField();
        title = new TipTitleField();
        content = new TipContentField();
        moreInfo = new TipMoreInfoField();
        thumbnailPicture = new TipThumbnailPictureField();
        creationTime = new TipCreationTimeField();
        createdBy = new TipCreatedByField();
    }

    protected void addFields() {
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

    @Override
    protected DogHubTip update(EntityUpdateParameters updateParameters) {
        return entityUpdateService.update((TipUpdateParameters) updateParameters);
    }

    protected TipUpdateParameters getUpdateParameters() {
        TipUpdateParameters result = new TipUpdateParameters();
        result.setId(id.getValueAsLong());
        result.setName(name.getValue());
        result.setTitle(title.getValue());
        result.setContent(content.getValue());
        result.setMoreInfo(moreInfo.getValue());
        result.setThumbnailPicture(thumbnailPicture.getValue());
        return result;
    }

    protected List<String> validateInput() {
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
