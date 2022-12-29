package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
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
@WebMvcTest(TipoDocumentoController.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration")
public class TipoDocumentoControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private br.com.geradordedevs.gdrecursoshumanos.facades.TipoDocumentoFacade TipoDocumentoFacade;

    private final String ROUTE_DOCUMENT_TYPE = "/tipo-de-documentos";
    private  final  String DOCUMENT_TYPE_ROUTE_PARAMETER ="/tipo-de-documentos/1";
    private  final  String DOCUMENT_TYPE_POPULAR_ROUTE ="/tipo-de-documentos/popular";

    private final String NAME_DOCUMENT_TYPE ="cpf";

    public TipoDocumentoRequestDTO returnCorrectDocumentType() {
        return new TipoDocumentoRequestDTO(NAME_DOCUMENT_TYPE);
    }

    public TipoDocumentoRequestDTO returnDocumentTypeWithNameMin() {
        return new TipoDocumentoRequestDTO("m");
    }

    public TipoDocumentoRequestDTO returnDocumentTypeWithNameMax() {
        return new TipoDocumentoRequestDTO("mateusm");
    }

    public TipoDocumentoRequestDTO returnDocumentTypeWithNameNull() {
        return new TipoDocumentoRequestDTO("   ");
    }

    @Test
    public void findAllDocumentTypeMustReturnOk() throws Exception{
        mockMvc.perform(get(ROUTE_DOCUMENT_TYPE))
                .andExpect(status().isOk());
    }

    @Test
    public void findByIdDocumentTypeMustReturnOk() throws Exception{
        mockMvc.perform(get(DOCUMENT_TYPE_ROUTE_PARAMETER))
                .andExpect(status().isOk());
    }

    @Test
    public void saveDocumentTypeMustReturnOk() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_DOCUMENT_TYPE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnCorrectDocumentType()))
        ).andExpect(status().isOk());
    }

    @Test
    public void saveDocumentTypeWithNameMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_DOCUMENT_TYPE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnDocumentTypeWithNameMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveDocumentTypeWithNameMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_DOCUMENT_TYPE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnDocumentTypeWithNameMax()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveDocumentTypeWithNameNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_DOCUMENT_TYPE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnDocumentTypeWithNameNull()))
        ).andExpect(status().isBadRequest());
    }

    //update
    @Test
    public void updateDocumentTypeMustReturnOk() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(DOCUMENT_TYPE_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnCorrectDocumentType()))
        ).andExpect(status().isOk());
    }

    @Test
    public void updateDocumentTypeWithNameMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(DOCUMENT_TYPE_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnDocumentTypeWithNameMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void updateDocumentTypeWithNameMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(DOCUMENT_TYPE_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnDocumentTypeWithNameMax()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void updateDocumentTypeWithNameNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(DOCUMENT_TYPE_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnDocumentTypeWithNameNull()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void deleteByIdDocumentTypeMustReturnOk() throws Exception{
        mockMvc.perform(delete(DOCUMENT_TYPE_ROUTE_PARAMETER))
                .andExpect(status().isOk());
    }

    @Test
    public void popularBanckDocumentTypeMustReturnOk() throws Exception{
        mockMvc.perform(get(DOCUMENT_TYPE_POPULAR_ROUTE))
                .andExpect(status().isOk());
    }
}
