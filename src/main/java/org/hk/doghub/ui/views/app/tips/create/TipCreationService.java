package org.hk.doghub.ui.views.app.tips.create;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.service.tip.DogHubTipService;
import org.hk.doghub.model.DogHubFeedback;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

import static org.hk.doghub.model.tip.DogHubTip.TITLE_MAX_LENGTH;

@Slf4j
@Service
@RequiredArgsConstructor
public class TipCreationService {

    private final DogHubTipService tipService;

    public DogHubTip create(@NotNull @Size(max = TITLE_MAX_LENGTH) String title,
                            @NotNull DogHubUser createdBy) {
        return tipService.save(getTipEntity(title, createdBy));
    }

    private @NotNull DogHubTip getTipEntity(@NotNull @Size(max = TITLE_MAX_LENGTH) String title,
                                            @NotNull DogHubUser createdBy) {
        DogHubTip result = new DogHubTip();
        result.setName(title);
        result.setTitle(title);
        result.setCreationTime(ZonedDateTime.now());
        result.setCreatedBy(createdBy);
        result.setFeedback(new DogHubFeedback());
        return result;
    }

    public boolean exists(@NotNull @Size(max = TITLE_MAX_LENGTH) String title,
                          @NotNull DogHubUser createdBy) {
        return tipService.existsByTitleAndCreatedBy(title, createdBy);
    }
}
