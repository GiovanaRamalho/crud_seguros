package Able.api.domain.entity;

import Able.api.domain.DTO.DataCreateVehicle;
import Able.api.domain.DTO.DataUpdateVehicle;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vehicle {

    @Id
    private String id;
    String marca;
    String modelo;
    String placa;
    String chassi;
    String fabricacao;
    Boolean seguro;

    public Vehicle (DataCreateVehicle data){
        this.marca = data.marca();
        this.modelo = data.modelo();
        this.placa = data.placa();
        this.chassi = data.chassi();
        this.fabricacao = data.fabricacao();
        this.seguro = data.seguro();
    }

    public void update (DataUpdateVehicle data){
        this.marca = data.marca();
        this.modelo = data.modelo();
        this.placa = data.placa();
        this.chassi = data.chassi();
        this.fabricacao = data.Fabricacao();
        this.seguro = Boolean.valueOf(data.seguro());
    }

}
