public abstract class Compte {
    private long Numero;
    private double solde;
    private Client proprietaire;
    private int annee;
    private int mois;
    private int jour;
    private static int compte=0;
    public Compte(){}
    public Compte(double solde, Client proprietaire, int annee, int mois, int jour) {
        Numero = ++compte;
        this.solde = solde;
        this.proprietaire = proprietaire;
        this.annee = annee;
        this.mois = mois;
        this.jour = jour;
    }

    public static int getCompte() {
        return compte;
    }

    public static void setCompte(int compte) {
        Compte.compte = compte;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public long getNumero() {
        return Numero;
    }

    public void setNumero(long numero) {
        Numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Client getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Client proprietaire) {
        this.proprietaire = proprietaire;
    }
}
