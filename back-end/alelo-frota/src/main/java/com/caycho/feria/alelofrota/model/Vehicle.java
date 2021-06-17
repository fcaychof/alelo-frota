package com.caycho.feria.alelofrota.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "vehicle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicle {

    @Id
    private String id;
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
