package br.edu.famper.cadprojetos.controller;

import br.edu.famper.cadprojetos.model.CadProjetos;
import br.edu.famper.cadprojetos.service.CadProjetosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/projetos")
public class CadProjetosController {
    @Autowired
    private CadProjetosService cadProjetosService;

    @GetMapping
    public ResponseEntity<List<CadProjetos>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cadProjetosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CadProjetos>> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(cadProjetosService.findById(id));
    }
    @PostMapping
    public ResponseEntity<CadProjetos> create(@RequestBody CadProjetos cadProjetos){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cadProjetosService.salvar(cadProjetos));
    }
    @PutMapping
    public ResponseEntity<CadProjetos> update(@RequestBody CadProjetos cadProjetos){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(cadProjetosService.update(cadProjetos));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        cadProjetosService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
