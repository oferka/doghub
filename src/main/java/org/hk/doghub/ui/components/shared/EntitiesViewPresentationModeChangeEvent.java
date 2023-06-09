package org.hk.doghub.ui.components.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntitiesViewPresentationModeChangeEvent {

    private EntitiesViewPresentationMode oldPresentationMode;

    private EntitiesViewPresentationMode newPresentationMode;
}
