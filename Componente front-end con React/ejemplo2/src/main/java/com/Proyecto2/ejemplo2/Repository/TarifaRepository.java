package com.Proyecto2.ejemplo2.Repository;

import com.Proyecto2.ejemplo2.Model.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Integer> {
}
