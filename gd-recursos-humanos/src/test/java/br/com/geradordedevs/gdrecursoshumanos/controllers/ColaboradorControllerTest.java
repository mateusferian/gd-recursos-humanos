package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AutenticacaoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.AtestadoFacade;
import br.com.geradordedevs.gdrecursoshumanos.facades.ColaboradorFacade;
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
@WebMvcTest(ColaboradorController.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration")
public class ColaboradorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ColaboradorFacade colaboradorFacade;

    private final String ROUTE_COLLABORATOR = "/colaboradores";
    private final String COLLABORATOR_ROUTE_PARAMETER = "/colaboradores/1";
    private final String COLLABORATOR_POPULAR_ROUTE = "/colaboradores/popular";

    private final String NAME_COLLABORATOR = "covid";
    private final int AGE_COLLABORATOR = 19;
    private final Date COLLABORATOR_BIRTH_DATE = new Date(93, 10, 17);
    private final Long ID_DOCUMENT_TYPE = 1l;
    private final String DOCUMENT_NUMBER = "44.909.686-5";
    private final Long OFFICE = 1l;
    private final Long DEPARTMENT = 1l;
    private final int SALARY = 1000;
    private final Date START_DATE = new Date(117, 10, 10);
    private final boolean ACTIVE = true;
    private final String TELEPHONE = "(11) 2152-1919";
    private final String EMAIL = "josepaulo@gmail.com";


    public ColaboradorRequestDTO returnCorrectCollaborator() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, OFFICE, DEPARTMENT,
                SALARY, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }

    public ColaboradorRequestDTO returnsCollaboratorWithNameMin() {
        return new ColaboradorRequestDTO("ab", AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, OFFICE, DEPARTMENT,
                SALARY, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }

    public ColaboradorRequestDTO returnsCollaboratorWithNameMax() {
        return new ColaboradorRequestDTO("mateusmateusmateusmateusmateusmateusmates", AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, OFFICE, DEPARTMENT,
                SALARY, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }

    public ColaboradorRequestDTO returnsCollaboratorWithNameNull() {
        return new ColaboradorRequestDTO(null, AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, OFFICE, DEPARTMENT,
                SALARY, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }

    //age
    public ColaboradorRequestDTO returnsCollaboratorWithAgeMin() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, 17, COLLABORATOR_BIRTH_DATE,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, OFFICE, DEPARTMENT,
                SALARY, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }

    public ColaboradorRequestDTO returnsCollaboratorWithAgeMax() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, 71, COLLABORATOR_BIRTH_DATE,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, OFFICE, DEPARTMENT,
                SALARY, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }

    //birthdate
    public ColaboradorRequestDTO returnsCollaboratorWithBirthDateNull() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, null,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, OFFICE, DEPARTMENT,
                SALARY, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }

    //document type
    public ColaboradorRequestDTO returnsCollaboratorWithNullDocumentType() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                null, DOCUMENT_NUMBER, OFFICE, DEPARTMENT,
                SALARY, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }


    public ColaboradorRequestDTO returnsCollaboratorWithDocumentTypeMin() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                0L, DOCUMENT_NUMBER, OFFICE, DEPARTMENT,
                SALARY, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }

    public ColaboradorRequestDTO returnsCollaboratorWithDocumentTypeMax() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                71L, DOCUMENT_NUMBER, OFFICE, DEPARTMENT,
                SALARY, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }
    //ducumenty number
    public ColaboradorRequestDTO returnsCollaboratorWithDocumentNumberNull() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                ID_DOCUMENT_TYPE, null, OFFICE, DEPARTMENT,
                SALARY, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }

    public ColaboradorRequestDTO returnsCollaboratorWithDocumentNumberMin() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                0L, "123456789", OFFICE, DEPARTMENT,
                SALARY, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }

    public ColaboradorRequestDTO returnsCollaboratorWithDocumentNumberMax() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                ID_DOCUMENT_TYPE, "123456789012345678901", OFFICE, DEPARTMENT,
                SALARY, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }
    //office

    public ColaboradorRequestDTO returnsCollaboratorWithOfficeMin() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, 0L, DEPARTMENT,
                SALARY, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }

    public ColaboradorRequestDTO returnsCollaboratorWithOfficeMax() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, 71L, DEPARTMENT,
                SALARY, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }

    public ColaboradorRequestDTO returnsCollaboratorWithOfficeNull() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, null, DEPARTMENT,
                SALARY, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }

    // departament
    public ColaboradorRequestDTO returnsCollaboratorWithDepartamentMin() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, OFFICE, 0L,
                SALARY, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }

    public ColaboradorRequestDTO returnsCollaboratorWithDepartamentMax() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, OFFICE, 71L,
                SALARY, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }

    public ColaboradorRequestDTO returnsCollaboratorWithDepartamentNull() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, OFFICE, null,
                SALARY, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }
    //usalary

    public ColaboradorRequestDTO returnsCollaboratorWithSalaryMin() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, OFFICE, DEPARTMENT,
                999, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }

    public ColaboradorRequestDTO returnsCollaboratorWithSalaryMax() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, OFFICE, DEPARTMENT,
                30001, START_DATE, ACTIVE, TELEPHONE, EMAIL);
    }

    //start date

    public ColaboradorRequestDTO returnsCollaboratorWithStartDateNull() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, null,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, OFFICE, DEPARTMENT,
                SALARY, null, ACTIVE, TELEPHONE, EMAIL);
    }
    // telephone

    public ColaboradorRequestDTO returnsCollaboratorWithTelephoneMin() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, OFFICE, DEPARTMENT,
                SALARY, START_DATE, ACTIVE, "1234567", EMAIL);
    }

    public ColaboradorRequestDTO returnsCollaboratorWithTelephoneMax() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, OFFICE, DEPARTMENT,
                SALARY, START_DATE, ACTIVE, "1234567890123456", EMAIL);
    }
    public ColaboradorRequestDTO returnsCollaboratorWithTelephoneNull() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, COLLABORATOR_BIRTH_DATE,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, OFFICE, DEPARTMENT,
                SALARY, START_DATE, ACTIVE, null, EMAIL);
    }

    //email
    public ColaboradorRequestDTO returnsCollaboratorWithEmailNull() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, null,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, OFFICE, DEPARTMENT,
                SALARY, null, ACTIVE, TELEPHONE, null);
    }

    public ColaboradorRequestDTO returnsCollaboratorWithEmailInvalid() {
        return new ColaboradorRequestDTO(NAME_COLLABORATOR, AGE_COLLABORATOR, null,
                ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, OFFICE, DEPARTMENT,
                SALARY, null, ACTIVE, TELEPHONE, "carlos.jose");
    }

    @Test
    public void findAllCollaboratorMustReturnOk() throws Exception{
        mockMvc.perform(get(ROUTE_COLLABORATOR))
                .andExpect(status().isOk());
    }
    @Test
    public void  findByIdRegisterCollaboratorMustReturnOk() throws Exception {
        mockMvc.perform(get(COLLABORATOR_ROUTE_PARAMETER))
                .andExpect(status().isOk());
    }

    @Test
    public void saveCollaboratorMustReturnOk() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnCorrectCollaborator()))
        ).andExpect(status().isOk());
    }

    @Test
    public void saveCollaboratorWithNameMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithNameMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveCollaboratorWithNameMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithNameMax()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveCollaboratorWithNullMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithNameNull()))
        ).andExpect(status().isBadRequest());
    }

    //age
    @Test
    public void saveCollaboratorWithAgeMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithAgeMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveCollaboratorWithAgeMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithAgeMax()))
        ).andExpect(status().isBadRequest());
    }

    //birth_date
    @Test
    public void saveCollaboratorWithBirthDateNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithBirthDateNull()))
        ).andExpect(status().isBadRequest());
    }

    //document
    @Test
    public void saveCollaboratorWithDocumentTypeNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithNullDocumentType()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveCollaboratorWithDocumentTypeMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithDocumentTypeMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveCollaboratorWithDocumentTypeMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithDocumentTypeMax()))
        ).andExpect(status().isBadRequest());
    }

    //document number
    @Test
    public void saveCollaboratorWithDocumentNumberNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithDocumentNumberNull()))
        ).andExpect(status().isBadRequest());
    }
    @Test
    public void saveCollaboratorWithDocumentNumberMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithDocumentNumberMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveCollaboratorWithDocumentNumberMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithDocumentNumberMax()))
        ).andExpect(status().isBadRequest());
    }

    //office
    @Test
    public void saveCollaboratorWithOfiiceMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithOfficeMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveCollaboratorWithOfficeMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithOfficeMax()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveCollaboratorWithOfficeNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString((returnsCollaboratorWithOfficeNull())))
        ).andExpect(status().isBadRequest());
    }

    //departament
    @Test
    public void saveCollaboratorWithDepartamentMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithDepartamentMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveCollaboratorWithDepartamentMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithDepartamentMax()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveCollaboratorWithDepartamentNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString((returnsCollaboratorWithDepartamentNull())))
        ).andExpect(status().isBadRequest());
    }

    //salary
    @Test
    public void saveCollaboratorWithSalaryMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithSalaryMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveCollaboratorWithSalaryMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithSalaryMax()))
        ).andExpect(status().isBadRequest());
    }
    //start date

    @Test
    public void saveCollaboratorWithStartDateNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithStartDateNull()))
        ).andExpect(status().isBadRequest());
    }

    //telefophone
    @Test
    public void saveCollaboratorWithTelephoneMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithTelephoneMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveCollaboratorWithTelephoneMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithTelephoneMax()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveCollaboratorWithTelephoneNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithTelephoneNull()))
        ).andExpect(status().isBadRequest());
    }

    //email
    @Test
    public void saveCollaboratorWithEmailNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithEmailNull()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void saveCollaboratorWithEmailInvalidMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE_COLLABORATOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithEmailInvalid()))
        ).andExpect(status().isBadRequest());
    }

    //Update
    @Test
    public void upadeCollaboratorMustReturnOk() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnCorrectCollaborator()))
        ).andExpect(status().isOk());
    }

    @Test
    public void upadeCollaboratorWithNameMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithNameMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void upadeCollaboratorWithNameMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithNameMax()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void upadeCollaboratorWithNullMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithNameNull()))
        ).andExpect(status().isBadRequest());
    }

    //age
    @Test
    public void upadeCollaboratorWithAgeMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithAgeMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void upadeCollaboratorWithAgeMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithAgeMax()))
        ).andExpect(status().isBadRequest());
    }

    //birth_date
    @Test
    public void upadeCollaboratorWithBirthDateNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithBirthDateNull()))
        ).andExpect(status().isBadRequest());
    }

    //document
    @Test
    public void upadeCollaboratorWithDocumentTypeNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithNullDocumentType()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void upadeCollaboratorWithDocumentTypeMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithDocumentTypeMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void upadeCollaboratorWithDocumentTypeMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithDocumentTypeMax()))
        ).andExpect(status().isBadRequest());
    }

    //document number
    @Test
    public void upadeCollaboratorWithDocumentNumberNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithDocumentNumberNull()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void upadeCollaboratorWithDocumentNumberMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithDocumentNumberMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void upadeCollaboratorWithDocumentNumberMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithDocumentNumberMax()))
        ).andExpect(status().isBadRequest());
    }

    //office
    @Test
    public void upadeCollaboratorWithOfiiceMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithOfficeMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void upadeCollaboratorWithOfficeMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithOfficeMax()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void upadeCollaboratorWithOfficeNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString((returnsCollaboratorWithOfficeNull())))
        ).andExpect(status().isBadRequest());
    }

    //departament
    @Test
    public void upadeCollaboratorWithDepartamentMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithDepartamentMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void upadeCollaboratorWithDepartamentMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithDepartamentMax()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void upadeCollaboratorWithDepartamentNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString((returnsCollaboratorWithDepartamentNull())))
        ).andExpect(status().isBadRequest());
    }

    //salary
    @Test
    public void upadeCollaboratorWithSalaryMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithSalaryMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void upadeCollaboratorWithSalaryMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithSalaryMax()))
        ).andExpect(status().isBadRequest());
    }

    //start date
    @Test
    public void upadeCollaboratorWithStartDateNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithStartDateNull()))
        ).andExpect(status().isBadRequest());
    }

    //telefophone
    @Test
    public void upadeCollaboratorWithTelephoneMinMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithTelephoneMin()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void upadeCollaboratorWithTelephoneMaxMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithTelephoneMax()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void upadeCollaboratorWithTelephoneNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithTelephoneNull()))
        ).andExpect(status().isBadRequest());
    }

    //email
    @Test
    public void upadeCollaboratorWithEmailNullMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithEmailNull()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void upadeCollaboratorWithEmailInvalidMustReturnBadRequest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(put(COLLABORATOR_ROUTE_PARAMETER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(returnsCollaboratorWithEmailInvalid()))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void findByIdCollaboratorDeveRetornarOk() throws Exception{
        mockMvc.perform(delete(COLLABORATOR_ROUTE_PARAMETER))
                .andExpect(status().isOk());
    }

    @Test
    public void popularBanckCollaboratorMustReturnOk() throws Exception{
        mockMvc.perform(get(COLLABORATOR_POPULAR_ROUTE))
                .andExpect(status().isOk());
    }
}

