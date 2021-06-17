package com.caycho.feria.alelofrota.service;

import com.caycho.feria.alelofrota.controller.request.VehicleRequest;
import com.caycho.feria.alelofrota.model.Vehicle;
import com.caycho.feria.alelofrota.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public Vehicle addVehicle(VehicleRequest request) {
        return repository.save(Vehicle.builder()
                .color(request.getColor())
                .manufacturer(request.getManufacturer())
                .model(request.getModel())
                .status(request.isStatus())
                .plate(request.getPlate()).build());
    }

    public List<Vehicle> listAll() {
        return repository.findAll();
    }

    public Optional<Vehicle> findById(String id) {
        return repository.findById(id);
    }

    public void delete(Vehicle vehicle) {
        repository.delete(vehicle);
    }

    public void update(Vehicle vehicle) {
        repository.save(vehicle);
    }
}
