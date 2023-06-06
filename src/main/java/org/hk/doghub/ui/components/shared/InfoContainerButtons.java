package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class InfoContainerButtons extends HorizontalLayout {

    public static final String CLASS_NAME = "info-container-buttons";

    private final InfoSaveButton save;

    private final InfoCancelButton cancel;

    public InfoContainerButtons() {
        addClassName(CLASS_NAME);

        save = new InfoSaveButton();
        add(save);

        cancel = new InfoCancelButton();
        add(cancel);
    }

    public void addInfoSaveListener(InfoSaveListener listener) {
        save.addInfoSaveListener(listener);
    }

    public void removeInfoSaveListener(InfoSaveListener listener) {
        save.removeInfoSaveListener(listener);
    }

    public void addInfoCancelListener(InfoCancelListener listener) {
        cancel.addInfoCancelListener(listener);
    }

    public void removeInfoCancelListener(InfoCancelListener listener) {
        cancel.removeInfoCancelListener(listener);
    }
}
