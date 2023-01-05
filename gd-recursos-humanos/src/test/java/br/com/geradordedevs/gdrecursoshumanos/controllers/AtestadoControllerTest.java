package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AtestadoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.AtestadoFacade;
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

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AtestadoController.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration")
public class AtestadoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AtestadoFacade AtestadoFacade;

    private final String ROUTE_CERTIFICATE = "/atestados";
    private  final  String CERTIFICATE_ROUTE_PARAMETER ="/atestados/1";
    private  final  String COLLABORATOR_POPULAR_ROUTE ="/atestados/popular";

    private  final String CERTIFIED_NAME="covid";
    private  final  Date DATA_CERTIFICATE=new Date(121,10,17);
    private final  Long ID_COLLABORATOR = 1l;

    private  AtestadoRequestDTO returnCorrectAttestation(){
        return  new AtestadoRequestDTO(CERTIFIED_NAME,DATA_CERTIFICATE,ID_COLLABORATOR);
    }

    private  AtestadoRequestDTO returnAttestationWithNameMin(){
        return  new AtestadoRequestDTO("ma",DATA_CERTIFICATE,ID_COLLABORATOR);
    }

    private  AtestadoRequestDTO returnAttestationWithNameMax(){
        return  new AtestadoRequestDTO("mateusmateusmateusmateusmateusmateusmateu",DATA_CERTIFICATE,ID_COLLABORATOR);
    }
    private  AtestadoRequestDTO returnAttestationWithNameNull(){
        return  new AtestadoRequestDTO("    ",DATA_CERTIFICATE,ID_COLLABORATOR);
    }

    private  AtestadoRequestDTO returnAttestationWithDateNull(){
        return  new AtestadoRequestDTO(CERTIFIED_NAME,null,ID_COLLABORATOR);
    }

    private  AtestadoRequestDTO returnAttestationWithIdCollaboratornNought(){
        return  new AtestadoRequestDTO(CERTIFIED_NAME,DATA_CERTIFICATE,0L);
    }

    private  AtestadoRequestDTO returnAttestationWithIdCollaboratornNull(){
        return  new AtestadoRequestDTO(CERTIFIED_NAME,DATA_CERTIFICATE,null);
    }

    @Test
    public void findAllAttestationMustReturnOk() throws Exception{
        mockMvc.perform(get(ROUTE_CERTIFICATE))
                .andExpect(status().isOk());
    }

    @Test
    public void findByIdAttestationMustReturnOk() throws Exception{
        mockMvc.perform(get(CERTIFICATE_ROUTE_PARAMETER))
                .andExpect(status().isOk());
    }

    @Test
    public void saveAttestationMustReturnOk() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_CERTIFICATE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnCorrectAttestation()))
        ).andExpect(status().isOk());
    }

    @Test
    public void saveAttestationWithNameMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_CERTIFICATE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnAttestationWithNameMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveAttestationWithNameMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_CERTIFICATE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnAttestationWithNameMax()))
        ).andExpect(status().isBadRequest());
    }

  @Test
    public void saveAttestationWithNameNullMustReturnBadRequest() throws Exception {
      ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
      mockMvc.perform(post(ROUTE_CERTIFICATE)
              .contentType(MediaType.APPLICATION_JSON)
              .content(ow.writeValueAsString(returnAttestationWithNameNull()))
      ).andExpect(status().isBadRequest());
  }

  //date
  @Test
  public void saveAttestationWithDateNullMustReturnBadRequest() throws Exception {
      ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
      mockMvc.perform(post(ROUTE_CERTIFICATE)
              .contentType(MediaType.APPLICATION_JSON)
              .content(ow.writeValueAsString(returnAttestationWithDateNull()))
      ).andExpect(status().isBadRequest());
  }

  //collaborator
    @Test
    public void saveAttestationWithIdNoughtMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_CERTIFICATE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnAttestationWithIdCollaboratornNought()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveAttestationWithIdNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_CERTIFICATE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString((returnAttestationWithIdCollaboratornNull())))
        ).andExpect(status().isBadRequest());
    }

    //update
    @Test
    public void updateAttestationWithNameMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(CERTIFICATE_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnAttestationWithNameMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void updateAttestationWithNameMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(CERTIFICATE_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnAttestationWithNameMax()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void updateAttestationWithNameNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(CERTIFICATE_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnAttestationWithNameNull()))
        ).andExpect(status().isBadRequest());
    }

    //date
    @Test
    public void updateAttestationWithDateNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(CERTIFICATE_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnAttestationWithDateNull()))
        ).andExpect(status().isBadRequest());
    }

    //collaborator
    @Test
    public void updateAttestationWithIdNoughtMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(CERTIFICATE_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnAttestationWithIdCollaboratornNought()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void updateAttestationWithIdNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(CERTIFICATE_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString((returnAttestationWithIdCollaboratornNull())))
        ).andExpect(status().isBadRequest());
    }

    //delete
    @Test
    public void deleteByIdAttestationMustReturnOk() throws Exception{
        mockMvc.perform(delete(CERTIFICATE_ROUTE_PARAMETER))
                .andExpect(status().isOk());
    }

    //popular
    @Test
    public void popularBanckAttestationMustReturnOk() throws Exception{
        mockMvc.perform(get(COLLABORATOR_POPULAR_ROUTE))
                .andExpect(status().isOk());
    }
}
