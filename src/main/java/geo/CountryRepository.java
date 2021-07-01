package geo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<CountryEntity, Long> {

    List<CountryEntity> findByName(String name);

    CountryEntity findById(long id);
}