package org.hk.doghub.ui.components.shared.tip;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;
import org.hk.doghub.ui.views.app.tips.create.TipCreationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_TERTIARY_INLINE;
import static com.vaadin.flow.component.icon.VaadinIcon.*;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static com.vaadin.flow.component.notification.NotificationVariant.LUMO_ERROR;
import static com.vaadin.flow.component.notification.NotificationVariant.LUMO_SUCCESS;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Slf4j
public class TipInfoContainerForm extends FormLayout {

    public static final String CLASS_NAME = TipInfoContainer.CLASS_NAME + "-form";

    private final TipIdField id;
    private final TipNameField name;
    private final TipTitleField title;
    private final TipContentField content;
    private final TipMoreInfoField moreInfo;
    private final TipThumbnailPictureField thumbnailPicture;
    private final TipCreationTimeField creationTime;
    private final TipCreatedByField createdBy;

    private final TipsDataProvider tipsDataProvider;

    private final TipCreationService tipCreationService;

    public TipInfoContainerForm(TipsDataProvider tipsDataProvider, TipCreationService tipCreationService) {
        this.tipsDataProvider = tipsDataProvider;
        this.tipCreationService = tipCreationService;
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
        setColspan(creationTime, 1);
        setColspan(createdBy, 1);
        setColspan(title, 2);
        setColspan(content, 2);
        setColspan(thumbnailPicture, 2);
        setColspan(moreInfo, 2);
        add(id, name, creationTime, createdBy, title, content, thumbnailPicture, moreInfo);
    }

    public void setTip(DogHubTip tip) {
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
                tipCreationService.save(
                        id.getValueAsLong(),
                        title.getValue(),
                        content.getValue(),
                        moreInfo.getValue(),
                        thumbnailPicture.getValue()
                );
                showSavedSuccessfullyNotification();
            }
            catch (Exception e) {
                log.error("Unexpected exception was thrown", e);
                showSaveFailedWithUnexpectedErrorNotification();
            }
        }
        else {
            showSaveFailedWithInvalidInput(violations);
        }
        log.info("Save for tip with ID '{}' has completed", id.getValue());
    }

    private void showSavedSuccessfullyNotification() {
        Notification notification = new Notification();
        notification.addThemeVariants(LUMO_SUCCESS);

        Icon icon = CHECK_CIRCLE.create();
        Div info = new Div(new Text("Tip saved successfully!"));
        Button viewBtn = new Button("View", clickEvent -> notification.close());
        viewBtn.getStyle().set("margin", "0 0 0 var(--lumo-space-l)");
        HorizontalLayout layout = new HorizontalLayout(icon, info, viewBtn, createCloseBtn(notification));
        layout.setAlignItems(CENTER);

        notification.add(layout);
        notification.setPosition(MIDDLE);
        notification.setDuration(5000);
        notification.open();
    }

    private void showSaveFailedWithUnexpectedErrorNotification() {
        Notification notification = new Notification();
        notification.addThemeVariants(LUMO_ERROR);

        Icon icon = WARNING.create();
        Div info = new Div(new Text("Failed to save tip!"));
        Button retryBtn = new Button("Retry", clickEvent -> {
            notification.close();
            save();
        });
        retryBtn.getStyle().set("margin", "0 0 0 var(--lumo-space-l)");
        HorizontalLayout layout = new HorizontalLayout(icon, info, retryBtn, createCloseBtn(notification));
        layout.setAlignItems(CENTER);

        notification.add(layout);
        notification.setPosition(MIDDLE);
        notification.setDuration(5000);
        notification.open();
    }

    private void showSaveFailedWithInvalidInput(List<String> violations) {
        Notification notification = new Notification();
        notification.addThemeVariants(LUMO_ERROR);

        Icon icon = WARNING.create();
        VerticalLayout info = new VerticalLayout();
        Div infoHeader = new Div(new Text("Failed to save tip!"));
        info.add(infoHeader);
        for(String violation : violations) {
            info.add(new Div(new Text(violation)));
        }
        HorizontalLayout layout = new HorizontalLayout(icon, info, createCloseBtn(notification));
        layout.setAlignItems(CENTER);

        notification.add(layout);
        notification.setPosition(MIDDLE);
        notification.setDuration(10000);
        notification.open();
    }

    private Button createCloseBtn(Notification notification) {
        Button closeBtn = new Button(CLOSE_SMALL.create(), clickEvent -> notification.close());
        closeBtn.addThemeVariants(LUMO_TERTIARY_INLINE);
        return closeBtn;
    }

    private List<String> validateInput() {
        List<String> violations = new ArrayList<>();
        violations.addAll(id.validateTipField());
        violations.addAll(name.validateTipField());
        violations.addAll(title.validateTipField());
        violations.addAll(content.validateTipField());
        violations.addAll(moreInfo.validateTipField());
        violations.addAll(thumbnailPicture.validateTipField());
        violations.addAll(creationTime.validateTipField());
        violations.addAll(createdBy.validateTipField());
        return violations;
    }

    public void cancel() {
        Optional<DogHubTip> tipOptional = tipsDataProvider.findById(id.getValue().longValue());
        tipOptional.ifPresent(this::setTip);
    }
}
