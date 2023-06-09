package org.hk.doghub.ui.views.app.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hk.doghub.ui.components.shared.EntitiesViewPresentationMode;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersViewPresentationModeChangeEvent {

    private EntitiesViewPresentationMode oldPresentationMode;

    private EntitiesViewPresentationMode newPresentationMode;
}
