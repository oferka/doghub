package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.*;
import org.hk.doghub.ui.components.shared.user.UserUpdateParameters;
import org.hk.doghub.ui.views.app.EntityDataProvider;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;
import org.hk.doghub.ui.views.app.users.UsersView;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Route(value = UsersView.ROUTE, layout = DogHubAppLayout.class)
@PageTitle(UserView.NAME)
@RolesAllowed({"ADMIN"})
public class UserView extends VerticalLayout implements HasUrlParameter<Long>, InfoSaveListener, InfoCancelListener {

    public static final String ID_PREFIX = "user";
    public static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "User";

    private final EntityViewHeader<DogHubUser> header;
    private final EntityViewBody<DogHubUser, UserUpdateParameters> body;
    private final EntityViewFooter<DogHubUser> footer;

    public UserView(EntityDataProvider<DogHubUser> entityDataProvider, AuthenticatedUser authenticatedUser, EntityUpdateService<DogHubUser, UserUpdateParameters> entityUpdateService) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        header = new EntityViewHeader<>(entityDataProvider);
        add(header);

        body = new UserViewBody(entityDataProvider, entityUpdateService);
        body.addInfoSaveListener(this);
        body.addInfoCancelListener(this);
        addAndExpand(body);

        footer = new EntityViewFooter<>(entityDataProvider, authenticatedUser, UserView.NAME, UserView.class, UsersView.NAME, UsersView.class);
        add(footer);
    }

    @Override
    public void setParameter(BeforeEvent event, Long parameter) {
        setEntity(parameter);
    }

    private void setEntity(long selectedEntityId) {
        header.selectedEntityChanged(selectedEntityId);
        body.selectedEntityChanged(selectedEntityId);
        footer.selectedEntityChanged(selectedEntityId);
    }

    @Override
    public void saveTriggered(InfoSaveEvent event) {
        header.save();
        body.save();
        footer.save();
    }

    @Override
    public void cancelTriggered(InfoCancelEvent event) {
        header.cancel();
        body.cancel();
        footer.cancel();
    }
}
