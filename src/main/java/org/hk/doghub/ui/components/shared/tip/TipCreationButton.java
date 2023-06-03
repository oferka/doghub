package org.hk.doghub.ui.components.shared.tip;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.create.TipCreationService;
import org.hk.doghub.ui.views.app.tips.tip.TipView;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

import static com.vaadin.flow.component.Key.KEY_C;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.notification.Notification.Position.TOP_CENTER;
import static java.lang.String.format;

@Slf4j
public class TipCreationButton extends Button {

    public static final String CLASS_NAME = "tip-creation-button";

    private final TipTitleField title;

    private final AuthenticatedUser authenticatedUser;

    private final TipCreationService tipCreationService;

    public TipCreationButton(TipTitleField title, AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        this.title = title;
        this.authenticatedUser = authenticatedUser;
        this.tipCreationService = tipCreationService;
        addClassName(CLASS_NAME);
        setText("Continue");
        addClickListener(this::clicked);
        addClickShortcut(KEY_C, ALT);
    }

    private void clicked(ClickEvent<Button> event) {
        String titleValue = title.getValue();
        log.info("Tip creation flow for tip with title '{}' has started", titleValue);
        if(titleValue.isBlank()) {
            log.warn("Attempt to create a tip with blank title");
            Notification notification = Notification.show("Can't create a tip with a blank title. Please enter something...", 5000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            return;
        }
        if(title.isInvalid()) {
            log.warn("Attempt to create a tip with invalid title '{}'", titleValue);
            Notification notification = Notification.show(format("Can't create a tip with title '%s'. Please enter a valid title", titleValue), 5000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            return;
        }
        Optional<DogHubUser> userOptional = authenticatedUser.get();
        DogHubUser user = userOptional.orElseThrow();
        if(tipCreationService.exists(titleValue, user)) {
            log.warn("Attempt to create a tip with existing title '{}'", titleValue);
            title.setInvalid(true);
            title.setErrorMessage("You already created a tip with that title. Please enter a unique one.");
            Notification notification = Notification.show(format("You already created a tip titled '%s'. Please use a different title.", titleValue), 10000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            return;
        }
        try {
            DogHubTip tip = tipCreationService.create(titleValue, user);
            Notification notification = Notification.show(format("Tip title %s created successfully!", titleValue), 3000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            navigateToCreatedTipView(tip);
        }
        catch (DataIntegrityViolationException e) {
            log.warn("Data integrity violation exception was thrown", e);
            Notification notification = Notification.show(format("A tip titled '%s' already exists. Please use a different title.", titleValue), 5000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        }
        catch (Exception e) {
            log.error("Unexpected exception was thrown", e);
            Notification notification = Notification.show(format("Failed to create a tip titled %s. Please try again later", titleValue), 5000, TOP_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        }
    }

    private void navigateToCreatedTipView(DogHubTip tip) {
        getUI().ifPresent(ui -> ui.navigate(TipView.class, tip.getId()));
    }
}
