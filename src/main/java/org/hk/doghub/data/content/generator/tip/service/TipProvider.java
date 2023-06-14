package org.hk.doghub.data.content.generator.tip.service;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.hk.doghub.data.content.generator.tip.model.Tip;

import java.util.List;

public interface TipProvider {

    int MIN_NUMBER_OF_TIPS = 1;

    int MAX_NUMBER_OF_TIPS = 999;

    List<Tip> get(@Min(MIN_NUMBER_OF_TIPS) @Max(MAX_NUMBER_OF_TIPS) int numberOfItems);

    Tip get();
}
