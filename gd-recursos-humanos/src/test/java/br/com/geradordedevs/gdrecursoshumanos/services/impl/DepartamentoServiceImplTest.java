package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.DepartamentoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class DepartamentoServiceImplTest {

    @InjectMocks
    private DepartamentoServiceImpl departamentoService;

    @Mock
    private DepartamentoRepository departamentoRepository;

    private final Long MOCK_ID_DEPARTMENT= 1L;
    private final String MOCK_NAME_DEPARTMENT ="adiministrativo";

    @Before
    public void setupMock(){
        MockitoAnnotations.openMocks(this);
        when(departamentoRepository.findAll()).thenReturn(returnlistDepartmentEntity());
        when(departamentoRepository.findById(MOCK_ID_DEPARTMENT)).thenReturn(java.util.Optional.of(returnObjectDepartmentEntityWithId()));
        when(departamentoRepository.save(returnObjectDepartmentEntity())).thenReturn(returnObjectDepartmentEntity());
        when(departamentoRepository.save(returnObjectDepartmentEntityWithId())).thenReturn(returnObjectDepartmentEntityWithId());
    }

    @Test
    public void findAllDepartmentMustReturnOk(){
        assertEquals(returnlistDepartmentEntity(),departamentoService.findAll());
    }

    @Test
    public void findByIdDepartmentMustReturnOk (){
        assertEquals(returnObjectDepartmentEntityWithId(),departamentoService.findById(MOCK_ID_DEPARTMENT));
    }

    @Test
    public void saveDepartmentMustReturnOk(){
        assertEquals(returnObjectDepartmentEntity(),departamentoService.save(returnObjectDepartmentEntity()));
    }

    @Test
    public void updateDepartmentMustReturnOk(){
        assertEquals(returnObjectDepartmentEntityWithId(),departamentoService.update(MOCK_ID_DEPARTMENT,returnObjectDepartmentEntity()));
    }

    private List<DepartamentoEntity> returnlistDepartmentEntity(){
        List<DepartamentoEntity> findAll = new ArrayList<>();
            findAll.add(returnObjectDepartmentEntity());
        return  findAll;
    }

    private  DepartamentoEntity returnObjectDepartmentEntity(){
        return new DepartamentoEntity(MOCK_NAME_DEPARTMENT);
    }

    private DepartamentoEntity returnObjectDepartmentEntityWithId(){
        return new DepartamentoEntity(MOCK_ID_DEPARTMENT,MOCK_NAME_DEPARTMENT);
    }
}
