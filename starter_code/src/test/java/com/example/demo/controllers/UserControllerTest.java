package com.example.demo.controllers;

import com.example.demo.TestUtil;
import com.example.demo.model.persistence.User;
import com.example.demo.model.persistence.repositories.CartRepository;
import com.example.demo.model.persistence.repositories.UserRepository;
import com.example.demo.model.requests.CreateUserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserControllerTest {
    private UserController userController;
//    private CartController cartController;
    private UserRepository userRepositor = mock(UserRepository.class);
    private CartRepository cartRepository = mock(CartRepository.class);
    private BCryptPasswordEncoder encoder = mock(BCryptPasswordEncoder.class);

    @BeforeEach
    public void setUp() {
        userController = new UserController();
//        cartController = new CartController();
        TestUtil.injectObject(userController, "userRepository", userRepositor);
        TestUtil.injectObject(userController, "cartRepository", cartRepository);
        TestUtil.injectObject(userController, "bCryptPasswordEncoder", encoder);
//        TestUtil.injectObject(cartController, "cartRepository", cartRepository);
    }

    @Test
    public void testCreateUser() throws Exception {
        when(encoder.encode("huutocdaihihi")).thenReturn("HashPassword");
        CreateUserRequest r = new CreateUserRequest();
        r.setUsername("huu");
        r.setPassword("huutocdaihihi");
        r.setConfirmPassword("huutocdaihihi");
        final ResponseEntity<User> responseEntity = userController.createUser(r);
        User user = responseEntity.getBody();
        when(userRepositor.findByUsername("huu")).thenReturn(user);
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        User u = responseEntity.getBody();
        Assertions.assertNotNull(u);
        Assertions.assertEquals(0, u.getId());
        Assertions.assertEquals("huu", u.getUsername());
        Assertions.assertEquals("HashPassword", u.getPassword());
        ResponseEntity<User> responseEntity1 = userController.findByUserName("huu");
        Assertions.assertNotNull(responseEntity1);
    }
}
