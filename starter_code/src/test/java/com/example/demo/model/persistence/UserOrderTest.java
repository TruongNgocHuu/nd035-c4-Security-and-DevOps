package com.example.demo.model.persistence;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserOrderTest {

    @Test
    void test() {
        UserOrder order = new UserOrder();
        order.setId(0L);
        order.setItems(new ArrayList<>());
        order.setUser(new User());
        order.setTotal(new BigDecimal("0"));

        assertNotNull(order.getId());
        assertNotNull(order.getItems());
        assertNotNull(order.getUser());
        assertNotNull(order.getTotal());

    }
}