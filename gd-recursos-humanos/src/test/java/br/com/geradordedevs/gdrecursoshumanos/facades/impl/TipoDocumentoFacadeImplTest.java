package br.com.geradordedevs.gdrecursoshumanos.facades.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.mappers.TipoDocumentoMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.TokenService;
import br.com.geradordedevs.gdrecursoshumanos.services.impl.TipoDocumentoServiceImpl;
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
public class TipoDocumentoFacadeImplTest {

    @InjectMocks
    private TipoDocumentoFacedeImpl tipoDocumentoFacede;

    @Mock
    private TipoDocumentoServiceImpl tipoDocumentoService;

    @Mock
    private TipoDocumentoMapper mapper;

    @Mock
    private TokenService tokenService;

    private final Long MOCK_ID_DOCUMENT_TYPE= 1L;
    private final String MOCK_NAME_DOCUMENT_TYPE="cpf";
    private  String MOCK_TOKEN ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";

    @Before
    public  void  setupMoc(){
        MockitoAnnotations.openMocks(this);

        when(tipoDocumentoService.findAll()).thenReturn(returnListDocumentTypeEntity());
        when(tipoDocumentoService.findById(MOCK_ID_DOCUMENT_TYPE)).thenReturn(returnObjectDocumentTypeEntity());
        when(tipoDocumentoService.save(returnObjectDocumentTypeEntity())).thenReturn(returnObjectDocumentTypeEntity());
        when(tipoDocumentoService.update(MOCK_ID_DOCUMENT_TYPE,returnObjectDocumentTypeEntity())).thenReturn(returnObjectDocumentTypeEntity());

        when(mapper.toDtoList(returnListDocumentTypeEntity())).thenReturn(returnListDocumentTypeResponseDTO());
        when(mapper.toDto(returnObjectDocumentTypeEntity())).thenReturn(returnObjectDocumentTypeResponseDTO());
        when(mapper.toEntity(returnObjectDocumentTypeRequestDTO())).thenReturn(returnObjectDocumentTypeEntity());
    }

    @Test
    public void findAllDocumentTypeMustReturnOk() throws Exception {
        assertEquals(returnListDocumentTypeResponseDTO(), tipoDocumentoFacede.findAll(MOCK_TOKEN));
    }

    @Test
    public void findByIdDocumentTypeMustReturnOk() throws Exception{
        assertEquals(returnObjectDocumentTypeResponseDTO(), tipoDocumentoFacede.findById(MOCK_ID_DOCUMENT_TYPE,MOCK_TOKEN));
    }

    @Test
    public void saveDocumentTypeMustReturnOk() throws Exception{
        assertEquals(returnObjectDocumentTypeResponseDTO(),tipoDocumentoFacede.save(returnObjectDocumentTypeRequestDTO(),MOCK_TOKEN));
    }

    @Test
    public void updateDocumentTypeMustReturnOk() throws Exception{
        assertEquals(returnObjectDocumentTypeResponseDTO(),tipoDocumentoFacede.update(MOCK_ID_DOCUMENT_TYPE,returnObjectDocumentTypeRequestDTO(),MOCK_TOKEN));
    }

    @Test
    public void deleteByIdDocumentTypeMustReturnOk() throws Exception{
        tipoDocumentoFacede.deleteById(MOCK_ID_DOCUMENT_TYPE,MOCK_TOKEN);
       verify(tipoDocumentoService,timeout(1)).deleteById(MOCK_ID_DOCUMENT_TYPE);
    }

    List<TipoDocumentoResponseDTO> returnListDocumentTypeResponseDTO(){
        List<TipoDocumentoResponseDTO> list = new ArrayList<>();
            list.add(returnObjectDocumentTypeResponseDTO());
        return list;
    }

    List<TipoDocumentoEntity> returnListDocumentTypeEntity(){
        List<TipoDocumentoEntity> list = new ArrayList<>();
            list.add(returnObjectDocumentTypeEntity());
        return list;
    }

    private TipoDocumentoResponseDTO returnObjectDocumentTypeResponseDTO(){
        return new TipoDocumentoResponseDTO(MOCK_ID_DOCUMENT_TYPE,MOCK_NAME_DOCUMENT_TYPE);
    }

    private TipoDocumentoEntity returnObjectDocumentTypeEntity(){
        return new TipoDocumentoEntity(MOCK_ID_DOCUMENT_TYPE,MOCK_NAME_DOCUMENT_TYPE);
    }

    private TipoDocumentoRequestDTO returnObjectDocumentTypeRequestDTO(){
        return new TipoDocumentoRequestDTO(MOCK_NAME_DOCUMENT_TYPE);
    }
}
