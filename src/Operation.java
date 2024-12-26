import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;
public class Operation {
    private String type;
    private Double montant;
    private LocalDate date;
    private String CompteAssocie;
    private ArrayList<Operation> ListeOpertion=new ArrayList<>();

    public Operation(String type, Double montant, LocalDate date, String CompteAssocie) {
        this.type = type;
        this.montant = montant;
        this.date = date;
        this.CompteAssocie = CompteAssocie;
        ListeOpertion = new ArrayList<>();
    }

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
    public void OperationEpargne(int indice){
          Scanner  scanner=new Scanner(System.in);
          int choix=0;
          do{
              System.out.println("_________________Menu de Choix de Type d'operation_______________________");
              System.out.println("                  1-Depot                                                ");
              System.out.println("                  2-Retrait                                               ");
              System.out.println("                  3-Virement                                              ");
              System.out.println("                  4-Quitter                                             ");
              System.out.println("Entrez votre choix > ");
              choix=scanner.nextInt();
              switch (choix){
                  case 1: System.out.println("Veuillez entrer le montant que vous souhaitez déposer > ");
                          double montantD=scanner.nextDouble();
                          //pour modifier le solde initial apres
                          CompteEpargne.liste_compteEpargne.get(indice).setSolde(CompteEpargne.liste_compteEpargne.get(indice).getSolde() + montant);

                          LocalDate date1= LocalDate.now();

                          String CompteAssocie1="N : " +CompteEpargne.liste_compteEpargne.get(indice).getNumero()+" Compte Epargne";

                          String type1="Depot";

                          ListeOpertion.add(new Operation(type1, montant, date1 ,CompteAssocie1));

                         break;

                  case 2: System.out.println("Veuillez entrer le montant que vous souhaitez retirer > ");
                          double montantR=scanner.nextDouble();

                          if(CompteEpargne.liste_compteEpargne.get(indice).getSolde()>=montantR){

                              CompteEpargne.liste_compteEpargne.get(indice).setSolde(CompteEpargne.liste_compteEpargne.get(indice).getSolde() - montant);

                              LocalDate date2= LocalDate.now();

                              String CompteAssocie2="N : " +CompteEpargne.liste_compteEpargne.get(indice).getNumero()+" Compte Epargne";

                              String type2="Retrait";

                              ListeOpertion.add(new Operation(type2, montant, date2 ,CompteAssocie2));
                          }
                          else{System.out.println("Impossible de faire cette operation");}

                          break;
                  case 3: System.out.println("Veuillez entrer le montant que vous souhaitez virser > ");
                          double montantV=scanner.nextDouble();
                  case 4:break;
              }
          }while(choix!=4);
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNumeroCompteAssocie() {
        return CompteAssocie;
    }

    public void setCompteAssocie(String CompteAssocie) {
        this.CompteAssocie = CompteAssocie;
    }

    public ArrayList<Operation> getListeOpertion() {
        return ListeOpertion;
    }

    public void setListeOpertion(ArrayList<Operation> listeOpertion) {
        ListeOpertion = listeOpertion;
    }
}
