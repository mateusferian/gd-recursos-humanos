package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AutenticacaoRequestDTO;
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

    private final String ROTA_AUTENTICACAO = "/autenticacoes";

    @Test
    public void gerandoTokenJWTDeveRetornarOk() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROTA_AUTENTICACAO)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(new AutenticacaoRequestDTO("mateus.jose@gmail.com", "12345678901234567890")))
        ).andExpect(status().isOk());
    }

    @Test
    public void gerandoTokenJWTComEmailInvalidoDeveRetornarBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROTA_AUTENTICACAO)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(new AutenticacaoRequestDTO("mateus.jose", "12345678901234567890")))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void gerandoTokenJWTComEmailVazioDeveRetornarBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROTA_AUTENTICACAO)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(new AutenticacaoRequestDTO("","12345678901234567890")))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void gerandoTokenJWTComSenhaInvalidoDeveRetornarBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROTA_AUTENTICACAO)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(new AutenticacaoRequestDTO("mateus.jose@gmail.com", "")))
        ).andExpect(status().isBadRequest());
    }
}
