package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StatistiqueTests {

    @Mock
    private Echantillon echantillon;

    @InjectMocks
    private StatistiqueImpl statistiqueService;

    @Test
    public void testPrixMoyen() {
        
        List<Voiture> voitures = new ArrayList<>();
        voitures.add(new Voiture("Tesla", 50000));
        voitures.add(new Voiture("Renault", 10000));

        
        Mockito.when(echantillon.getCars()).thenReturn(voitures);

        
        int prixMoyen = statistiqueService.prixMoyen();

        
        assertEquals(30000, prixMoyen);
    }
}