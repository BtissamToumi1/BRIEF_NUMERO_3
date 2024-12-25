public abstract class Compte {
    private long Numero;
    private double solde;
    private Client proprietaire;
    private int annee;
    private int mois;
    private int jour;

    public Compte(long numero, double solde, Client proprietaire, int annee, int mois, int jour) {
        Numero = numero;
        this.solde = solde;
        this.proprietaire = proprietaire;
        this.annee = annee;
        this.mois = mois;
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
