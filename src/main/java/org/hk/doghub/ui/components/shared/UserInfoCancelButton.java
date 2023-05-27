package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.Key.KEY_C;
import static com.vaadin.flow.component.KeyModifier.ALT;

@Slf4j
public class UserInfoCancelButton extends Button {

    public static final String CLASS_NAME = UserInfoContainerButtons.CLASS_NAME + "-cancel";

    public UserInfoCancelButton() {
        addClassName(CLASS_NAME);
        setText("Cancel");
        addClickShortcut(KEY_C, ALT);
        addClickListener(this::cancelClicked);
    }

    private void cancelClicked(ClickEvent<Button> event) {
        log.info("Cancel clicked");
    }
}
