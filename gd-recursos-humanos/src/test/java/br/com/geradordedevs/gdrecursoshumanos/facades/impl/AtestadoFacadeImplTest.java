package br.com.geradordedevs.gdrecursoshumanos.facades.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AtestadoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.*;
import br.com.geradordedevs.gdrecursoshumanos.entities.*;
import br.com.geradordedevs.gdrecursoshumanos.mappers.AtestadoMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.AtestadoService;
import br.com.geradordedevs.gdrecursoshumanos.services.ColaboradorService;
import br.com.geradordedevs.gdrecursoshumanos.services.TokenService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AtestadoFacadeImplTest {

    @InjectMocks
    private AtestadoFacedeImpl atestadoFacede;
    @Mock
    private AtestadoService atestadoService;
    @Mock
    private ColaboradorService colaboradorService;
    @Mock
    private TokenService tokenService;
    @Mock
    private AtestadoMapper mapper;

    private String MOCK_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";

    private final Long MOCK_ID_CCERTIFIED = 1L;
    private final String MOCK_CERTIFIED_NAME = "covid";
    private final Date MOCK_DATE_CERTIFICATE = new Date(121, 10, 17);
    private final Long MOCK_ID_COLLABORATOR = 1L;
    private final String MOCK_NAME_COLLABORATOR = "jose";
    private final int MOCK_AGE_COLLABORATOR = 19;
    private final Date MOCK_COLLABORATOR_BIRTH_DATE = new Date(93, 10, 17);
    private final Long MOCK_ID_DOCUMENT_TYPE = 1l;
    private final String MOCK_NAME_DOCUMENT_TYPE = "cpf";
    private final String MOCK_DOCUMENT_NUMBER = "44.909.686-5";
    private final Long MOCK_ID_OFFICE = 1l;
    private final String MOCK_NAME_OFFICE = "adiministrador";
    private final Long MOCK_ID_DEPARTMENT = 1l;
    private final String MOCK_NAME_DEPARTMENT = "administrativo";
    private final int MOCK_SALARY = 1000;
    private final Date MOCK_START_DATE = new Date(117, 10, 10);
    private final boolean MOCK_ACTIVE = true;
    private final String MOCK_TELEPHONE = "(11) 2152-1919";
    private final String MOCK_EMAIL = "josepaulo@gmail.com";

    @Before
    public void setupMoc() {
        MockitoAnnotations.openMocks(this);

        when(atestadoService.findAll()).thenReturn(returnListAttestationEntity());
        when(atestadoService.findById(MOCK_ID_COLLABORATOR)).thenReturn(returnObjectAttestationEntity());
        when(atestadoService.save(returnObjectAttestationEntity())).thenReturn(returnObjectAttestationEntity());
        when(atestadoService.update(MOCK_ID_COLLABORATOR, returnObjectAttestationEntity())).thenReturn(returnObjectAttestationEntity());

        when(mapper.toDtoList(returnListAttestationEntity())).thenReturn(returnListAttestationResponseDTO());
        when(mapper.toDto(returnObjectAttestationEntity())).thenReturn(returnObjectAttestationResponseDTO());
        when(mapper.toEntity(returnObjectAttestationRequestDTO())).thenReturn(returnObjectAttestationEntity());
    }

    @Test
    public void findAllAttestationMustReturnOk() throws Exception {
        assertEquals(returnListAttestationResponseDTO(), atestadoFacede.findAll(MOCK_TOKEN));
    }

    @Test
    public void findByIdAttestationMustReturnOk() throws Exception {
        assertEquals(returnObjectAttestationResponseDTO(), atestadoFacede.findById(MOCK_ID_COLLABORATOR, MOCK_TOKEN));
    }

    @Test
    public void saveAttestationMustReturnOk() throws Exception {
        assertEquals(returnObjectAttestationResponseDTO(), atestadoFacede.save(returnObjectAttestationRequestDTO(), MOCK_TOKEN));
    }

    @Test
    public void updateAttestationMustReturnOk() throws Exception {
        assertEquals(returnObjectAttestationResponseDTO(), atestadoFacede.update(MOCK_ID_COLLABORATOR, returnObjectAttestationRequestDTO(), MOCK_TOKEN));
    }

    @Test
    public void deleteByIdAttestationMustReturnOk() throws Exception {
       atestadoFacede.deleteById(MOCK_ID_CCERTIFIED,MOCK_TOKEN);
       verify(atestadoService,timeout(1)).deleteById(MOCK_ID_CCERTIFIED);
    }

    @Test
    public void populatingAttestationMustReturnOk() throws Exception {
        atestadoFacede.populating(MOCK_TOKEN);
        verify(atestadoService,timeout(1)).populating();
    }

    List<AtestadoResponseDTO> returnListAttestationResponseDTO() {
        List<AtestadoResponseDTO> list = new ArrayList<>();
        list.add(returnObjectAttestationResponseDTO());
        return list;
    }

    List<AtestadoEntity> returnListAttestationEntity() {
        List<AtestadoEntity> list = new ArrayList<>();
        list.add(returnObjectAttestationEntity());
        return list;
    }

    private AtestadoEntity returnObjectAttestationEntity() {
        return new AtestadoEntity(MOCK_CERTIFIED_NAME, MOCK_DATE_CERTIFICATE, returnObjectCollaboratorEntity());
    }

    private AtestadoResponseDTO returnObjectAttestationResponseDTO() {
        return new AtestadoResponseDTO(MOCK_ID_CCERTIFIED, MOCK_CERTIFIED_NAME, MOCK_DATE_CERTIFICATE, returnObjectCollaboratorResponseDTO());
    }

    private AtestadoRequestDTO returnObjectAttestationRequestDTO() {
        return new AtestadoRequestDTO(MOCK_CERTIFIED_NAME, MOCK_DATE_CERTIFICATE,MOCK_ID_COLLABORATOR);
    }

    //collaborator
    private ColaboradorResponseDTO returnObjectCollaboratorResponseDTO() {
        return new ColaboradorResponseDTO(MOCK_ID_COLLABORATOR, MOCK_NAME_COLLABORATOR, MOCK_AGE_COLLABORATOR, MOCK_COLLABORATOR_BIRTH_DATE,
                returnObjectDocumentTypeResponseDTO(), MOCK_DOCUMENT_NUMBER, returnObjectOfficeResponseDTO(), returnObjectDepartmentResponseDTO(),
                MOCK_SALARY, MOCK_START_DATE, MOCK_ACTIVE, MOCK_TELEPHONE, MOCK_EMAIL);
    }

    private  ColaboradorEntity returnObjectCollaboratorEntity(){
        return new ColaboradorEntity(MOCK_ID_COLLABORATOR,MOCK_NAME_COLLABORATOR,MOCK_AGE_COLLABORATOR,MOCK_COLLABORATOR_BIRTH_DATE,
                returnObjectDocumentTypeEntity(),MOCK_DOCUMENT_NUMBER, returnObjectOfficeEntity(),returnObjectDepartmentEntity(),
                MOCK_SALARY,MOCK_START_DATE,MOCK_ACTIVE,MOCK_TELEPHONE,MOCK_EMAIL);
    }

    //Department
    private DepartamentoResponseDTO returnObjectDepartmentResponseDTO(){
        return new DepartamentoResponseDTO(MOCK_ID_DEPARTMENT,MOCK_NAME_DEPARTMENT);
    }

    private DepartamentoEntity returnObjectDepartmentEntity(){
        return new DepartamentoEntity(MOCK_ID_DEPARTMENT,MOCK_NAME_DEPARTMENT);
    }

    //office
    private CargoResponseDTO returnObjectOfficeResponseDTO(){
        return new CargoResponseDTO(MOCK_ID_OFFICE,MOCK_NAME_OFFICE);
    }

    private CargoEntity returnObjectOfficeEntity(){
        return new CargoEntity(MOCK_ID_OFFICE,MOCK_NAME_OFFICE);
    }

    //DocumentType
    private TipoDocumentoResponseDTO returnObjectDocumentTypeResponseDTO(){
        return new TipoDocumentoResponseDTO(MOCK_ID_DOCUMENT_TYPE,MOCK_NAME_DOCUMENT_TYPE);
    }

    private TipoDocumentoEntity returnObjectDocumentTypeEntity(){
        return new TipoDocumentoEntity(MOCK_ID_DOCUMENT_TYPE,MOCK_NAME_DOCUMENT_TYPE);
    }
}
