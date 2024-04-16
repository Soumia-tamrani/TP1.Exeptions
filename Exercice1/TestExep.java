package com.GestionExeptions.Exercice1;

import com.GestionExeptions.Exercice1.EntierNaturel;
import com.GestionExeptions.Exercice1.NombreNegatifException;

public class TestExep {

        public static void main(String[] args) {
            try {
                // Création d'un objet EntierNaturel
                EntierNaturel entier = new EntierNaturel(5);
                System.out.println("Valeur actuelle : " + entier.getVal());

                // Modification de la valeur
                entier.setVal(10);
                System.out.println("Nouvelle valeur : " + entier.getVal());

                // Décrémentation
                entier.decrementer();
                System.out.println("Après décrémentation : " + entier.getVal());

                // Tentative d'initialisation avec une valeur négative
                EntierNaturel entierNegatif = new EntierNaturel(-3);
            } catch (NombreNegatifException e) {
                System.out.println("Erreur : " + e.getMessage());
                System.out.println("Valeur erronée : " + e.getValeurErronee());
            }
        }
}
