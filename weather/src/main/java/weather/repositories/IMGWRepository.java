package weather.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import weather.models.IMGW;

@Repository
public interface IMGWRepository extends MongoRepository<IMGW, String> {

}
