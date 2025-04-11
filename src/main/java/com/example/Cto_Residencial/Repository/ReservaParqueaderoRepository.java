package com.example.Cto_Residencial.Repository;

import com.example.Cto_Residencial.Model.ReservaParqueadero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaParqueaderoRepository extends JpaRepository<ReservaParqueadero, Long> {
}
