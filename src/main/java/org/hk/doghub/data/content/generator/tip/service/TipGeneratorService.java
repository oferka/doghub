package org.hk.doghub.data.content.generator.tip.service;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.content.generator.tip.model.Tip;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static org.hk.doghub.data.content.generator.EntityProvider.MAX_NUMBER_OF_ITEMS;
import static org.hk.doghub.data.content.generator.EntityProvider.MIN_NUMBER_OF_ITEMS;

@Service
@RequiredArgsConstructor
@Validated
public class TipGeneratorService {

    private final TipProvider tipProvider;

    public List<Tip> generate(@Min(MIN_NUMBER_OF_ITEMS) @Max(MAX_NUMBER_OF_ITEMS) int numberOfTips) {
        return tipProvider.get(numberOfTips);
    }

    public Tip generate() {
        return tipProvider.get();
    }
}
