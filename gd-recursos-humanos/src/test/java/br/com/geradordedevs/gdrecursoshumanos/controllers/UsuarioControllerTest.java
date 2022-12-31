package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AutenticacaoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.UsuarioRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.UsuarioFacade;
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
@WebMvcTest(UsuarioController.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration")
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UsuarioFacade usuarioFacede;

    private final String ROUTE_USERS= "/usuarios";
    private  final  String USERS_ROUTE_PARAMETER ="/usuarios/1";

    private  final  String NAME_USERS = "ana";

    private  final  String  EMAIL_USERS = "ana@gmail.com";
    private  final  String PASSWORD_USERS ="12345678";

    public UsuarioRequestDTO returnCorrectUsers() {
        return new UsuarioRequestDTO(NAME_USERS,EMAIL_USERS,PASSWORD_USERS);
    }

    public UsuarioRequestDTO returnUsersNameMin() {
        return new UsuarioRequestDTO("ma",EMAIL_USERS,PASSWORD_USERS);
    }

    public UsuarioRequestDTO returnUsersNameMax() {
        return new UsuarioRequestDTO("mateusmateusmateusmateusmateusmateusmateu",EMAIL_USERS,PASSWORD_USERS);
    }

    public UsuarioRequestDTO returnUsersUsersNameNull() {
        return new UsuarioRequestDTO("    ",EMAIL_USERS,PASSWORD_USERS);
    }

    public UsuarioRequestDTO returnsUsersrWithEmailNull() {
        return new UsuarioRequestDTO(NAME_USERS,null,PASSWORD_USERS);
    }

    public UsuarioRequestDTO returnsUsersWithEmailInvalid() {
        return new UsuarioRequestDTO(NAME_USERS,"carlos.jose",PASSWORD_USERS);
    }

    public UsuarioRequestDTO returnUsersPasswordMin() {
        return new UsuarioRequestDTO(NAME_USERS,EMAIL_USERS,"1234567");
    }

    public UsuarioRequestDTO returnUsersPasswordMax() {
        return new UsuarioRequestDTO(NAME_USERS,EMAIL_USERS,"123456789101112131415");
    }

    public UsuarioRequestDTO returnUsersPasswordNull() {
        return new UsuarioRequestDTO(NAME_USERS,EMAIL_USERS,null);
    }

    @Test
    public void findAllUsersMustReturnOk() throws Exception{
        mockMvc.perform(get(ROUTE_USERS))
                .andExpect(status().isOk());
    }

    @Test
    public void findByIdUsersMustReturnOk() throws Exception{
        mockMvc.perform(get(USERS_ROUTE_PARAMETER))
                .andExpect(status().isOk());
    }

    @Test
    public void saveUsersMustReturnOk() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_USERS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString((returnCorrectUsers())))
        ).andExpect(status().isOk());
    }

    @Test
    public void saveUsersWithNameMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_USERS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnUsersNameMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveUsersWithNameMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_USERS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnUsersNameMax()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveUsersWithNameNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_USERS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnUsersUsersNameNull()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveUsersWithEmailNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_USERS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsUsersrWithEmailNull()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveUsersWithEmailInvalidMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_USERS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsUsersWithEmailInvalid()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveNewUserPasswordMinMustRetornarBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_USERS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnUsersPasswordMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveNewUserPasswordMaxMustRetornarBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_USERS)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ow.writeValueAsString(returnUsersPasswordMax())))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void saveNewUserPasswordNullMustRetornarBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_USERS)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ow.writeValueAsString(returnUsersPasswordNull())))
                .andExpect(status().isBadRequest());
    }

    //update

    @Test
    public void updateUsersMustReturnOk() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(USERS_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString((returnCorrectUsers())))
        ).andExpect(status().isOk());
    }

    @Test
    public void updateUsersWithNameMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(USERS_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnUsersNameMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void updateUsersWithNameMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(USERS_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnUsersNameMax()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void updateUsersWithNameNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(USERS_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnUsersUsersNameNull()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void updateUsersWithEmailNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(USERS_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsUsersrWithEmailNull()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void updateUsersWithEmailInvalidMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(USERS_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsUsersWithEmailInvalid()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void updateNewUserPasswordMinMustRetornarBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(USERS_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnUsersPasswordMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void updateNewUserPasswordMaxMustRetornarBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(USERS_ROUTE_PARAMETER)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ow.writeValueAsString(returnUsersPasswordMax())))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void updateNewUserPasswordNullMustRetornarBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(USERS_ROUTE_PARAMETER)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ow.writeValueAsString(returnUsersPasswordNull())))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deleteByIdDepartamentMustReturnOk() throws Exception{
        mockMvc.perform(delete(USERS_ROUTE_PARAMETER))
                .andExpect(status().isOk());
    }

}
