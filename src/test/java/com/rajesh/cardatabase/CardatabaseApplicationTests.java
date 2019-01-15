package com.rajesh.cardatabase;

import com.rajesh.cardatabase.web.CarController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class CardatabaseApplicationTests {

    @Autowired
    private CarController controller;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

}

