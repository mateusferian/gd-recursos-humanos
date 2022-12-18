package br.com.geradordedevs.gdrecursoshumanos.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtestadoRequestDTO {

    private String nome;
    private Date data;
    private Long colaboradorId;
}
