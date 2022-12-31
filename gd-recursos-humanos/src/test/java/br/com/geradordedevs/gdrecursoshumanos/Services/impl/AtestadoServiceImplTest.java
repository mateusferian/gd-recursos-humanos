package br.com.geradordedevs.gdrecursoshumanos.Services.impl;

import br.com.geradordedevs.gdrecursoshumanos.entities.*;
import br.com.geradordedevs.gdrecursoshumanos.repositories.AtestadoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.impl.AtestadoServiceImpl;
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
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AtestadoServiceImplTest {

    @InjectMocks
    private AtestadoServiceImpl atestadoService;

    @Mock
    private AtestadoRepository atestadoRepository;


    private final Long MOCK_ID_CCERTIFIED = 1L;
    private  final String MOCK_CERTIFIED_NAME="covid";
    private  final  Date MOCK_DATE_CERTIFICATE=new Date(121,10,17);

    private final Long MOCK_ID_COLLABORATOR = 1L;
    private final String MOCK_NAME_COLLABORATOR = "covid";
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
    public void setupMock(){
        MockitoAnnotations.openMocks(this);
        when(atestadoRepository.findAll()).thenReturn(returnlistAttestationEntity());
        when(atestadoRepository.findById(MOCK_ID_DEPARTMENT)).thenReturn(java.util.Optional.of(returnObjectAttestationEntityWithId()));
        when(atestadoRepository.save(returnObjectAttestationEntity())).thenReturn(returnObjectAttestationEntity());
        when(atestadoRepository.save(returnObjectAttestationEntityWithId())).thenReturn(returnObjectAttestationEntityWithId());
    }


    @Test
    public void findAllAttestationMustReturnOk(){
        assertEquals(returnlistAttestationEntity(),atestadoService.findAll());
    }

    @Test
    public void findByIdAttestationMustReturnOk (){
        assertEquals(returnObjectAttestationEntityWithId(),atestadoService.findById(MOCK_ID_COLLABORATOR));
    }

    @Test
    public void saveAttestationMustReturnOk(){
        assertEquals(returnObjectAttestationEntity(),atestadoService.save(returnObjectAttestationEntity()));
    }

    @Test
    public void updateAttestationMustReturnOk(){
        assertEquals(returnObjectAttestationEntityWithId(),atestadoService.update(MOCK_ID_COLLABORATOR,returnObjectAttestationEntity()));
    }

    private List<AtestadoEntity> returnlistAttestationEntity(){
        List<AtestadoEntity> findAll = new ArrayList<>();
        findAll.add(returnObjectAttestationEntity());
        return  findAll;
    }

    private AtestadoEntity returnObjectAttestationEntity(){
        return new AtestadoEntity(MOCK_CERTIFIED_NAME,MOCK_DATE_CERTIFICATE,returnObjectCollaboratorEntityWithId());
    }

    private AtestadoEntity returnObjectAttestationEntityWithId(){
        return new AtestadoEntity(MOCK_ID_CCERTIFIED,MOCK_CERTIFIED_NAME,MOCK_DATE_CERTIFICATE,returnObjectCollaboratorEntityWithId());
    }

    private  ColaboradorEntity returnObjectCollaboratorEntityWithId(){
        return new ColaboradorEntity(MOCK_ID_COLLABORATOR,MOCK_NAME_COLLABORATOR,MOCK_AGE_COLLABORATOR,MOCK_COLLABORATOR_BIRTH_DATE,
                returnObjectDocumentTypeEntity(),MOCK_DOCUMENT_NUMBER, returnObjectOfficeEntity(),returnObjectDepartmentEntity(),
                MOCK_SALARY,MOCK_START_DATE,MOCK_ACTIVE,MOCK_TELEPHONE,MOCK_EMAIL);
    }

    private CargoEntity returnObjectOfficeEntity(){
        return new CargoEntity(MOCK_ID_OFFICE,MOCK_NAME_OFFICE);
    }

    private DepartamentoEntity returnObjectDepartmentEntity(){
        return new DepartamentoEntity(MOCK_ID_DEPARTMENT,MOCK_NAME_DEPARTMENT);
    }

    private TipoDocumentoEntity returnObjectDocumentTypeEntity(){
        return new TipoDocumentoEntity(MOCK_ID_DOCUMENT_TYPE,MOCK_NAME_DOCUMENT_TYPE);
    }
}

