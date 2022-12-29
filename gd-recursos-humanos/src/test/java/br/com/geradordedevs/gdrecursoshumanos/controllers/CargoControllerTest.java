package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.CargoFacade;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(CargoController.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration")
public class CargoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CargoFacade cargoFacede;

    private final String ROTA_CARGOS = "/cargos";
    private  final  String ROTA_CARGOS_PARAMETRO ="/cargos/1";
    private  final  String ROTA_CARGOS_POPULAR ="/cargos/popular";
    @Test
    public void listarCargosDeveRetornarOk() throws Exception{
        mockMvc.perform(get(ROTA_CARGOS))
                .andExpect(status().isOk());
    }

    @Test
    public void ConsultarCargoExpecificoDeveRetornarOk() throws Exception{
        mockMvc.perform(get(ROTA_CARGOS_PARAMETRO))
                .andExpect(status().isOk());
    }

    @Test
    public void CadastrarCargoDeveRetornarOk() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROTA_CARGOS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(new CargoRequestDTO("mateus")))
        ).andExpect(status().isOk());
    }

    @Test
    public void CadastrarCargoComNomeMinDeveRetornarBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROTA_CARGOS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(new CargoRequestDTO("ma")))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void CadastrarCargoComNomeMaxDeveRetornarBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROTA_CARGOS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(new CargoRequestDTO("mateusmateusmateusmat")))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void CadastrarCargoComNomeEmBrancoDeveRetornarBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROTA_CARGOS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(new CargoRequestDTO("    ")))
        ).andExpect(status().isBadRequest());
    }

    //alterar
    @Test
    public void AlterarCargoDeveRetornarOk() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(ROTA_CARGOS_PARAMETRO)
                 .contentType(MediaType.APPLICATION_JSON)
                 .content(ow.writeValueAsString(new CargoRequestDTO("mateus")))
        ).andExpect(status().isOk());
    }

    @Test
    public void AlterarCargoComNomeMinDeveRetornarBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(ROTA_CARGOS_PARAMETRO)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(new CargoRequestDTO("ma")))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void AlterarCargoComNomeMaxDeveRetornarBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(ROTA_CARGOS_PARAMETRO)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(new CargoRequestDTO("mateusmateusmateusmat")))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void AlterarCargoComNomeEmBrancoDeveRetornarBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(ROTA_CARGOS_PARAMETRO)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(new CargoRequestDTO("    ")))
        ).andExpect(status().isBadRequest());
    }


    @Test
    public void RemoverCargoDeveRetornarOk() throws Exception{
        mockMvc.perform(delete(ROTA_CARGOS_PARAMETRO))
                .andExpect(status().isOk());
    }

    @Test
    public void PopularCargoDeveRetornarOk() throws Exception{
        mockMvc.perform(get(ROTA_CARGOS_POPULAR))
                .andExpect(status().isOk());
    }
}
