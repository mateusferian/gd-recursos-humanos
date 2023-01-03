package br.com.geradordedevs.gdrecursoshumanos.facades.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.CargoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.ColaboradorResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.DepartamentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.mappers.ColaboradorMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.*;
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
public class ColaboradorFacadeImplTest {

    @InjectMocks
    private ColaboradorFacedeImpl colaboradorFacade;
    @Mock
    private ColaboradorService colaboradorService;
    @Mock
    private TipoDocumentoService documentoService;
    @Mock
    private CargoService cargoService;
    @Mock
    private DepartamentoService departamentoService;
    @Mock
    private TokenService tokenService;
    @Mock
    private ColaboradorMapper mapper;

    private  String MOCK_TOKEN ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
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
    public  void  setupMoc() {
        MockitoAnnotations.openMocks(this);

        when(colaboradorService.findAll()).thenReturn(returnListCollaboratorEntity());
        when(colaboradorService.findById(MOCK_ID_COLLABORATOR)).thenReturn(returnObjectCollaboratorEntity());
        when(colaboradorService.save(returnObjectCollaboratorEntity())).thenReturn(returnObjectCollaboratorEntity());
        when(colaboradorService.update(MOCK_ID_COLLABORATOR,returnObjectCollaboratorEntity())).thenReturn(returnObjectCollaboratorEntity());

        when(mapper.toDtoList(returnListCollaboratorEntity())).thenReturn(returnListCollaboratorResponseDTO());
        when(mapper.toDto(returnObjectCollaboratorEntity())).thenReturn(returnObjectCollaboratorResponseDTO());
        when(mapper.toEntity(returnObjectCollaboratorRequestDTO())).thenReturn(returnObjectCollaboratorEntity());
    }

    @Test
    public void findAllCollaboratorMustReturnOk() throws Exception {
        assertEquals(returnListCollaboratorResponseDTO(), colaboradorFacade.findAll(MOCK_TOKEN));
    }

    @Test
    public void findByIdCollaboratorMustReturnOk() throws Exception{
        assertEquals(returnObjectCollaboratorResponseDTO(), colaboradorFacade.findById(MOCK_ID_COLLABORATOR,MOCK_TOKEN));
    }

    @Test
    public void saveCollaboratorMustReturnOk() throws Exception{
        assertEquals(returnObjectCollaboratorResponseDTO(),colaboradorFacade.save(returnObjectCollaboratorRequestDTO(),MOCK_TOKEN));
    }

    @Test
    public void updateCollaboratorMustReturnOk() throws Exception{
        assertEquals(returnObjectCollaboratorResponseDTO(),colaboradorFacade.update(MOCK_ID_COLLABORATOR,returnObjectCollaboratorRequestDTO(),MOCK_TOKEN));
    }

    @Test
    public void deleteByIdCollaboratorMustReturnOk() throws Exception{
        colaboradorFacade.deleteById(MOCK_ID_COLLABORATOR,MOCK_TOKEN);
        verify(colaboradorService,timeout(1)).deleteById(MOCK_ID_COLLABORATOR);
    }

    @Test
    public void populatingCollaboratorMustReturnOk() throws Exception{
        colaboradorFacade.populating(MOCK_TOKEN);
        verify(colaboradorService,timeout(1)).populating();
    }

    List<ColaboradorResponseDTO> returnListCollaboratorResponseDTO(){
        List<ColaboradorResponseDTO> list = new ArrayList<>();
            list.add(returnObjectCollaboratorResponseDTO());
        return list;
    }

    List<ColaboradorEntity> returnListCollaboratorEntity(){
        List<ColaboradorEntity> list = new ArrayList<>();
        list.add(returnObjectCollaboratorEntity());
        return list;
    }

    private ColaboradorResponseDTO returnObjectCollaboratorResponseDTO(){
        return new ColaboradorResponseDTO(MOCK_ID_COLLABORATOR,MOCK_NAME_COLLABORATOR,MOCK_AGE_COLLABORATOR,MOCK_COLLABORATOR_BIRTH_DATE,
                returnObjectDocumentTypeResponseDTO(),MOCK_DOCUMENT_NUMBER, returnObjectOfficeResponseDTO(),returnObjectDepartmentResponseDTO(),
                MOCK_SALARY,MOCK_START_DATE,MOCK_ACTIVE,MOCK_TELEPHONE,MOCK_EMAIL);
    }

    private ColaboradorEntity returnObjectCollaboratorEntity(){
        return new ColaboradorEntity(MOCK_ID_COLLABORATOR,MOCK_NAME_COLLABORATOR,MOCK_AGE_COLLABORATOR,MOCK_COLLABORATOR_BIRTH_DATE,
                returnObjectDocumentTypeEntity(),MOCK_DOCUMENT_NUMBER, returnObjectOfficeEntity(),returnObjectDepartmentEntity(),
                MOCK_SALARY,MOCK_START_DATE,MOCK_ACTIVE,MOCK_TELEPHONE,MOCK_EMAIL);
    }

    private ColaboradorRequestDTO returnObjectCollaboratorRequestDTO(){
        return new ColaboradorRequestDTO(MOCK_NAME_COLLABORATOR,MOCK_AGE_COLLABORATOR,MOCK_COLLABORATOR_BIRTH_DATE,
                MOCK_ID_DOCUMENT_TYPE,MOCK_DOCUMENT_NUMBER, MOCK_ID_OFFICE,MOCK_ID_DEPARTMENT,
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
