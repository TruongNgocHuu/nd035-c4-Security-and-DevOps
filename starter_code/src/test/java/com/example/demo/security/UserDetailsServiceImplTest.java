package com.example.demo.security;

import com.example.demo.model.persistence.User;
import com.example.demo.model.persistence.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
class UserDetailsServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    UserDetailsServiceImpl userDetailsService;

    @Test
    void loadUserByUsername() {
        User user = new User();
        user.setPassword("111");
        user.setId(0L);
        user.setUsername("123");

        Mockito.when(userRepository.findByUsername(any())).thenReturn(user);
        Assertions.assertNotNull(userDetailsService.loadUserByUsername("1"));
    }
}