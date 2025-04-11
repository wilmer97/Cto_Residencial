package com.example.Cto_Residencial.Controller;

import com.example.Cto_Residencial.Model.Visitantes;
import com.example.Cto_Residencial.Service.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/visitantes")
public class VisitanteController {

    @Autowired
    private VisitanteService visitanteService;

    @GetMapping
    public List<Visitantes> getAllVisitantes() {
        return visitanteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitantes> getVisitanteById(@PathVariable Long id) {
        Optional<Visitantes> visitantes = visitanteService.findById(id);
        return visitantes.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}")
    public Visitantes createVisitante(@RequestBody Visitantes visitantes) {
        return visitanteService.save(visitantes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Visitantes> updateVisitantes(@PathVariable Long id, @RequestBody Visitantes visitantesDetalles) {
        Optional<Visitantes> visitantes = visitanteService.findById(id);
        if (visitantes.isPresent()) {
            Visitantes updateVisitantes = visitantes.get();
            updateVisitantes.setNombre(visitantesDetalles.getNombre());
            updateVisitantes.setCedula(visitantesDetalles.getCedula());
            updateVisitantes.setTelefono(visitantesDetalles.getTelefono());
            updateVisitantes.setCorreo(visitantesDetalles.getCorreo());
            updateVisitantes.setPropietario(visitantesDetalles.getPropietario());

            return ResponseEntity.ok(visitanteService.save(updateVisitantes));

        } else {

            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisitante(@PathVariable Long id){
        if (visitanteService.findById(id).isPresent()){
            visitanteService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
