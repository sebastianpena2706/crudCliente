package com.vass.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

/**
 * Formato de cumunicacion del cliente externo
  */
public class ClienteDto {

    private Integer id;

    private String nombres;

    private String apellidos;

    private String cedula;

    private String email;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date fechaNacimiento;
}
