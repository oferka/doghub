package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.shared.Tooltip;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.html.AnchorTarget.BLANK;
import static com.vaadin.flow.component.icon.VaadinIcon.EXTERNAL_LINK;
import static java.lang.String.format;

public class TipAnchor extends Anchor {

    public static final String CLASS_NAME = "tip-anchor";

    public TipAnchor(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        String moreInfo = tip.getMoreInfo();
        if(moreInfo != null) {
            setHref(format("https://www.%s", tip.getMoreInfo()));
            Icon externalLinkIcon = new Icon(EXTERNAL_LINK);
            externalLinkIcon.addClassName(format("%s-icon", CLASS_NAME));
            Tooltip.forComponent(externalLinkIcon).setText("Open link in a new tab");
            add(externalLinkIcon);
            setTarget(BLANK);
        }
    }
}
