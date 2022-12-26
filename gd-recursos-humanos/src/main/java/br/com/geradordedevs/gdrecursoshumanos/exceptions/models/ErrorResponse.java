package br.com.geradordedevs.gdrecursoshumanos.exceptions.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private  Long timestamp;
    private  String status;
    private  int code;
    private String message;
    private List<ErrorObject> erros;
}
