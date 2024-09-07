package br.edu.famper.cadprojetos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "tbl_projetos")
@Data

public class CadProjetos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "projeto_id")
    private Long codigo;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "descricao", length = 250)
    private String descricao;

    @Column(name = "responsavel", length = 100)
    private String responsavel;

    @Column(name = "participantes", length = 200)
    private String participantes;

    @Column(name = "data_inicio")
    private Date datainicio;

    @Column(name = "data_fim")
    private Date datafim;
}
