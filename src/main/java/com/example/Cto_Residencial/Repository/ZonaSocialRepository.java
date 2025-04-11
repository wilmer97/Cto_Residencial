package com.example.Cto_Residencial.Repository;

import com.example.Cto_Residencial.Model.ZonaSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaSocialRepository extends JpaRepository<ZonaSocial, Long> {
}
