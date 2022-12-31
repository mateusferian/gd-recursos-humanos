package br.com.geradordedevs.gdrecursoshumanos.Facade.Impl;


import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.DepartamentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.DepartamentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.facades.impl.DepartamentoFacedeImpl;
import br.com.geradordedevs.gdrecursoshumanos.mappers.DepartamentoMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.DepartamentoService;
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
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class DepartamentoFacadeImplTest {

    @InjectMocks
    private DepartamentoFacedeImpl departamentoFacade;

    @Mock
    private DepartamentoService departamentoService;

    @Mock
    private DepartamentoMapper mapper;

    @Mock
    private TokenService tokenService;

    private final Long MOCK_ID_DEPARTAMENT= 1L;
    private final String MOCK_NAME_DEPARTAMENT="adiministrativo";
    private  String MOCK_TOKEN ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";

    @Before
    public  void  setupMoc(){
        MockitoAnnotations.openMocks(this);

        when(departamentoService.findAll()).thenReturn(returnListDepartmentEntity());
        when(departamentoService.findById(MOCK_ID_DEPARTAMENT)).thenReturn(returnObjectDepartmentEntity());
        when(departamentoService.save(returnObjectDepartmentEntity())).thenReturn(returnObjectDepartmentEntity());
        when(departamentoService.update(MOCK_ID_DEPARTAMENT,returnObjectDepartmentEntity())).thenReturn(returnObjectDepartmentEntity());

        when(mapper.toDtoList(returnListDepartmentEntity())).thenReturn(returnListDepartmentResponseDTO());
        when(mapper.toDto(returnObjectDepartmentEntity())).thenReturn(returnObjectDepartmentResponseDTO());
        when(mapper.toEntity(returnObjectDepartmentRequestDTO())).thenReturn(returnObjectDepartmentEntity());
    }

    @Test
    public void findAllDepartmentMustReturnOk() throws Exception {
        assertEquals(returnListDepartmentResponseDTO(), departamentoFacade.findAll(MOCK_TOKEN));
    }

    @Test
    public void findByIdDepartmentMustReturnOk() throws Exception{
        assertEquals(returnObjectDepartmentResponseDTO(), departamentoFacade.findById(MOCK_ID_DEPARTAMENT,MOCK_TOKEN));
    }

    @Test
    public void saveDepartmentMustReturnOk() throws Exception{
        assertEquals(returnObjectDepartmentResponseDTO(),departamentoFacade.save(returnObjectDepartmentRequestDTO(),MOCK_TOKEN));
    }

    @Test
    public void updateDepartmentMustReturnOk() throws Exception{
        assertEquals(returnObjectDepartmentResponseDTO(),departamentoFacade.update(MOCK_ID_DEPARTAMENT,returnObjectDepartmentRequestDTO(),MOCK_TOKEN));
    }

    List<DepartamentoResponseDTO> returnListDepartmentResponseDTO(){
        List<DepartamentoResponseDTO> list = new ArrayList<>();
            list.add(returnObjectDepartmentResponseDTO());
        return list;
    }

    List<DepartamentoEntity> returnListDepartmentEntity(){
        List<DepartamentoEntity> list = new ArrayList<>();
            list.add(returnObjectDepartmentEntity());
        return list;
    }

    private DepartamentoResponseDTO returnObjectDepartmentResponseDTO(){
        return new DepartamentoResponseDTO(MOCK_ID_DEPARTAMENT,MOCK_NAME_DEPARTAMENT);
    }

    private DepartamentoEntity returnObjectDepartmentEntity(){
        return new DepartamentoEntity(MOCK_ID_DEPARTAMENT,MOCK_NAME_DEPARTAMENT);
    }

    private DepartamentoRequestDTO returnObjectDepartmentRequestDTO(){
        return new DepartamentoRequestDTO(MOCK_NAME_DEPARTAMENT);
    }
}
