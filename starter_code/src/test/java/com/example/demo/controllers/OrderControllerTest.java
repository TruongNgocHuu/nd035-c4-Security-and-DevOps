package com.example.demo.controllers;

import com.example.demo.model.persistence.Cart;
import com.example.demo.model.persistence.User;
import com.example.demo.model.persistence.UserOrder;
import com.example.demo.model.persistence.repositories.OrderRepository;
import com.example.demo.model.persistence.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class OrderControllerTest {
    @InjectMocks
    OrderController controller;
    @Mock
    private UserRepository userRepository;

    @Mock
    private OrderRepository orderRepository;

    @Test
    void submit() {
        User user = new User();
        Cart cart = new Cart();
        cart.setTotal(new BigDecimal("0"));
        cart.setUser(user);
        cart.setId(0L);
        cart.setItems(new ArrayList<>());
        user.setId(1);
        user.setUsername("huu");
        user.setPassword("jj");
        user.setCart(cart);

        List<UserOrder> orders = new ArrayList();
        orders.add(new UserOrder());

        when(userRepository.findByUsername(any())).thenReturn(user);
        when(orderRepository.findByUser(user)).thenReturn(orders);

        Assertions.assertNotNull(controller.submit("1"));
    }

    @Test
    void getOrdersForUser() {
        User user = new User();
        Cart cart = new Cart();
        user.setId(1);
        user.setUsername("huu");
        user.setPassword("jj");
        user.setCart(cart);
        when(userRepository.findByUsername(any())).thenReturn(user);

        Assertions.assertNotNull(controller.getOrdersForUser("123"));
    }
}