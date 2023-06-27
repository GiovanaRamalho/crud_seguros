package Able.api.domain.service;

import Able.api.domain.DTO.DataCreateVehicle;
import Able.api.domain.DTO.DataListVehicle;
import Able.api.domain.DTO.DataUpdateVehicle;
import Able.api.domain.entity.Vehicle;
import Able.api.domain.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class VehicleService {


    @Autowired
    private VehicleRepository vehicleRepository;

    private Vehicle vehicle;

    @PostMapping("create")
    @Transactional
    public ResponseEntity create(@RequestBody DataCreateVehicle data, UriComponentsBuilder uriBuilder) {
        var vehicle = new Vehicle(data);

        vehicleRepository.save(vehicle);

        var uri = uriBuilder.path("vehicle/{id}").buildAndExpand(vehicle.getId()).toUri();

        return  ResponseEntity.created(uri).body(new DataListVehicle(vehicle));
    }

    @GetMapping("list")
    public ResponseEntity<List<DataListVehicle>> list() {
        var vehicle = vehicleRepository.findAll().stream().map(DataListVehicle::new).toList();

        return ResponseEntity.ok(vehicle);
    }

    @PutMapping("update")
    @Transactional
    public ResponseEntity update(@RequestBody DataUpdateVehicle data) {
        var optionalVehicle = vehicleRepository.findById(data.id());

        if (optionalVehicle.isPresent()) {
            var vehicle = optionalVehicle.get();
            vehicle.update(data);
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable String id) {
        var vehicle = vehicleRepository.findById(id);

        vehicleRepository.delete(vehicle.get());
        return ResponseEntity.noContent().build();
    }
};
