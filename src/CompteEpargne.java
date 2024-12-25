import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
public class CompteEpargne extends Compte {
    private double tauxInteret;
    private static int compte=0;
    public static ArrayList<CompteEpargne> liste_compteEpargne=new ArrayList<>();

    public CompteEpargne(long numero, double solde, Client proprietaire, int annee, int mois, int jour, double tauxInteret) {
        super(numero, solde, proprietaire, annee, mois, jour);
        this.tauxInteret = tauxInteret;
    }

    public void AjouterCompteEpargne(){
        Scanner scanner=new Scanner(System.in);
        int choix;
        Client client=new Client();
        do{
            System.out.println("-----------Les options possibles sont :------------");
            System.out.println("    1-creer un compte a un client deja existant ");
            System.out.println("    2-creer un compte a un nouveau client ");
            System.out.println("    3-Quitter");
            System.out.print("Entrez votre choix > ");
            choix=scanner.nextInt();
            switch (choix){
                case 1:{ client.Ajouter_client(); break;}
                case 2:{ client.Afficher();
                          if(!Client.liste_client.isEmpty()){
                              System.out.print("Entrez l'indice du client > ");
                              int indice= scanner.nextInt()-1;
                              if(indice>=0 && indice<Client.liste_client.size()){
                                  client=Client.liste_client.get(indice);
                              }
                              else{System.out.println("ce client n'exite pas");}
                          }else{System.out.println("la liste des clients est vide");}
                       }

                case 3: break;
            }
        }while(choix!=3);
    }
    
    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public static int getCompte() {
        return compte;
    }

    public static void setCompte(int compte) {
        CompteEpargne.compte = compte;
    }

    public static ArrayList<CompteEpargne> getListe_compteEpargne() {
        return liste_compteEpargne;
    }

    public static void setListe_compteEpargne(ArrayList<CompteEpargne> liste_compteEpargne) {
        CompteEpargne.liste_compteEpargne = liste_compteEpargne;
    }
}
