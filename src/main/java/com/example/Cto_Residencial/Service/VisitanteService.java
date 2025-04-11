package com.example.Cto_Residencial.Service;

import com.example.Cto_Residencial.Model.Visitantes;
import com.example.Cto_Residencial.Repository.VisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class VisitanteService {

    @Autowired
    private VisitanteRepository visitanteRepository;

    public List<Visitantes> findAll() {
        return visitanteRepository.findAll();
    }

    public Optional<Visitantes> findById(Long id) {
        return visitanteRepository.findById(id);
    }

    public Visitantes save(Visitantes visitantes) {
        return visitanteRepository.save(visitantes);
    }

    public void deleteById(Long id) {
        visitanteRepository.deleteById(id);
    }
}
