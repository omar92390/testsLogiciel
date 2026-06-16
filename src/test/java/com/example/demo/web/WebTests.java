package com.example.demo.web;

import com.example.demo.data.Voiture;
import com.example.demo.service.Statistique;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StatistiqueController.class)
public class WebTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Statistique statistiqueService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAjouterVoiture() throws Exception {
        Voiture voiture = new Voiture("Ferrari", 250000);

        mockMvc.perform(post("/voiture")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(voiture)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetStatistiquesSansVoiture() throws Exception {
        // On force le service à lever l'exception arithmétique (division par zéro)
        doThrow(new ArithmeticException()).when(statistiqueService).prixMoyen();

        mockMvc.perform(get("/statistique"))
                .andExpect(status().isNotFound());
    }
}