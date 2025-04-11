package com.example.Cto_Residencial.Service;

import com.example.Cto_Residencial.Model.ReservaParqueadero;
import com.example.Cto_Residencial.Repository.ReservaParqueaderoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaParqueaderoService {

    @Autowired
    private ReservaParqueaderoRepository reservaParqueaderoRepository;

    public List<ReservaParqueadero> findAll() {
        return reservaParqueaderoRepository.findAll();
    }

    public Optional<ReservaParqueadero> findById(Long id) {
        return reservaParqueaderoRepository.findById(id);
    }

    public ReservaParqueadero save(ReservaParqueadero reservaParqueadero) {
        return reservaParqueaderoRepository.save(reservaParqueadero);
    }

    public void deleteById(Long id) {
        reservaParqueaderoRepository.deleteById(id);
    }

}
