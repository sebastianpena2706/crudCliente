package com.vass.entities;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Table(name = "CLIENTE")
@Entity
/**
 * Representacion de tabla base datos
 */
public class ClienteEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;


    @Column(name = "NOMBRES")
    private String nombres;


    @Column(name = "APELLIDOS")
    private String apellidos;


    @Column(name = "CEDULA")
    private String cedula;


    @Column(name = "EMAIL")
    private String email;


    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;

}
