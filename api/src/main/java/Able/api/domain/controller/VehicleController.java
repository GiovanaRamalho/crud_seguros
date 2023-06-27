package Able.api.domain.controller;


import Able.api.domain.DTO.DataCreateVehicle;
import Able.api.domain.DTO.DataListVehicle;
import Able.api.domain.DTO.DataUpdateVehicle;
import Able.api.domain.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("create")
    @Transactional
    public ResponseEntity create(@RequestBody DataCreateVehicle data, UriComponentsBuilder uriBuilder) {
         return ResponseEntity.ok(vehicleService.create(data, uriBuilder));

    }

    @GetMapping("list")
    public ResponseEntity<List<DataListVehicle>> list() {
        var vehicles = vehicleService.list();

        return ResponseEntity.ok(vehicles.getBody());
    }

    @PutMapping("update")
    @Transactional
    public ResponseEntity update(@RequestBody DataUpdateVehicle data) {
        ResponseEntity updatedVehicle = vehicleService.update(data);
        if (updatedVehicle != null) {
            return ResponseEntity.ok(updatedVehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable String id) {
        boolean deleted = vehicleService.delete(id).hasBody();

            return ResponseEntity.noContent().build();

    }
};
