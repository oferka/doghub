package org.hk.doghub.ui.views.app.tips.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.URL;
import org.hk.doghub.data.service.tip.DogHubTipService;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.time.ZonedDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class TipCreationService {

    private final DogHubTipService tipService;

    public DogHubTip create(@NotNull @Size(min = 2, max = 64) @NotBlank String title,
                            @NotNull @Size(min = 2, max = 1024) @NotBlank String content,
                            @Nullable String moreInfo,
                            @Nullable @URL String thumbnailPicture,
                            @NotNull DogHubUser createdBy) {
        return tipService.save(getTipEntity(title, content, moreInfo, thumbnailPicture, createdBy));
    }

    private @NotNull DogHubTip getTipEntity(@NotNull @Size(min = 2, max = 64) @NotBlank String title,
                                            @NotNull @Size(min = 2, max = 1024) @NotBlank String content,
                                            @Nullable String moreInfo,
                                            @Nullable @URL String thumbnailPicture,
                                            @NotNull DogHubUser createdBy) {
        DogHubTip result = new DogHubTip();
        result.setTitle(title);
        result.setName(title);
        result.setContent(content);
        result.setMoreInfo(moreInfo);
        result.setThumbnailPicture(thumbnailPicture);
        result.setCreationTime(ZonedDateTime.now());
        result.setCreatedBy(createdBy);
        return result;
    }

    public boolean exists(@NotNull @Size(min = 2, max = 64) @NotBlank String title, @NotNull DogHubUser createdBy) {
        return tipService.existsByTitleAndCreatedBy(title, createdBy);
    }
}
