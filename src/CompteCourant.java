import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
public class CompteCourant extends Compte{
    private double fraisBnacsires;
    private static int compte=0;
    public static ArrayList<CompteCourant> liste_compteCourant=new ArrayList<>();

    public CompteCourant(long numero, double solde, Client proprietaire, int annee, int mois, int jour, double fraisBnacsires) {
        super(numero, solde, proprietaire, annee, mois, jour);
        this.fraisBnacsires = fraisBnacsires;
    }
     public CompteCourant(){
     }
    //methode pour creer un compte apres le choix (est ce client est deja existant ou bien l'ajout du nouveau client)
    public void CreerCompte(Client client){

        Scanner scanner=new Scanner(System.in);
        int numero=++compte;

        System.out.print("Entrez le solde initial > ");
        double solde=scanner.nextDouble();

        LocalDate DateActuelle=LocalDate.now();

        int annee =DateActuelle.getYear();
        int mois=DateActuelle.getMonthValue();
        int jour=DateActuelle.getDayOfMonth();

        System.out.print("Entrez les fraisBancaires > ");
        double frais= scanner.nextDouble();

        //new CompteEpargne(numero , solde,client,annee,mois,jour);
        liste_compteCourant.add(new CompteCourant(numero,solde,client,annee,mois,jour,frais));
    }
    public double getFraisBnacsires() {
        return fraisBnacsires;
    }

    public void setFraisBnacsires(double fraisBnacsires) {
        this.fraisBnacsires = fraisBnacsires;
    }

    public static ArrayList<CompteCourant> getListe_comte_courant() {
        return liste_compteCourant;
    }

    public static void setListe_comte_courant(ArrayList<CompteCourant> liste_comte_courant) {
        CompteCourant.liste_compteCourant = liste_comte_courant;
    }
}
