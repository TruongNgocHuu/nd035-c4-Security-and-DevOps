package com.example.demo.controllers;

import com.example.demo.TestUtil;
import com.example.demo.model.persistence.Cart;
import com.example.demo.model.persistence.Item;
import com.example.demo.model.persistence.User;
import com.example.demo.model.persistence.repositories.CartRepository;
import com.example.demo.model.persistence.repositories.ItemRepository;
import com.example.demo.model.persistence.repositories.UserRepository;
import com.example.demo.model.requests.ModifyCartRequest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CartControllerTest {
    private CartController cartController;
    private UserRepository userRepository = mock(UserRepository.class);
    private CartRepository cartRepository = mock(CartRepository.class);
    private ItemRepository itemRepository = mock(ItemRepository.class);

    @Before
    public void setUp() {
        cartController = new CartController();
        TestUtil.injectObject(cartController, "userRepository", userRepository);
        TestUtil.injectObject(cartController, "cartRepository", cartRepository);
        TestUtil.injectObject(cartController, "itemRepository", itemRepository);

        User user = new User();
        Cart cart = new Cart();
        user.setId(1);
        user.setUsername("huu");
        user.setPassword("huutocdaihihi");
        user.setCart(cart);
        when(userRepository.findByUsername("huu")).thenReturn(user);

        Item item = new Item();
        item.setId(18L);
        item.setName("Round Widget");
        BigDecimal price = BigDecimal.valueOf(180.9);
        item.setPrice(price);
        item.setDescription("A widget");
        when(itemRepository.findById(18L)).thenReturn(java.util.Optional.of(item));
    }

    @Test
    public void testAddCard() {
        ModifyCartRequest request = new ModifyCartRequest();
        request.setItemId(18L);
        request.setQuantity(2);
        request.setUsername("huu");

        Cart cart = new Cart();
        cart.setTotal(BigDecimal.ONE);
        cart.setUser(new User());
        cart.setId(0L);
        cart.setItems(new ArrayList<>());

        User user = new User();
        user.setCart(cart);

        Item item = new Item();
        item.setName("");
        item.setPrice(BigDecimal.ONE);
        item.setDescription("");

        when(cartRepository.save(any())).thenReturn(cart);
        when(userRepository.findByUsername(any())).thenReturn(user);
        when(itemRepository.findById(any())).thenReturn(Optional.of(item));

        ResponseEntity<Cart> response = cartController.addTocart(request);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        Cart res = response.getBody();
        assertNotNull(res);
        assertEquals(BigDecimal.valueOf(3), res.getTotal());
    }

    @Test
    public void testCartRemove() {
        ModifyCartRequest request = new ModifyCartRequest();
        request.setItemId(18L);
        request.setQuantity(1);
        request.setUsername("huu");

        Cart cart = new Cart();
        cart.setTotal(BigDecimal.ONE);
        cart.setUser(new User());
        cart.setId(0L);
        cart.setItems(new ArrayList<>());

        User user = new User();
        user.setCart(cart);

        Item item = new Item();
        item.setName("");
        item.setPrice(BigDecimal.ONE);
        item.setDescription("");

        when(cartRepository.save(any())).thenReturn(cart);
        when(userRepository.findByUsername(any())).thenReturn(user);
        when(itemRepository.findById(any())).thenReturn(Optional.of(item));

        ResponseEntity<Cart> response = cartController.removeFromcart(request);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        Cart res = response.getBody();
        assertNotNull(res);
        assertEquals(BigDecimal.valueOf(0), res.getTotal());
    }
}
