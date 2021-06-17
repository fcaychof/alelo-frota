package com.caycho.feria.alelofrota.repository;

import com.caycho.feria.alelofrota.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {
}
