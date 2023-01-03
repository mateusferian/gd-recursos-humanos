package br.com.geradordedevs.gdrecursoshumanos.facades.impl;


import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.UsuarioRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.UsuarioResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.UsuarioEntity;
import br.com.geradordedevs.gdrecursoshumanos.mappers.UsuarioMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.TokenService;
import br.com.geradordedevs.gdrecursoshumanos.services.UsuarioService;
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

public class UsuarioFacedeImplTest {

    @InjectMocks
    private UsuarioFacedeImpl usuarioFacade;

    @Mock
    private UsuarioMapper mapper;

    @Mock
    private TokenService tokenService;

    @Mock
    private UsuarioService usuarioService;


    private  final  String MOCK_NAME_USERS = "ana";
    private  final  Long  ID_USERS = 1L;
    private  final  String  EMAIL_USERS = "ana@gmail.com";
    private  final  String PASSWORD_USERS ="12345678";
    private  String MOCK_TOKEN ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";


    @Before
    public  void  setupMock(){
         MockitoAnnotations.openMocks(this);
        when(usuarioService.findAll()).thenReturn(returnListUsersEntity());
        when(usuarioService.findById(ID_USERS)).thenReturn(returnObjectUserEntity());
        when(usuarioService.save(returnObjectUserEntity())).thenReturn(returnObjectUserEntity());
        when(usuarioService.update(ID_USERS,returnObjectUserEntity())).thenReturn(returnObjectUserEntity());

         when(mapper.toDtoList(returnListUsersEntity())).thenReturn(returnListUsersResponseDTO());
         when(mapper.toDto(returnObjectUserEntity())).thenReturn(returnObjectUserResponseDTO());
         when(mapper.toEntity(returnObjectUserRequestDTO())).thenReturn(returnObjectUserEntity());
    }

    @Test
    public void findAllUserMustReturnOk() throws Exception {
        assertEquals(returnListUsersResponseDTO(), usuarioFacade.findAll(MOCK_TOKEN));
    }

    @Test
    public void findByIdUserMustReturnOk() throws Exception{
        assertEquals(returnObjectUserResponseDTO(), usuarioFacade.findById(ID_USERS,MOCK_TOKEN));
    }

    @Test
    public void saveUserMustReturnOk() throws Exception{
        assertEquals(returnObjectUserResponseDTO(),usuarioFacade.save(returnObjectUserRequestDTO()));
    }

    @Test
    public void updateUserReturnOk() throws Exception{
        assertEquals(returnObjectUserResponseDTO(),usuarioFacade.update(ID_USERS,returnObjectUserRequestDTO(),MOCK_TOKEN));
    }

    @Test
    public void deleteByIdUserReturnOk() throws Exception{
        usuarioFacade.deleteById(ID_USERS,MOCK_TOKEN);
        verify(usuarioService,timeout(1)).deleteById(ID_USERS);
    }

    List<UsuarioResponseDTO> returnListUsersResponseDTO(){
        List<UsuarioResponseDTO> list = new ArrayList<>();
        list.add(returnObjectUserResponseDTO());
        return list;
    }

    List<UsuarioEntity> returnListUsersEntity(){
        List<UsuarioEntity> list = new ArrayList<>();
        list.add(returnObjectUserEntity());
        return list;
    }

    private UsuarioRequestDTO returnObjectUserRequestDTO(){
        return new UsuarioRequestDTO(MOCK_NAME_USERS,EMAIL_USERS,PASSWORD_USERS);
    }

    private UsuarioEntity returnObjectUserEntity(){
        return new UsuarioEntity(ID_USERS,MOCK_NAME_USERS,EMAIL_USERS,PASSWORD_USERS);
    }

    private UsuarioResponseDTO returnObjectUserResponseDTO(){
        return new UsuarioResponseDTO(ID_USERS,MOCK_NAME_USERS,EMAIL_USERS);
    }
}
