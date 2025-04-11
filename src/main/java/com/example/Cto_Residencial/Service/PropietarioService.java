package com.example.Cto_Residencial.Service;

import com.example.Cto_Residencial.Model.Propietario;
import com.example.Cto_Residencial.Repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PropietarioService {

    @Autowired
    private PropietarioRepository propietarioRepository;

    public List<Propietario> findAll() {
        return propietarioRepository.findAll();
    }

    public Optional<Propietario> findById(Long id) {
        return propietarioRepository.findById(id);
    }

    public Propietario save(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    public void deleteById(Long id) {
        propietarioRepository.deleteById(id);
    }
}
