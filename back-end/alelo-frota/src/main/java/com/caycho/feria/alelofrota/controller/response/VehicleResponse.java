package com.caycho.feria.alelofrota.controller.response;

import com.caycho.feria.alelofrota.model.Vehicle;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleResponse {

    private String id;
    private String plate;
    private String model;
    private String manufacturer;
    private String color;
    private boolean status;

    public static VehicleResponse convertResponseToEntity(Vehicle vehicle) {
        return VehicleResponse.builder()
                .id(vehicle.getId())
                .manufacturer(vehicle.getManufacturer())
                .model(vehicle.getModel())
                .plate(vehicle.getPlate())
                .status(vehicle.isStatus())
                .color(vehicle.getColor()).build();
    }

    public static Vehicle convertEntityToResponse(VehicleResponse vehicle) {
        return Vehicle.builder()
                .id(vehicle.getId())
                .manufacturer(vehicle.getManufacturer())
                .model(vehicle.getModel())
                .plate(vehicle.getPlate())
                .status(vehicle.isStatus())
                .color(vehicle.getColor()).build();
    }


}
