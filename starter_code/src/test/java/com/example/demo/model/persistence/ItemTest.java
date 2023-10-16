package com.example.demo.model.persistence;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void test() {
        Item item = new Item();
        item.setId(0L);
        item.setName("");
        item.setPrice(new BigDecimal("0"));
        item.setDescription("");

        assertNotNull(item.getId());
        assertNotNull(item.getName());
        assertNotNull(item.getPrice());
        assertNotNull(item.getDescription());
        assertTrue(item.hashCode() != 0);
        assertNotEquals(item, new Item());
    }
}