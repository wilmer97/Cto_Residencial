package com.example.Cto_Residencial.Service;

import com.example.Cto_Residencial.Model.ZonaSocial;
import com.example.Cto_Residencial.Repository.ZonaSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ZonaSocialService {

    @Autowired
    private ZonaSocialRepository zonaSocialRepository;

    public List<ZonaSocial> findAll() {
        return zonaSocialRepository.findAll();
    }

    public Optional<ZonaSocial> findById(Long id) {
        return zonaSocialRepository.findById(id);
    }

    public ZonaSocial save(ZonaSocial zonaSocial) {
        return zonaSocialRepository.save(zonaSocial);
    }

    public void deleteByid(Long id) {
        zonaSocialRepository.deleteById(id);
    }

}
