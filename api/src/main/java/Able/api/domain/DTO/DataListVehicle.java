package Able.api.domain.DTO;

import Able.api.domain.entity.Vehicle;

public record DataListVehicle(String id, String marca, String modelo, String placa, String chassi, String fabricacao, Boolean seguro) {

    public DataListVehicle(Vehicle vehicle){
        this(vehicle.getId(), vehicle.getMarca(), vehicle.getModelo(), vehicle.getPlaca(), vehicle.getChassi(), vehicle.getFabricacao(), vehicle.getSeguro());
    }
}
