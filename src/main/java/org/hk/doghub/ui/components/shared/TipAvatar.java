package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.shared.Tooltip;
import com.vaadin.flow.dom.DomEvent;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.tip.DogHubTip;

@Slf4j
public class TipAvatar extends Avatar {

    public static final String CLASS_NAME = "tip-avatar";

    public TipAvatar(DogHubTip tip) {
        addClassName(CLASS_NAME);
        setTip(tip);
        getElement().addEventListener("click", this::avatarClicked);
    }

    public void selectedTipChanged(DogHubTip tip) {
        setTip(tip);
    }

    public void setTip(DogHubTip tip) {
        if(tip != null) {
            setImage(tip.getThumbnailPicture());
            setName(tip.getName());
            Tooltip.forComponent(this).setText(tip.getName());
        }
    }

    private void avatarClicked(DomEvent event) {
        log.info("Avatar clicked");
    }
}
