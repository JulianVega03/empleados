package com.nexos.prueba.controladores;

import com.nexos.prueba.modelo.Departamento;
import com.nexos.prueba.modelo.Empleado;
import com.nexos.prueba.repositorios.EmpleadoRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoControlador {

    private final EmpleadoRepositorio empleadoRepositorio;

    public EmpleadoControlador(EmpleadoRepositorio empleadoRepositorio){
        this.empleadoRepositorio = empleadoRepositorio;
    }

    @GetMapping
    public ResponseEntity<List<Departamento>> obtenerTodos() {
        List<Empleado> empleados = (List<Empleado>) empleadoRepositorio.findAll();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerPorId(@PathVariable long id) {
        Empleado empleado = empleadoRepositorio.findById(id)
                .orElseThrow(() -> new EmpleadoNoEncontradoException("Empleado no encontrado"));
        return new ResponseEntity<>(empleado, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Empleado> crear(@RequestBody Empleado empleado) {
        try {
            Empleado empleadoCreado = empleadoRepositorio.save(empleado);
            return new ResponseEntity<>(empleadoCreado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(new Exception(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Empleado> actualizar(@RequestBody Empleado empleado) {
        try {
            Empleado empleadoActualizado = empleadoRepositorio.save(empleado);
            return new ResponseEntity<>(empleadoActualizado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Exception(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable long id) {
        try {
            empleadoRepositorio.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Exception(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
