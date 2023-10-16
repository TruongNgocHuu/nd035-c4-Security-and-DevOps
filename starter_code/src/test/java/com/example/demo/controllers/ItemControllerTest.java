package com.example.demo.controllers;

import com.example.demo.model.persistence.Item;
import com.example.demo.model.persistence.repositories.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

class ItemControllerTest {

    ItemController itemController;

    @Mock
    private ItemRepository itemRepository;

    @Test
    void getItems() {
        List<Item> list = new ArrayList<>();
        when(itemRepository.findAll()).thenReturn(list);

        Assertions.assertNotNull(itemController.getItems());
    }

    @Test
    void getItemById() {
        when(itemRepository.findById(any())).thenReturn(Optional.of(new Item()));

        Assertions.assertNotNull(itemController.getItemById(1L));
    }

    @Test
    void getItemsByName() {
        List<Item> list = new ArrayList<>();

        when(itemRepository.findByName(any()))
                .thenReturn(list);

        Assertions.assertNotNull(itemController.getItemsByName("name"));
    }
}