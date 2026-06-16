// Rendu final du TP2 Mockito
package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StatistiqueTests {

    @InjectMocks
    private StatistiqueImpl statistiqueService;

    @Test
    public void testAjouterUneVoiture() {
        Voiture voiture = new Voiture("Tesla", 50000);
        statistiqueService.ajouter(voiture);

        Echantillon result = statistiqueService.prixMoyen();
        
        assertEquals(1, result.getNombreDeVoitures());
        assertEquals(50000, result.getPrixMoyen());
    }

    @Test
    public void testPrixMoyenAvecPlusieursVoitures() {
        Voiture tesla = new Voiture("Tesla", 50000);
        Voiture renault = new Voiture("Renault", 10000);

        statistiqueService.ajouter(tesla);
        statistiqueService.ajouter(renault);

        Echantillon result = statistiqueService.prixMoyen();
        
        assertEquals(2, result.getNombreDeVoitures());
        assertEquals(30000, result.getPrixMoyen());
    }

    @Test
    public void testPrixMoyenSansVoiture() {
        assertThrows(ArithmeticException.class, () -> {
            statistiqueService.prixMoyen();
        });
    }
}