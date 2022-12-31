package br.com.geradordedevs.gdrecursoshumanos.facades.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.CargoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import br.com.geradordedevs.gdrecursoshumanos.facades.impl.CargoFacedeImpl;
import br.com.geradordedevs.gdrecursoshumanos.mappers.CargoMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.CargoService;
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
public class CargoFacadeImplTest {

    @InjectMocks
    private CargoFacedeImpl cargoFacede;

    @Mock
    private CargoService cargoService;

    @Mock
    private CargoMapper mapper;

    @Mock
    private TokenService tokenService;

    private final Long MOCK_ID_OFFICE= 1L;
    private final String MOCK_NAME_OFFICE ="adiministrador";
    private  String MOCK_TOKEN ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";

    @Before
    public  void  setupMoc(){
        MockitoAnnotations.openMocks(this);

        when(cargoService.findAll()).thenReturn(returnListOfficeEntity());
        when(cargoService.findById(MOCK_ID_OFFICE)).thenReturn(returnObjectOfficeEntity());
        when(cargoService.save(returnObjectOfficeEntity())).thenReturn(returnObjectOfficeEntity());
        when(cargoService.update(MOCK_ID_OFFICE,returnObjectOfficeEntity())).thenReturn(returnObjectOfficeEntity());

        when(mapper.toDtoList(returnListOfficeEntity())).thenReturn(returnListOfficeResponseDTO());
        when(mapper.toDto(returnObjectOfficeEntity())).thenReturn(returnObjectOfficeResponseDTO());
        when(mapper.toEntity(returnObjectOfficeRequestDTO())).thenReturn(returnObjectOfficeEntity());
    }

    @Test
    public void findAllOfficeMustReturnOk() throws Exception {
        assertEquals(returnListOfficeResponseDTO(), cargoFacede.findAll(MOCK_TOKEN));
    }

    @Test
    public void findByIdOfficeMustReturnOk() throws Exception{
        assertEquals(returnObjectOfficeResponseDTO(), cargoFacede.findById(MOCK_ID_OFFICE,MOCK_TOKEN));
    }

    @Test
    public void saveOfficeMustReturnOk() throws Exception{
        assertEquals(returnObjectOfficeResponseDTO(),cargoFacede.save(returnObjectOfficeRequestDTO(),MOCK_TOKEN));
    }

    @Test
    public void updateOfficeMustReturnOk() throws Exception{
        assertEquals(returnObjectOfficeResponseDTO(),cargoFacede.update(MOCK_ID_OFFICE,returnObjectOfficeRequestDTO(),MOCK_TOKEN));
    }

    List<CargoResponseDTO> returnListOfficeResponseDTO(){
        List<CargoResponseDTO> list = new ArrayList<>();
            list.add(returnObjectOfficeResponseDTO());
        return list;
    }

    List<CargoEntity> returnListOfficeEntity(){
        List<CargoEntity> list = new ArrayList<>();
            list.add(returnObjectOfficeEntity());
        return list;
    }

    private CargoResponseDTO returnObjectOfficeResponseDTO(){
        return new CargoResponseDTO(MOCK_ID_OFFICE,MOCK_NAME_OFFICE);
    }

    private CargoEntity returnObjectOfficeEntity(){
        return new CargoEntity(MOCK_ID_OFFICE,MOCK_NAME_OFFICE);
    }

    private CargoRequestDTO returnObjectOfficeRequestDTO(){
        return new CargoRequestDTO(MOCK_NAME_OFFICE);
    }
}
