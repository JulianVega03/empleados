package com.nexos.prueba.modelo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "codigo", nullable = false, updatable = false)
    @NotBlank(message = "Código es requerido")
    private String codigo;

    @Column(name = "nombre", nullable = false, updatable = false)
    @NotBlank(message = "Nombre es requerido")
    private String nombre;

    @Column(name = "fecha_hora_crea", nullable = false, updatable = false)
    @NotNull
    private LocalDateTime fecha_hora_crea;

    @Column(name = "fecha_hora_modifica", nullable = false, updatable = false)
    @NotNull
    private LocalDateTime fecha_hora_modifica;

}
