package org.hk.doghub.data.content.generator.tip.service.provider.domcop.csv;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.tip.model.Tip;
import org.hk.doghub.data.content.generator.tip.service.provider.faker.TipContentProvider;
import org.hk.doghub.data.content.generator.tip.service.provider.faker.TipTitleProvider;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CSVContentProvider {

    private final CsvReader csvReader;

    private final TipTitleProvider tipTitleProvider;

    private final TipContentProvider tipContentProvider;

    public @NotNull Tip get() {
        List<TipLine> lines = csvReader.read();
        return getTip(lines.get(0));
    }

    public List<Tip> get(int numberOfItems) {
        List<TipLine> lines = csvReader.read();
        List<Tip> result =  new ArrayList<>();
        for(int i=0; i<numberOfItems; i++) {
            result.add(getTip(lines.get(i)));
        }
        log.info("{} tips provided", result.size());
        return result;
    }

    private @NotNull Tip getTip(@NotNull TipLine line) {
        Tip result = new Tip();
        result.setTitle(tipTitleProvider.get(result));
        result.setContent(tipContentProvider.get(result));
        result.setMoreInfo(line.getAddress());
        return result;
    }
}
