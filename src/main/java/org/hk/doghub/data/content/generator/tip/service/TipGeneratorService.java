package org.hk.doghub.data.content.generator.tip.service;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.content.generator.tip.model.Tip;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static org.hk.doghub.data.content.generator.tip.service.TipProvider.MAX_NUMBER_OF_TIPS;
import static org.hk.doghub.data.content.generator.tip.service.TipProvider.MIN_NUMBER_OF_TIPS;

@Service
@RequiredArgsConstructor
@Validated
public class TipGeneratorService {

    private final TipProvider tipProvider;

    public List<Tip> generate(@Min(MIN_NUMBER_OF_TIPS) @Max(MAX_NUMBER_OF_TIPS) int numberOfTips) {
        return tipProvider.get(numberOfTips);
    }

    public Tip generate() {
        return tipProvider.get();
    }
}
