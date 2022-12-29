package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AutenticacaoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.TokenFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AutenticacaoController.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration")
public class AutenticacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TokenFacade tokenFacede;

    private final String ROUTE_AUTHENTICATION = "/autenticacoes";

    private  final String EMAIL_AUTHENTICATION = "mateus.jose@gmail.com";

    private  final String PASSWORD_AUTHENTICATION = "123456789";

    public AutenticacaoRequestDTO returnCorrectAuthentication() {
        return new AutenticacaoRequestDTO(EMAIL_AUTHENTICATION,PASSWORD_AUTHENTICATION);
    }

    public AutenticacaoRequestDTO returnsAuthenticationWithEmailNull() {
        return new AutenticacaoRequestDTO(null, PASSWORD_AUTHENTICATION);
    }

    public AutenticacaoRequestDTO returnAuthenticationWithEmailInvalid() {
        return new AutenticacaoRequestDTO("mateus.jose",PASSWORD_AUTHENTICATION);
    }

    public AutenticacaoRequestDTO returnAuthenticationWithPassawordInvalid() {
        return new AutenticacaoRequestDTO(EMAIL_AUTHENTICATION," ");
    }

    @Test
    public void generatingTokenJWTDeveRetornarOk() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_AUTHENTICATION)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnCorrectAuthentication()))
        ).andExpect(status().isOk());
    }

    @Test
    public void generatingTokenJWTWithInvalidEmailMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_AUTHENTICATION)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnAuthenticationWithEmailInvalid()))
        ).andExpect(status().isBadRequest());
    }
    @Test
    public void generatingTokenJWTWithEmailEmptyMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_AUTHENTICATION)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnAuthenticationWithEmailInvalid()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void generatingTokenJWTWithInvalidPasswordMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_AUTHENTICATION)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnAuthenticationWithPassawordInvalid()))
        ).andExpect(status().isBadRequest());
    }
}
