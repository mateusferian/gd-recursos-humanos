package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.entities.UsuarioEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.UsuarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceImplTest {

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    private  final  String MOCK_NAME_USERS = "ana";
    private  final  Long  ID_USERS = 1L;
    private  final  String  MOCK_EMAIL_USERS = "ana@gmail.com";
    private  final  String MOCK_PASSWORD_USERS ="12345678";
    private  final  String ENCRYPTED_PASSWORD = "!@#QWEewq321";

    @Before
    public void setupMock() {
        MockitoAnnotations.openMocks(this);
        when(usuarioRepository.findAll()).thenReturn(returnlistUsersEntity());
        when(usuarioRepository.findById(ID_USERS)).thenReturn(Optional.of(returnObjectUsersEntity()));
        when(usuarioRepository.save(returnObjectUsersEntityWithEncryptedPassword())).thenReturn(returnObjectUsersEntityWithEncryptedPassword());


        when(passwordEncoder.encode(MOCK_PASSWORD_USERS)).thenReturn(ENCRYPTED_PASSWORD);
    }

    @Test
    public void findAllUsersMustReturnOk(){
        assertEquals(returnlistUsersEntity(),usuarioService.findAll());
    }

    @Test
    public void findByUsersMustReturnOk (){
        assertEquals(returnObjectUsersEntity(),usuarioService.findById(ID_USERS));
    }

    @Test
    public void saveUsersMustReturnOk() {
        assertEquals(returnObjectUsersEntityWithEncryptedPassword(), usuarioService.save(returnObjectUsersEntity()));
    }

    @Test
    public void updateUsersMustReturnOk() {
        assertEquals(returnObjectUsersEntityWithEncryptedPassword(), usuarioService.update(ID_USERS,returnObjectUsersEntity()));
    }

    private List<UsuarioEntity> returnlistUsersEntity(){
        List<UsuarioEntity> findAll = new ArrayList<>();
            findAll.add(returnObjectUsersEntity());
        return  findAll;
    }

    private UsuarioEntity returnObjectUsersEntity(){
        return new UsuarioEntity(ID_USERS,MOCK_NAME_USERS,MOCK_EMAIL_USERS,MOCK_PASSWORD_USERS);
    }

    private UsuarioEntity returnObjectUsersEntityWithEncryptedPassword(){
        return new UsuarioEntity(ID_USERS,MOCK_NAME_USERS,MOCK_EMAIL_USERS,ENCRYPTED_PASSWORD);
    }
}
