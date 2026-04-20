package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {

    @Test
        void creerVoiture(){
            
            Voiture v = new Voiture("Tesla", 50000);

            
            assertEquals("Tesla", v.getMarque());
            assertEquals(50000, v.getPrix());

            
            v.setPrix(45000);
            assertEquals(45000, v.getPrix());
        }
}