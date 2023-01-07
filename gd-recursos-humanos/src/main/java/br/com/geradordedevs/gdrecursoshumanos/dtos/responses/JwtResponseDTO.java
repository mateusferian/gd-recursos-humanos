package br.com.geradordedevs.gdrecursoshumanos.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponseDTO {

    private String email;
    private Date dataExpiracao;

}
