package com.rajesh.cardatabase;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class CarRestTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Ignore("Should be enabled after authentication is enabled")
    public void testAuthentication() throws Exception {
        //Test authentication with correct credentials
        this.mockMvc.perform(post("/login").content("{\"username\":\"admin\", \"password\":\"admin\"}"))
                .andDo(print())
                .andExpect(status().isOk());

        //Test authentication with wrong credentials
        this.mockMvc.perform(post("/login").content("{\"username\":\"user\", \"password\":\"usser\"}"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
}
