package com.GestionExeptions.Exercice2;

public class CompteBancaire {
    protected String numeroCompte;
    protected double solde;
    protected String nomTitulaire;

    public CompteBancaire(String numeroCompte, double solde, String nomTitulaire) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.nomTitulaire = nomTitulaire;
    }

    // Méthode pour déposer de l'argent sur le compte
    public void deposer(double montant) {
        this.solde += montant;
        System.out.println("Dépôt de " + montant + " effectué sur le compte " + numeroCompte + ". Nouveau solde : " + solde);
    }

    // Méthode pour retirer de l'argent du compte
    public void retirer(double montant) throws FondsInsuffisantsException {
        if (montant > solde) {
            throw new FondsInsuffisantsException("Solde insuffisant pour effectuer le retrait sur le compte " + numeroCompte);
        }
        this.solde -= montant;
        System.out.println("Retrait de " + montant + " effectué sur le compte " + numeroCompte + ". Nouveau solde : " + solde);
    }

    // Méthode pour afficher le solde du compte
    public void afficherSolde() {
        System.out.println("Solde du compte " + numeroCompte + " : " + solde);
    }

    // Méthode pour transférer de l'argent vers un autre compte
    public void transferer(CompteBancaire destinataire, double montant) throws FondsInsuffisantsException, CompteInexistantException {
        if (montant > solde) {
            throw new FondsInsuffisantsException("Solde insuffisant pour effectuer le transfert sur le compte " + numeroCompte);
        }
        if (destinataire == null) {
            throw new CompteInexistantException("Le compte destinataire n'existe pas.");
        }
        retirer(montant);
        destinataire.deposer(montant);
        System.out.println("Transfert de " + montant + " effectué du compte " + numeroCompte + " vers le compte " + destinataire.numeroCompte);
    }
}

// Classe représentant un compte courant
class CompteCourant extends CompteBancaire {
    private double decouvertAutorise;

    public CompteCourant(String numeroCompte, double solde, String nomTitulaire, double decouvertAutorise) {
        super(numeroCompte, solde, nomTitulaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    // Méthode pour retirer de l'argent du compte courant avec autorisation de découvert
    @Override
    public void retirer(double montant) throws FondsInsuffisantsException {
        if (montant > (solde + decouvertAutorise)) {
            throw new FondsInsuffisantsException("Solde insuffisant pour effectuer le retrait sur le compte courant " + numeroCompte);
        }
        this.solde -= montant;
        System.out.println("Retrait de " + montant + " effectué sur le compte courant " + numeroCompte + ". Nouveau solde : " + solde);
    }
}

// Classe représentant un compte épargne
class CompteEpargne extends CompteBancaire {
    private double tauxInteret;

    public CompteEpargne(String numeroCompte, double solde, String nomTitulaire, double tauxInteret) {
        super(numeroCompte, solde, nomTitulaire);
        this.tauxInteret = tauxInteret;
    }

    // Méthode pour calculer et ajouter les intérêts au solde du compte épargne
    public void calculerInterets() {
        double interets = solde * tauxInteret / 100;
        this.solde += interets;
        System.out.println("Intérêts de " + interets + " ajoutés au compte épargne " + numeroCompte + ". Nouveau solde : " + solde);
    }
}



