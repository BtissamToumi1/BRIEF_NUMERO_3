import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
public class CompteCourant extends Compte{
    private double fraisBnacsires;
    public static ArrayList<CompteCourant> liste_comte_courant=new ArrayList<>();

    public CompteCourant(long numero, double solde, Client proprietaire, int annee, int mois, int jour, double fraisBnacsires) {
        super(numero, solde, proprietaire, annee, mois, jour);
        this.fraisBnacsires = fraisBnacsires;
    }

    public double getFraisBnacsires() {
        return fraisBnacsires;
    }

    public void setFraisBnacsires(double fraisBnacsires) {
        this.fraisBnacsires = fraisBnacsires;
    }

    public static ArrayList<CompteCourant> getListe_comte_courant() {
        return liste_comte_courant;
    }

    public static void setListe_comte_courant(ArrayList<CompteCourant> liste_comte_courant) {
        CompteCourant.liste_comte_courant = liste_comte_courant;
    }
}
