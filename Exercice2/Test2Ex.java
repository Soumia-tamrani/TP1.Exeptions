package com.GestionExeptions.Exercice2;

import com.GestionExeptions.Exercice2.*;

import java.util.ArrayList;

public class Test2Ex {
    public static void main(String[] args) throws FondsInsuffisantsException, CompteInexistantException {
        // Création d'une liste de comptes bancaires
        ArrayList<CompteBancaire> comptes = new ArrayList<>();

        // Ajout de comptes
        CompteCourant compteCourant1 = new CompteCourant("123456", 1000, "John Doe", 500);
        CompteEpargne compteEpargne1 = new CompteEpargne("789012", 5000, "Jane Smith", 2.5);
        comptes.add(compteCourant1);
        comptes.add(compteEpargne1);

        // Suppression de comptes
        comptes.remove(compteEpargne1);

        // Effectuer des opérations sur les comptes
        compteCourant1.deposer(500);
        compteCourant1.retirer(1500);
        compteCourant1.transferer(compteEpargne1, 200);
    }
}

