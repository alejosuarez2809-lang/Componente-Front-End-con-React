package com.Proyecto2.ejemplo2.Repository;

import com.Proyecto2.ejemplo2.Model.Contabilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContabilidadRepository extends JpaRepository<Contabilidad, Integer> {
}
