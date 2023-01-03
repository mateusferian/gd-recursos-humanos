package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.CargoRepository;
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
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CargoServiceImplTest {

    @InjectMocks
    private CargoServiceImpl cargoService;

    @Mock
    private CargoRepository cargoRepository;

    private final Long MOCK_ID_OFFICE= 1L;
    private final String MOCK_NAME_OFFICE ="adiministrador";

    @Before
    public void setupMock(){
        MockitoAnnotations.openMocks(this);
        when(cargoRepository.findAll()).thenReturn(returnlistOfficeEntity());
        when(cargoRepository.findById(MOCK_ID_OFFICE)).thenReturn(java.util.Optional.of(returnObjectOfficeEntityWithId()));
        when(cargoRepository.save(returnObjectOfficeEntity())).thenReturn(returnObjectOfficeEntity());
        when(cargoRepository.save(returnObjectOfficeEntityWithId())).thenReturn(returnObjectOfficeEntityWithId());

    }

    @Test
    public void findAllOfficeMustReturnOk(){
        assertEquals(returnlistOfficeEntity(),cargoService.findAll());
    }

    @Test
    public void findByIdOfficeMustReturnOk (){
        assertEquals(returnObjectOfficeEntityWithId(),cargoService.findById(MOCK_ID_OFFICE));
    }

    @Test
    public void saveOfficeMustReturnOk(){
        assertEquals(returnObjectOfficeEntity(),cargoService.save(returnObjectOfficeEntity()));
    }

    @Test
    public void updateOfficeMustReturnOk(){
        assertEquals(returnObjectOfficeEntityWithId(),cargoService.update(MOCK_ID_OFFICE,returnObjectOfficeEntity()));
    }

    @Test
    public  void deleteByIdOfficeMustReturnOk() throws  Exception{
        cargoService.deleteById(MOCK_ID_OFFICE);
        verify(cargoRepository,timeout(1)).deleteById(MOCK_ID_OFFICE);
    }

    private List<CargoEntity> returnlistOfficeEntity(){
        List<CargoEntity> findAll = new ArrayList<>();
            findAll.add(returnObjectOfficeEntity());
        return  findAll;
    }

    private  CargoEntity returnObjectOfficeEntity(){
        return new CargoEntity(MOCK_NAME_OFFICE);
    }

    private  CargoEntity returnObjectOfficeEntityWithId(){
        return new CargoEntity(MOCK_ID_OFFICE,MOCK_NAME_OFFICE);
    }
}
