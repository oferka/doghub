package org.hk.doghub.data.service.dog;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.content.generator.dog.dogapi.DogApiClient;
import org.hk.doghub.data.content.generator.dog.dogapi.DogApiListAllBreedsResponse;
import org.hk.doghub.data.repository.EntityRepository;
import org.hk.doghub.data.repository.dog.DogHubDogRepository;
import org.hk.doghub.data.service.AbstractEntityService;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

import static java.text.MessageFormat.format;
import static org.hk.doghub.model.NamedEntity.NAME_MAX_LENGTH;

@Service
@RequiredArgsConstructor
@Validated
public class DogHubDogService extends AbstractEntityService<DogHubDog> {

    private final DogHubDogRepository repository;

    private final DogApiClient dogApiClient;

    @Override
    protected EntityRepository<DogHubDog> getEntityRepository() {
        return repository;
    }

    @Override
    public boolean exists(@NotNull @Valid DogHubDog entity) {
        return existsByIdAndCreatedBy(entity.getId(), entity.getCreatedBy());
    }

    public Optional<DogHubDog> findPrevious(@NotNull Long id) {
        return repository.findTop1ByIdLessThanOrderByIdDesc(id);
    }

    public Optional<DogHubDog> findNext(@NotNull Long id) {
        return repository.findTop1ByIdGreaterThanOrderById(id);
    }

    public List<DogHubDog> findByCreatedBy(@NotNull @Valid DogHubUser user) {
        return repository.findByCreatedBy(user);
    }

    public long countByCreatedBy(@NotNull @Valid DogHubUser user) {
        return repository.countByCreatedBy(user);
    }

    public boolean existsByIdAndCreatedBy(@NotNull Long id, @NotNull @Valid DogHubUser user) {
        return repository.existsByIdAndCreatedBy(id, user);
    }

    public boolean existsByNameAndCreatedBy(@NotNull @Size(max = NAME_MAX_LENGTH) String name, @NotNull @Valid DogHubUser user) {
        return repository.existsByNameAndCreatedBy(name, user);
    }

    public Optional<DogHubDog> findPreviousByCreatedBy(@NotNull Long id, @NotNull @Valid DogHubUser user) {
        return repository.findTop1ByIdLessThanAndCreatedByOrderByIdDesc(id, user);
    }

    public Optional<DogHubDog> findNextByCreatedBy(@NotNull Long id, @NotNull @Valid DogHubUser user) {
        return repository.findTop1ByIdGreaterThanAndCreatedByOrderById(id, user);
    }

    public @NotNull List<String> getAllBreeds() throws URISyntaxException, IOException {
        List<String> result = new ArrayList<>();
        DogApiListAllBreedsResponse dogApiListAllBreedsResponse = dogApiClient.getAllBreeds();
        Map<String, List<String>> breedsMap = dogApiListAllBreedsResponse.getMessage();
        Set<String> breeds = breedsMap.keySet();
        for (String breed : breeds) {
            result.add(breed);
            List<String> subBreeds = breedsMap.get(breed);
            for(String subBreed : subBreeds) {
                result.add(format("{0}-{1}", breed, subBreed));
            }
        }
        return result;
    }
}
