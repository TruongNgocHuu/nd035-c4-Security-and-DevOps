package com.example.demo.model.persistence;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CartTest {

    @Test
    void test() {
        Cart cart = new Cart();
        cart.setTotal(new BigDecimal("0"));
        cart.setUser(new User());
        cart.setId(0L);
        cart.setItems(new ArrayList<>());

        assertNotNull(cart.getTotal());
        assertNotNull(cart.getUser());
        assertNotNull(cart.getId());
        assertNotNull(cart.getItems());
    }
}