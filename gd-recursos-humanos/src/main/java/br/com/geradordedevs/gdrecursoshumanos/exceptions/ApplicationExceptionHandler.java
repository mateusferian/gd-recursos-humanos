package br.com.geradordedevs.gdrecursoshumanos.exceptions;

import br.com.geradordedevs.gdrecursoshumanos.exceptions.models.ErrorObject;
import br.com.geradordedevs.gdrecursoshumanos.exceptions.models.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorObject> errors = getErrors(ex);
        ErrorResponse errorResponse = getErrorResponse(ex, status, errors);
        log.error("erro de entrada de dados: {}", errorResponse);
        return new ResponseEntity<>(errorResponse, status);
    }

    private ErrorResponse getErrorResponse(MethodArgumentNotValidException ex, HttpStatus status, List<ErrorObject> errors) {
        return new ErrorResponse(
                Instant.now().toEpochMilli(),
                status.value(),
                status.getReasonPhrase(),
                "Requisição possui campos inválidos", errors);
    }

    private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
                .collect(Collectors.toList());
    }

    @ResponseBody
    @ExceptionHandler(TokenException.class)
    ResponseEntity<ErrorResponse> handlerTokenException(TokenException ex){
        return  ResponseEntity.status(ex.getError().getStatusCode())
                .body((new ErrorResponse(
                        Instant.now().toEpochMilli(),
                        ex.getError().getStatusCode(),
                        ex.getError().getCode(),
                        ex.getMessage(), new ArrayList<>())));
    }

    @ResponseBody
    @ExceptionHandler(CargoException.class)
    ResponseEntity<ErrorResponse> handlerCargoException(CargoException ex){
        return  ResponseEntity.status(ex.getError().getStatusCode())
                .body((new ErrorResponse(
                        Instant.now().toEpochMilli(),
                        ex.getError().getStatusCode(),
                        ex.getError().getCode(),
                        ex.getMessage(), new ArrayList<>())));
    }

    @ResponseBody
    @ExceptionHandler(TipoDocumentoException.class)
    ResponseEntity<ErrorResponse> handlerTipoDocumentoException(TipoDocumentoException ex){
        return  ResponseEntity.status(ex.getError().getStatusCode())
                .body((new ErrorResponse(
                        Instant.now().toEpochMilli(),
                        ex.getError().getStatusCode(),
                        ex.getError().getCode(),
                        ex.getMessage(), new ArrayList<>())));
    }

    @ResponseBody
    @ExceptionHandler(DepartamentoException.class)
    ResponseEntity<ErrorResponse> handlerDepartamentoException(DepartamentoException ex){
        return  ResponseEntity.status(ex.getError().getStatusCode())
                .body((new ErrorResponse(
                        Instant.now().toEpochMilli(),
                        ex.getError().getStatusCode(),
                        ex.getError().getCode(),
                        ex.getMessage(), new ArrayList<>())));
    }

    @ResponseBody
    @ExceptionHandler(ColaboradorException.class)
    ResponseEntity<ErrorResponse> handlerColaboradorException(ColaboradorException ex){
        return  ResponseEntity.status(ex.getError().getStatusCode())
                .body((new ErrorResponse(
                        Instant.now().toEpochMilli(),
                        ex.getError().getStatusCode(),
                        ex.getError().getCode(),
                        ex.getMessage(), new ArrayList<>())));
    }

    @ResponseBody
    @ExceptionHandler(AtestadoException.class)
    ResponseEntity<ErrorResponse> handlerAtestadoException(AtestadoException ex){
        return  ResponseEntity.status(ex.getError().getStatusCode())
                .body((new ErrorResponse(
                        Instant.now().toEpochMilli(),
                        ex.getError().getStatusCode(),
                        ex.getError().getCode(),
                        ex.getMessage(), new ArrayList<>())));
    }

    @ResponseBody
    @ExceptionHandler(UsuarioException.class)
    ResponseEntity<ErrorResponse> handlerUsuarioException(UsuarioException ex){
        return  ResponseEntity.status(ex.getError().getStatusCode())
                .body((new ErrorResponse(
                        Instant.now().toEpochMilli(),
                        ex.getError().getStatusCode(),
                        ex.getError().getCode(),
                        ex.getMessage(), new ArrayList<>())));
    }
}
