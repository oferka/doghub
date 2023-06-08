package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EntityInfoContainerForm;
import org.hk.doghub.ui.components.shared.InfoCancelListener;
import org.hk.doghub.ui.components.shared.InfoContainerButtons;
import org.hk.doghub.ui.components.shared.InfoSaveListener;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.Optional;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserInfoContainer extends VerticalLayout {

    public static final String CLASS_NAME = "user-info-container";

    private final EntityDataProvider<DogHubUser> entityDataProvider;

    private final EntityInfoContainerForm<DogHubUser, UserUpdateParameters> form;

    private final InfoContainerButtons buttons;

    public UserInfoContainer(EntityDataProvider<DogHubUser> entityDataProvider, UserUpdateService userUpdateService) {
        this.entityDataProvider = entityDataProvider;
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        form = new UserInfoContainerForm(entityDataProvider, userUpdateService);
        add(form);

        buttons = new InfoContainerButtons();
        add(buttons);
    }

    public void setUser(long userId) {
        Optional<DogHubUser> userOptional = entityDataProvider.findById(userId);
        userOptional.ifPresent(form::setValue);
    }

    public void save() {
        form.save();
    }

    public void cancel() {
        form.cancel();
    }

    public void addInfoSaveListener(InfoSaveListener listener) {
        buttons.addInfoSaveListener(listener);
    }

    public void removeInfoSaveListener(InfoSaveListener listener) {
        buttons.removeInfoSaveListener(listener);
    }

    public void addInfoCancelListener(InfoCancelListener listener) {
        buttons.addInfoCancelListener(listener);
    }

    public void removeInfoCancelListener(InfoCancelListener listener) {
        buttons.removeInfoCancelListener(listener);
    }
}
