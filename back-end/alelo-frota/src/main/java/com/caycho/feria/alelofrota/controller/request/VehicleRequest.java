package com.caycho.feria.alelofrota.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class VehicleRequest {

    @NotBlank
    private String plate;
    @NotBlank
    private String model;
    @NotBlank
    private String manufacturer;
    @NotBlank
    private String color;
    private boolean status;

}
