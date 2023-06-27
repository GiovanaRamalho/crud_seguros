package Able.api.domain.DTO;

public record DataUpdateVehicle(
        String id,
        String marca,
        String modelo,
        String placa,
        String chassi,
        String Fabricacao,
        String seguro) {
}
