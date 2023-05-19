package org.hk.doghub.ui.views.app.tips;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipsViewPresentationModeChangeEvent {

    private TipsViewPresentationMode oldTipViewPresentationMode;

    private TipsViewPresentationMode newTipViewPresentationMode;
}
