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
import java.util.Optional;

import static java.lang.String.format;
import static org.hk.doghub.model.NamedEntity.NAME_MAX_LENGTH;

@Slf4j
@Service
@RequiredArgsConstructor
public class TipCreationService {

    private final DogHubTipService tipService;

    public DogHubTip create(@NotNull @Size(min = 2, max = 64) @NotBlank String title, @NotNull DogHubUser createdBy) {
        return tipService.save(getTipEntity(title, createdBy));
    }

    public DogHubTip save(@NotNull Long id,
                          @NotNull @Size(max = NAME_MAX_LENGTH) @NotBlank String name,
                          @NotNull @Size(min = 2, max = 64) @NotBlank String title,
                          @Nullable @Size(min = 2, max = 1024) String content,
                          @Nullable String moreInfo,
                          @Nullable @URL String thumbnailPicture) {
        Optional<DogHubTip> tipOptional = tipService.findById(id);
        if(tipOptional.isPresent()) {
            DogHubTip tip = tipOptional.get();
            tip.setName(name);
            tip.setTitle(title);
            tip.setContent(content);
            tip.setMoreInfo(moreInfo);
            tip.setThumbnailPicture(thumbnailPicture);
            return tipService.save(tip);
        }
        throw new IllegalArgumentException(format("Failed to save tip with ID: %s'", id));
    }

    private @NotNull DogHubTip getTipEntity(@NotNull @Size(min = 2, max = 64) @NotBlank String title,
                                            @NotNull DogHubUser createdBy) {
        DogHubTip result = new DogHubTip();
        result.setName(title);
        result.setTitle(title);
        result.setCreationTime(ZonedDateTime.now());
        result.setCreatedBy(createdBy);
        return result;
    }

    public boolean exists(@NotNull @Size(min = 2, max = 64) @NotBlank String title, @NotNull DogHubUser createdBy) {
        return tipService.existsByTitleAndCreatedBy(title, createdBy);
    }
}
