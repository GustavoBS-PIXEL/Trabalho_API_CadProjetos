package br.edu.famper.cadprojetos.repository;

import br.edu.famper.cadprojetos.model.CadProjetos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadProjetosRepository extends JpaRepository<CadProjetos, Long> {
}
