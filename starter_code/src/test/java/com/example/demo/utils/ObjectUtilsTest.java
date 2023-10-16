package com.example.demo.utils;

import com.example.demo.model.persistence.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectUtilsTest {

    @Test
    void objectToJson() {
        Item i = new Item();

        assertNotNull(ObjectUtils.objectToJson(i));
    }
}