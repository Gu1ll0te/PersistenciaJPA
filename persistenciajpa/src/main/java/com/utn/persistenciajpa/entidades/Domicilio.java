package com.utn.persistenciajpa.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Domicilio")

public class Domicilio extends BaseEntidad {

    private String calle;
    private String numero;
    private String localidad;

}
