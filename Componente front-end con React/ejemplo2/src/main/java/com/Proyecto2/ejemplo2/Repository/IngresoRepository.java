package com.Proyecto2.ejemplo2.Repository;

import com.Proyecto2.ejemplo2.Model.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngresoRepository extends JpaRepository<Ingreso, Integer> {
}
