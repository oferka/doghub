package org.hk.doghub.data.content.generator.tip.service.provider.faker;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.tip.model.Tip;
import org.hk.doghub.data.content.generator.tip.service.TipProvider;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Validated
public class TipProviderFaker implements TipProvider {

    private final TipTitleProvider tipTitleProvider;

    private final TipContentProvider tipContentProvider;

    private final TipMoreInfoProvider tipMoreInfoProvider;

    @Override
    public List<Tip> generate(@Min(MIN_NUMBER_OF_TIPS) @Max(MAX_NUMBER_OF_TIPS) int numberOfItems) {
        List<Tip> result = new ArrayList<>();
        for(int i = 0; i< numberOfItems; i++) {
            result.add(generate());
        }
        return result;
    }

    @Override
    public Tip generate() {
        Tip result = new Tip();
        result.setTitle(tipTitleProvider.get(result));
        result.setContent(tipContentProvider.get(result));
        result.setMoreInfo(tipMoreInfoProvider.get(result));
        return result;
    }
}
