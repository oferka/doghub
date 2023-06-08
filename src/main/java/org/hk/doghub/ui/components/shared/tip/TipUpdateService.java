package org.hk.doghub.ui.components.shared.tip;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.URL;
import org.hk.doghub.data.service.tip.DogHubTipService;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.ui.components.shared.EntityUpdateService;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.lang.String.format;
import static org.hk.doghub.model.NamedEntity.NAME_MAX_LENGTH;
import static org.hk.doghub.model.tip.DogHubTip.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class TipUpdateService implements EntityUpdateService<DogHubTip, TipUpdateParameters> {

    private final DogHubTipService tipService;

    @Override
    public @NotNull DogHubTip update(@NotNull TipUpdateParameters updateParameters) {
        return update(
                updateParameters.getId(),
                updateParameters.getName(),
                updateParameters.getTitle(),
                updateParameters.getContent(),
                updateParameters.getMoreInfo(),
                updateParameters.getThumbnailPicture()
        );
    }

    private @NotNull DogHubTip update(@NotNull Long id,
                            @NotNull @Size(max = NAME_MAX_LENGTH) String name,
                            @NotNull @Size(max = TITLE_MAX_LENGTH) String title,
                            @Size(max = CONTENT_MAX_LENGTH) String content,
                            @Size(max = MORE_INFO_MAX_LENGTH) String moreInfo,
                            @Size(max = THUMBNAIL_PICTURE_MAX_LENGTH) @URL String thumbnailPicture) {
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
}
