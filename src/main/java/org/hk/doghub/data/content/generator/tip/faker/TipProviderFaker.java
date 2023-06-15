package org.hk.doghub.data.content.generator.tip.faker;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.tip.Tip;
import org.hk.doghub.data.content.generator.tip.TipProvider;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Slf4j
@RequiredArgsConstructor
@Validated
public class TipProviderFaker implements TipProvider {

    private final TipTitleProvider tipTitleProvider;

    private final TipContentProvider tipContentProvider;

    private final TipMoreInfoProvider tipMoreInfoProvider;

    @Override
    public @NotNull List<Tip> get(@Min(MIN_NUMBER_OF_ITEMS) @Max(MAX_NUMBER_OF_ITEMS) int numberOfItems) {
        return IntStream.range(0, numberOfItems).mapToObj(x -> get()).collect(Collectors.toList());
    }

    @Override
    public @NotNull Tip get() {
        Tip result = new Tip();
        result.setTitle(tipTitleProvider.get(result));
        result.setContent(tipContentProvider.get(result));
        result.setMoreInfo(tipMoreInfoProvider.get(result));
        return result;
    }
}
