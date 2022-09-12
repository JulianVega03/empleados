package com.nexos.prueba.modelo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "documento_tipo", nullable = false, updatable = false)
    @NotBlank(message = "Tipo de documento es requerido")
    private TipoDocumento documento_tipo;

    @Column(name = "documento_numero", nullable = false, updatable = false)
    @NotBlank(message = "Número de documento es requerido")
    private String documento_numero;

    @Column(name = "nombres", nullable = false, updatable = false)
    @NotBlank(message = "Nombre es requerido")
    private String nombres;

    @Column(name = "apellidos", nullable = false, updatable = false)
    @NotBlank(message = "Apellido es requerido")
    private String apellidos;

    @Column(name = "departamentos_id", nullable = false, updatable = false)
    @NotBlank(message = "Departamento es requerido")
    private Departamento departamentos_id;

    @Column(name = "ciudad", nullable = false, updatable = false)
    @NotBlank(message = "Ciudad es requerido")
    private String ciudad;

    @Column(name = "direccion", nullable = false, updatable = false)
    @NotBlank(message = "Dirección es requerido")
    private String direccion;

    @Column(name = "correo", nullable = false, updatable = false)
    @NotBlank(message = "Correo es requerido")
    private String correo;

    @Column(name = "telefono", nullable = false, updatable = false)
    @NotBlank(message = "Teléfono es requerido")
    private String telefono;

    @Column(name = "fecha_hora_crea", nullable = false, updatable = false)
    @NotNull
    private LocalDateTime fecha_hora_crea;

    @Column(name = "fecha_hora_modifica", nullable = false, updatable = false)
    @NotNull
    private LocalDateTime fecha_hora_modifica;

}
