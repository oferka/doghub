package org.hk.doghub.data.content.generator.tip.service.provider.domcop.csv;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.hk.doghub.data.content.generator.tip.model.Tip;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CSVContentProvider {

    private final CsvReader csvReader;

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
        result.setTitle(new Faker().book().title());
        result.setContent(new Faker().book().genre());
        result.setMoreInfo(line.getAddress());
        return result;
    }
}
