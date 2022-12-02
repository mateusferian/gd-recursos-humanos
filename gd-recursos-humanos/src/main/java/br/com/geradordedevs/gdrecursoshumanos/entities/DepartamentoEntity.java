package br.com.geradordedevs.gdrecursoshumanos.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private  String nome;

    public DepartamentoEntity(Long id) {
        this.id = id;
    }

    public DepartamentoEntity(String nome) {
        this.nome = nome;
    }
}
