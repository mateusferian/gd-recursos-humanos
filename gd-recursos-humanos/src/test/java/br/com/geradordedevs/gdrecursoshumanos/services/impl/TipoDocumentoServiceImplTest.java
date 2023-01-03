package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.TipoDocumentoRepository;
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
public class TipoDocumentoServiceImplTest {

    @InjectMocks
    private TipoDocumentoServiceImpl TipoDocumentoService;

    @Mock
    private TipoDocumentoRepository tipoDocumentoRepository;

    private final Long MOCK_ID_DOCUMENT_TYPE= 1L;
    private final String MOCK_NAME_DOCUMENT_TYPE ="adiministrador";

    @Before
    public void setupMock(){
        MockitoAnnotations.openMocks(this);
        when(tipoDocumentoRepository.findAll()).thenReturn(returnlistDocumentTypeEntity());
        when(tipoDocumentoRepository.findById(MOCK_ID_DOCUMENT_TYPE)).thenReturn(java.util.Optional.of(returnObjectDocumentTypeEntityWithId()));
        when(tipoDocumentoRepository.save(returnObjectDocumentTypeEntity())).thenReturn(returnObjectDocumentTypeEntity());
        when(tipoDocumentoRepository.save(returnObjectDocumentTypeEntityWithId())).thenReturn(returnObjectDocumentTypeEntityWithId());
    }

    @Test
    public void findAllDocumentTypeMustReturnOk(){
        assertEquals(returnlistDocumentTypeEntity(),TipoDocumentoService.findAll());
    }

    @Test
    public void findByDocumentTypeMustReturnOk (){
        assertEquals(returnObjectDocumentTypeEntityWithId(),TipoDocumentoService.findById(MOCK_ID_DOCUMENT_TYPE));
    }

    @Test
    public void saveDocumentTypeMustReturnOk(){
        assertEquals(returnObjectDocumentTypeEntity(),TipoDocumentoService.save(returnObjectDocumentTypeEntity()));
    }

    @Test
    public void updateDocumentTypeMustReturnOk(){
        assertEquals(returnObjectDocumentTypeEntityWithId(),TipoDocumentoService.update(MOCK_ID_DOCUMENT_TYPE,returnObjectDocumentTypeEntity()));
    }

    @Test
    public void deleteByIdDocumentTypeMustReturnOk(){
        TipoDocumentoService.deleteById(MOCK_ID_DOCUMENT_TYPE);
        verify(tipoDocumentoRepository,timeout(1)).deleteById(MOCK_ID_DOCUMENT_TYPE);
    }

    private List<TipoDocumentoEntity> returnlistDocumentTypeEntity(){
        List<TipoDocumentoEntity> findAll = new ArrayList<>();
            findAll.add(returnObjectDocumentTypeEntity());
        return  findAll;
    }

    private  TipoDocumentoEntity returnObjectDocumentTypeEntity(){
        return new TipoDocumentoEntity(MOCK_NAME_DOCUMENT_TYPE);
    }

    private TipoDocumentoEntity returnObjectDocumentTypeEntityWithId(){
        return new TipoDocumentoEntity(MOCK_ID_DOCUMENT_TYPE,MOCK_NAME_DOCUMENT_TYPE);
    }
}
