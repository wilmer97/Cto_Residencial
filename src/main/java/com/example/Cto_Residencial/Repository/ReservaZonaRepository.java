package com.example.Cto_Residencial.Repository;

import com.example.Cto_Residencial.Model.ReservaZona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaZonaRepository extends JpaRepository<ReservaZona, Long> {
}
