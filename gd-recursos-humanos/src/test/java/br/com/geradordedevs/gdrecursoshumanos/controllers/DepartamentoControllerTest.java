package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AtestadoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.DepartamentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.DepartamentoFacade;
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
@WebMvcTest(DepartamentoController.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration")
public class DepartamentoControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartamentoFacade departamentoFacade;

    private final String ROUTE_DEPARTMENT = "/departamentos";
    private  final  String DEPARTMENT_ROUTE_PARAMETER ="/departamentos/1";
    private  final  String DEPARTMENT_POPULAR_ROUTE ="/departamentos/popular";

    private final String NAME_DEPARTMENT ="covid";

    public DepartamentoRequestDTO returnCorrectDepartment() {
        return new DepartamentoRequestDTO(NAME_DEPARTMENT);
    }

    public DepartamentoRequestDTO returnDepartamentWithNameMin() {
        return new DepartamentoRequestDTO("ma");
    }

    public DepartamentoRequestDTO returnDepartamentWithNameMax() {
        return new DepartamentoRequestDTO("mateusmateusmateusmateusmateusm");
    }

    public DepartamentoRequestDTO returnDepartamentWithNameNull() {
        return new DepartamentoRequestDTO("    ");
    }

    @Test
    public void findAllDepartamentMustReturnOk() throws Exception{
        mockMvc.perform(get(ROUTE_DEPARTMENT))
                .andExpect(status().isOk());
    }

    @Test
    public void findByIdDepartamentMustReturnOk() throws Exception{
        mockMvc.perform(get(DEPARTMENT_ROUTE_PARAMETER))
                .andExpect(status().isOk());
    }

    @Test
    public void saveDepartamentMustReturnOk() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_DEPARTMENT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnCorrectDepartment()))
        ).andExpect(status().isOk());
    }

    @Test
    public void saveDepartamentWithNameMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_DEPARTMENT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnDepartamentWithNameMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveDepartamentWithNameMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_DEPARTMENT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnDepartamentWithNameMax()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveDepartamentWithNameNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_DEPARTMENT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnDepartamentWithNameNull()))
        ).andExpect(status().isBadRequest());
    }

    //update
    @Test
    public void updateDepartamentMustReturnOk() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(DEPARTMENT_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnCorrectDepartment()))
        ).andExpect(status().isOk());
    }

    @Test
    public void updateDepartamentWithNameMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(DEPARTMENT_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnDepartamentWithNameMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void updateDepartamentWithNameMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(DEPARTMENT_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnDepartamentWithNameMax()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void updateDepartamentWithNameNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(DEPARTMENT_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnDepartamentWithNameNull()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void deleteByIdDepartamentMustReturnOk() throws Exception{
        mockMvc.perform(delete(DEPARTMENT_ROUTE_PARAMETER))
                .andExpect(status().isOk());
    }

    @Test
    public void popularBanckDepartamentMustReturnOk() throws Exception{
        mockMvc.perform(get(DEPARTMENT_POPULAR_ROUTE))
                .andExpect(status().isOk());
    }
}
