package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.ColaboradorRepository;
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
public class ColaboradorServiceImplTest {

    @InjectMocks
    private ColaboradorServiceImpl colaboradorService;

    @Mock
    private ColaboradorRepository colaboradorRepository;

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
    public void setupMock(){
        MockitoAnnotations.openMocks(this);
        when(colaboradorRepository.findAll()).thenReturn(returnlistCollaboratorEntity());
        when(colaboradorRepository.findById(MOCK_ID_COLLABORATOR)).thenReturn(java.util.Optional.of(returnObjectCollaboratorEntityWithId()));
        when(colaboradorRepository.save(returnObjectCollaboratorEntity())).thenReturn(returnObjectCollaboratorEntity());
        when(colaboradorRepository.save(returnObjectCollaboratorEntityWithId())).thenReturn(returnObjectCollaboratorEntityWithId());
    }

    @Test
    public void findAllCollaboratorMustReturnOk(){
        assertEquals(returnlistCollaboratorEntity(),colaboradorService.findAll());
    }

    @Test
    public void findByIdCollaboratorMustReturnOk (){
        assertEquals(returnObjectCollaboratorEntityWithId(),colaboradorService.findById(MOCK_ID_COLLABORATOR));
    }

    @Test
    public void saveCollaboratorMustReturnOk(){
        assertEquals(returnObjectCollaboratorEntity(),colaboradorService.save(returnObjectCollaboratorEntity()));
    }

    @Test
    public void updateCollaboratorMustReturnOk(){
        assertEquals(returnObjectCollaboratorEntityWithId(),colaboradorService.update(MOCK_ID_COLLABORATOR,returnObjectCollaboratorEntity()));
    }

    @Test
    public void deleteByIdCollaboratorMustReturnOk(){
        colaboradorService.deleteById(MOCK_ID_COLLABORATOR);
        verify(colaboradorRepository,timeout(1)).deleteById(MOCK_ID_COLLABORATOR);
    }

    @Test
    public void populatingCollaboratorMustReturnOk(){
        colaboradorService.populating();
        returnObjectCollaboratorEntityVerify();
    }

    private List<ColaboradorEntity> returnlistCollaboratorEntity(){
        List<ColaboradorEntity> findAll = new ArrayList<>();
            findAll.add(returnObjectCollaboratorEntity());
        return  findAll;
    }

    private  void returnObjectCollaboratorEntityVerify(){
        verify(colaboradorRepository,timeout(1)).save(new ColaboradorEntity("jose",29,new Date(93,11,22),new TipoDocumentoEntity(1L),"44.909.686-5",new CargoEntity(1L),new DepartamentoEntity(1L),4000,new Date(117,10,10),true,"(11) 2152-1919","josepaulo@gmail.com"));
        verify( colaboradorRepository,timeout(1)).save(new ColaboradorEntity("Maria",31,new Date(91,9,21),new TipoDocumentoEntity(2L),"145.201.330-68",new CargoEntity(2L),new DepartamentoEntity(2L),2000,new Date(118,11,10),true,"(11) 2133-1919","maria@gmail.com"));
        verify(colaboradorRepository,timeout(1)).save(new ColaboradorEntity("Carlos",30,new Date(92,10,15),new TipoDocumentoEntity(3L),"00.886.436/0001-20",new CargoEntity(3L),new DepartamentoEntity(3L),1000,new Date(119,11,10),true,"(11) 2154-1919","carlos@gmail.com"));
    }

    private  ColaboradorEntity returnObjectCollaboratorEntity(){
        return new ColaboradorEntity(MOCK_NAME_COLLABORATOR,MOCK_AGE_COLLABORATOR,MOCK_COLLABORATOR_BIRTH_DATE,
                returnObjectDocumentTypeEntity(),MOCK_DOCUMENT_NUMBER, returnObjectOfficeEntity(),returnObjectDepartmentEntity(),
                MOCK_SALARY,MOCK_START_DATE,MOCK_ACTIVE,MOCK_TELEPHONE,MOCK_EMAIL);
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
