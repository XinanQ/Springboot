package org.example.controller;

import model.User;
import service.UserService;
import controller.UserController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void addUser() throws Exception {
        User user = new User();
        user.setUsername("John");
        user.setGender(1);
        user.setAge(30);

        doNothing().when(userService).addUser(any(User.class));

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"John\",\"gender\":1,\"age\":30,\"createUser\":\"admin\",\"createUserName\":\"Admin\"}"))
                .andExpect(status().isOk());

        verify(userService, times(1)).addUser(any(User.class));
    }

    @Test
    void deleteUser() throws Exception {
        doNothing().when(userService).removeUser(anyLong());

        mockMvc.perform(delete("/users/1"))
                .andExpect(status().isOk());

        verify(userService, times(1)).removeUser(anyLong());
    }

    @Test
    void updateUser() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setUsername("John Doe");
        user.setGender(1);
        user.setAge(31);

        doNothing().when(userService).modifyUser(any(User.class));

        mockMvc.perform(put("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"username\":\"John Doe\",\"gender\":1,\"age\":31,\"updateUser\":\"admin\",\"updateUserName\":\"Admin\"}"))
                .andExpect(status().isOk());

        verify(userService, times(1)).modifyUser(any(User.class));
    }

    @Test
    void getUserById() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setUsername("John");
        user.setGender(1);
        user.setAge(30);

        when(userService.getUserById(anyLong())).thenReturn(user);

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.username").value("John"))
                .andExpect(jsonPath("$.gender").value(1))
                .andExpect(jsonPath("$.age").value(30));

        verify(userService, times(1)).getUserById(anyLong());
    }

    @Test
    void getAllUsers() throws Exception {
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("John");
        user1.setGender(1);
        user1.setAge(30);

        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("Jane");
        user2.setGender(2);
        user2.setAge(25);

        List<User> users = Arrays.asList(user1, user2);

        when(userService.getAllUsers()).thenReturn(users);

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].username").value("John"))
                .andExpect(jsonPath("$[0].gender").value(1))
                .andExpect(jsonPath("$[0].age").value(30))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].username").value("Jane"))
                .andExpect(jsonPath("$[1].gender").value(2))
                .andExpect(jsonPath("$[1].age").value(25));

        verify(userService, times(1)).getAllUsers();
    }
}

