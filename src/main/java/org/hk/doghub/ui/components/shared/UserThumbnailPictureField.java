package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.textfield.TextField;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;

import static com.vaadin.flow.component.icon.VaadinIcon.PICTURE;
import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static java.text.MessageFormat.format;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class UserThumbnailPictureField extends TextField {

    public static final String CLASS_NAME = "user-thumbnail-picture-field";

    public static final String LABEL = "Avatar URL";

    public UserThumbnailPictureField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
        setRequiredIndicatorVisible(true);
        setMinLength(5);
        setMaxLength(256);
        setPrefixComponent(PICTURE.create());
        setValueChangeMode(EAGER);
        addValueChangeListener(this::valueChanged);
    }

    public void setValue(@NotNull DogHubUser user) {
        setValue((user.getThumbnailPicture() != null)?user.getThumbnailPicture() : EMPTY);
    }

    private void valueChanged(ComponentValueChangeEvent<TextField, String> event) {
        String value = event.getValue();
        if(isValidValue(value)) {
            event.getSource().setInvalid(false);
            event.getSource().setErrorMessage(null);
        }
        else {
            event.getSource().setInvalid(true);
            event.getSource().setErrorMessage(format("{0} length must be between 5 and 256 characters", LABEL));
        }
    }

    private boolean isValidValue(String value) {
        return(value.length() >= 5 && value.length() <= 256);
    }
}
