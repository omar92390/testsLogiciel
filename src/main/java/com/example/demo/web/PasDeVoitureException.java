package com.example.demo.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Pas de voiture enregistrée")
public class PasDeVoitureException extends Exception {
    // Exception personnalisée pour renvoyer un code 404 HTTP
}