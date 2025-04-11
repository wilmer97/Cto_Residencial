package com.example.Cto_Residencial.Repository;

import com.example.Cto_Residencial.Model.Visitantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitantes, Long> {
}
