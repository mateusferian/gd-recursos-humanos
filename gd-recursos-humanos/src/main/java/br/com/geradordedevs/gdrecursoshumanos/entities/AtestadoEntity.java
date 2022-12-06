package br.com.geradordedevs.gdrecursoshumanos.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtestadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Date data;
    @ManyToOne
    private ColaboradorEntity colaborador;

    public AtestadoEntity(String nome, Date data, ColaboradorEntity colaborador) {
        this.nome = nome;
        this.data = data;
        this.colaborador = colaborador;
    }
}



