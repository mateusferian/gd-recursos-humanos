package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
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
    private CargoFacade cargoFacade;

    private final String ROUTE_OFIICE = "/cargos";
    private  final  String DOCUMENT_OFFICE_PARAMETER ="/cargos/1";
    private  final  String OFFICE_POPULAR_ROUTE ="/cargos/popular";

    private final String NAME_OFFICE ="adiministrador";

    public TipoDocumentoRequestDTO returnCorrectOfiice() {
        return new TipoDocumentoRequestDTO(NAME_OFFICE);
    }

    public TipoDocumentoRequestDTO returnOfiiceWithNameMin() {
        return new TipoDocumentoRequestDTO("ma");
    }

    public TipoDocumentoRequestDTO returnOfiiceWithNameMax() {
        return new TipoDocumentoRequestDTO("mateusmateusmateusmat");
    }

    public TipoDocumentoRequestDTO returnoOfiiceWithNameNull() {
        return new TipoDocumentoRequestDTO("    ");
    }

    @Test
    public void findAllOfiiceMustReturnOk() throws Exception{
        mockMvc.perform(get(ROUTE_OFIICE))
                .andExpect(status().isOk());
    }

    @Test
    public void findByIdOfiiceMustReturnOk() throws Exception{
        mockMvc.perform(get(DOCUMENT_OFFICE_PARAMETER))
                .andExpect(status().isOk());
    }

    @Test
    public void saveOfiiceMustReturnOk() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_OFIICE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnCorrectOfiice()))
        ).andExpect(status().isOk());
    }

    @Test
    public void saveOfiiceWithNameMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_OFIICE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnOfiiceWithNameMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveOfiiceWithNameMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_OFIICE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnOfiiceWithNameMax()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveOfiiceWithNameNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_OFIICE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnoOfiiceWithNameNull()))
        ).andExpect(status().isBadRequest());
    }

    //update
    @Test
    public void updateOfiiceMustReturnOk() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(DOCUMENT_OFFICE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnCorrectOfiice()))
        ).andExpect(status().isOk());
    }

    @Test
    public void updateOfiiceWithNameMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(DOCUMENT_OFFICE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnOfiiceWithNameMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void updateOfiiceWithNameMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(DOCUMENT_OFFICE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnOfiiceWithNameMax()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void updateOfiiceWithNameNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(DOCUMENT_OFFICE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnoOfiiceWithNameNull()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void deleteByIdOfiiceMustReturnOk() throws Exception{
        mockMvc.perform(delete(DOCUMENT_OFFICE_PARAMETER))
                .andExpect(status().isOk());
    }

    @Test
    public void popularBanckOfiiceMustReturnOk() throws Exception{
        mockMvc.perform(get(OFFICE_POPULAR_ROUTE))
                .andExpect(status().isOk());
    }
}
