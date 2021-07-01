package geo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<CityEntity, Long> {

    List<CityEntity> findByName(String name);

    CityEntity findById(long id);
}