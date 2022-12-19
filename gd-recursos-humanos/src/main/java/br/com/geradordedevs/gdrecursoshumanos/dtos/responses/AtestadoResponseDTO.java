package br.com.geradordedevs.gdrecursoshumanos.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtestadoResponseDTO {

    private Long id;
    private String nome;
    private Date data;
    private Long colaboradorId;
}
