package com.example.Cto_Residencial.Service;

import com.example.Cto_Residencial.Model.ReservaZona;
import com.example.Cto_Residencial.Repository.ReservaZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReservaZonaService {

    @Autowired
    private ReservaZonaRepository reservaZonaRepository;

    public List<ReservaZona> findAll() {
        return reservaZonaRepository.findAll();
    }

    public Optional<ReservaZona> findById(Long id) {
        return reservaZonaRepository.findById(id);
    }

    public ReservaZona save(ReservaZona reservaZona) {
        return reservaZonaRepository.save(reservaZona);
    }

    public void deleteBy(Long id) {
        reservaZonaRepository.deleteById(id);
    }
}
