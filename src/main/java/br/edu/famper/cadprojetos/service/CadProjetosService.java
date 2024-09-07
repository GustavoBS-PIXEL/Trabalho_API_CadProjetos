package br.edu.famper.cadprojetos.service;

import br.edu.famper.cadprojetos.model.CadProjetos;
import br.edu.famper.cadprojetos.repository.CadProjetosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadProjetosService {

    @Autowired
    private CadProjetosRepository cadProjetosRepository;

    public CadProjetos salvar(CadProjetos cadProjetos) {
        return cadProjetosRepository.save(cadProjetos);
    }

    public List<CadProjetos> findAll(){
        return cadProjetosRepository.findAll();
    }

    public Optional<CadProjetos> findById(Long id) {
        return cadProjetosRepository.findById(id);
    }


    public CadProjetos update(CadProjetos cadProjetos) {
        CadProjetos salvo = cadProjetosRepository.findById(cadProjetos.getCodigo()).orElseThrow(() -> new RuntimeException("Projeto não encontrado!"));
        salvo.setNome(cadProjetos.getNome());
        salvo.setDescricao(cadProjetos.getDescricao());
        salvo.setResponsavel(cadProjetos.getResponsavel());
        salvo.setParticipantes(cadProjetos.getParticipantes());
        salvo.setDatainicio(cadProjetos.getDatainicio());
        salvo.setDatafim(cadProjetos.getDatafim());
        return cadProjetosRepository.save(salvo);
    }

    public void delete(Long id) {
        cadProjetosRepository.deleteById(id);
    }
}
