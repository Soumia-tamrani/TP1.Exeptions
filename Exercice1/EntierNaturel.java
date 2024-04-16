package com.GestionExeptions.Exercice1;

public class EntierNaturel {
    private int val;

    public EntierNaturel(int val)throws NombreNegatifException {
        if (val < 0) {
            throw new NombreNegatifException("La valeur ne peut pas être négative.",val);
        }
        this.val = val;    }
    // Accesseur en lecture
    public int getVal() {
        return val;
    }

    // Accesseur en écriture
    public void setVal(int val) throws NombreNegatifException {
        if (val < 0) {
            throw new NombreNegatifException("La valeur ne peut pas être négative.", val);
        }
        this.val = val;
    }

    // Méthode pour décrémenter
    public void decrementer() throws NombreNegatifException {
        if (val <= 0) {
            throw new NombreNegatifException("La valeur est déjà à zéro ou négative.", val);
        }
        val--;
    }
}



