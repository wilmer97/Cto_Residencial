package com.example.Cto_Residencial.Repository;

import com.example.Cto_Residencial.Model.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {


}
