package Able.api.domain.repository;

import Able.api.domain.entity.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository  extends MongoRepository<Vehicle, String> {
}
