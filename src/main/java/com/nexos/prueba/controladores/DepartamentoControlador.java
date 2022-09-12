package com.nexos.prueba.controladores;

import com.nexos.prueba.Excepciones.DepartamentoNoEncontradoException;
import com.nexos.prueba.modelo.Departamento;
import com.nexos.prueba.repositorios.DepartamentoRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoControlador {

    private final DepartamentoRepositorio departamentoRepositorio;

    public PrestamoController(DepartamentoRepositorio departamentoRepositorio){
        this.departamentoRepositorio = departamentoRepositorio;
    }

    @GetMapping
    public ResponseEntity<List<Departamento>> obtenerTodos() {
        List<Departamento> departamentos = (List<Departamento>) departamentoRepositorio.findAll();
        return new ResponseEntity<>(departamentos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> obtenerPorId(@PathVariable long id) {
        Departamento departamento = departamentoRepositorio.findById(id)
                .orElseThrow(() -> new DepartamentoNoEncontradoException("Departamento no encontrado"));
        return new ResponseEntity<>(departamento, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Departamento> crear(@RequestBody Departamento departamento) {
        try {
            Departamento departamentoCreado = departamentoRepositorio.save(departamento);
            return new ResponseEntity<>(departamentoCreado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(new Exception(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Departamento> actualizar(@RequestBody Departamento departamento) {
        try {
            Departamento departamentoActualizado = departamentoRepositorio.save(departamento);
            return new ResponseEntity<>(departamentoActualizado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Exception(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable long id) {
        try {
            departamentoRepositorio.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Exception(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
