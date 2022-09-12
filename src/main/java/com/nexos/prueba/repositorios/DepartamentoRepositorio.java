package com.nexos.prueba.repositorios;

import com.nexos.prueba.modelo.Departamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepositorio extends CrudRepository<Departamento, Long> {

}
