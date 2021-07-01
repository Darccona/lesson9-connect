package geo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegionRepository extends CrudRepository<RegionEntity, Long> {

    List<RegionEntity> findByName(String name);

    RegionEntity findById(long id);
}