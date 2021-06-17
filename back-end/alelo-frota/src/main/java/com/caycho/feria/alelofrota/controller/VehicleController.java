package com.caycho.feria.alelofrota.controller;

import com.caycho.feria.alelofrota.controller.request.VehicleRequest;
import com.caycho.feria.alelofrota.controller.response.VehicleResponse;
import com.caycho.feria.alelofrota.model.Vehicle;
import com.caycho.feria.alelofrota.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicle")
@AllArgsConstructor
public class VehicleController {

    private VehicleService service;

    @PostMapping
    public ResponseEntity add(@Valid @RequestBody VehicleRequest request) {
        Vehicle vehicle = service.addVehicle(request);
        return ResponseEntity.ok(VehicleResponse.convertResponseToEntity(vehicle));
    }

    @GetMapping
    public ResponseEntity listAll() {
        List<Vehicle> vehicles = service.listAll();
        List<VehicleResponse> vehicleResponseList = new ArrayList<>();
        vehicles.forEach(e -> vehicleResponseList.add(VehicleResponse.convertResponseToEntity(e)));
        return ResponseEntity.ok(vehicleResponseList);
    }


    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable(name = "id") String id) {
        Optional<Vehicle> byId = service.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId.get());
        }
        return ResponseEntity.ok("Registro não encontrado");
    }

    @PutMapping
    public ResponseEntity update(@Valid @RequestBody VehicleResponse request) {
        Optional<Vehicle> byId = service.findById(request.getId());
        if (byId.isPresent()) {
            service.update(VehicleResponse.convertEntityToResponse(request));
            return ResponseEntity.ok("Registro atualizado com sucesso");
        }
        return ResponseEntity.ok("Registro não encontrado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(name = "id") String id) {
        if (service.findById(id).isPresent()) {
            service.delete(service.findById(id).get());
            return ResponseEntity.ok("Registro eliminado com sucesso");
        }
        return ResponseEntity.ok("Registro não encontrado");
    }

}
