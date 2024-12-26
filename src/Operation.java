import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Operation {
    private String type;
    private Double montant;
    private Date date;
    private int NumeroCompteAssocie;
    private ArrayList<Operation> ListeOpertion=new ArrayList<>();
    public void MenuChoixTypeCompte(){
        Scanner scanner=new Scanner(System.in);
        int choix=0;
        do {
            System.out.println("_____________Menu choix type de compte_________________");
            System.out.println("             1-Compte Courant                          ");
            System.out.println("             2-Compte Epargne                          ");
            System.out.println("             3-pas de choix                            ");
            System.out.println("Entrez votre choix > ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    if (!CompteCourant.liste_compteCourant.isEmpty()) {
                        CompteCourant comptecourant=new CompteCourant();
                        comptecourant.AfficherListeCompteCourant();
                        System.out.print("Entrez le numero du compte : ");
                        //je dois ajouter ici un test sur le numero de compte
                        //apres je vais appele la methode operation
                        //apres je vais choisir quel type de operation
                    } else {
                        System.out.println("la liste est vide ");
                    }
                    break;
                case 2:
                    if (!CompteEpargne.liste_compteEpargne.isEmpty()) {
                        CompteEpargne compteEpargne=new CompteEpargne();
                        compteEpargne.AfficherListeCompteEpargne();
                        System.out.print("Entrez le numero du compte : ");
                        //je dois ajouter ici un test sur le numero de compte
                        //apres je vais appele la methode operation
                        //apres je vais choisir quel type de operation
                    } else {
                        System.out.println("la liste est vide ");
                    }
                    break;
                case 3:break;
            }
            }while(choix!=3);
        }

    public void Operation(){

    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumeroCompteAssocie() {
        return NumeroCompteAssocie;
    }

    public void setNumeroCompteAssocie(int numeroCompteAssocie) {
        NumeroCompteAssocie = numeroCompteAssocie;
    }

    public ArrayList<Operation> getListeOpertion() {
        return ListeOpertion;
    }

    public void setListeOpertion(ArrayList<Operation> listeOpertion) {
        ListeOpertion = listeOpertion;
    }
}
