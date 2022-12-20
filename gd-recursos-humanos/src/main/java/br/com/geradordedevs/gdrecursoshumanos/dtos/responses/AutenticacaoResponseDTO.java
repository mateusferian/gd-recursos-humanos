package br.com.geradordedevs.gdrecursoshumanos.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutenticacaoResponseDTO {
    private  String token;
}
