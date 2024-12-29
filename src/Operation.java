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
    public Operation(){

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
                        int indiceCourant=scanner.nextInt()-1;
                        if( ValideIndiceCourant(indiceCourant) ){
                            //menuChoixOperationEpargne(indiceCourant);
                        }else{System.out.println("ce compte n'existe pas");}
                    } else {
                        System.out.println("la liste est vide ");
                    }
                    break;
                case 2:
                    if (!CompteEpargne.liste_compteEpargne.isEmpty()) {
                        CompteEpargne compteEpargne=new CompteEpargne();
                        compteEpargne.AfficherListeCompteEpargne();
                        System.out.print("Entrez le numero du compte : ");
                        int indiceEpargne=scanner.nextInt()-1;
                        if(ValideIndiceEpargne(indiceEpargne)){
                            menuChoixOperationEpargne(indiceEpargne);
                        }else{System.out.println("ce compte n'existe pas");}
                    } else {
                        System.out.println("la liste est vide ");
                    }
                    break;
                case 3:break;
            }
            }while(choix!=3);
        }
    public void menuChoixOperationEpargne(int indice){
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
                          double montantDepot=scanner.nextDouble();
                          operationDepotEpargne(montantDepot,indice);
                          break;

                  case 2: System.out.println("Veuillez entrer le montant que vous souhaitez retirer > ");
                          double montantRetrait=scanner.nextDouble();
                          operationRetirerEpargne(montantRetrait,indice);
                          break;
                  case 3: System.out.println("Veuillez entrer le montant que vous souhaitez verser > ");
                          double montantVerser=scanner.nextDouble();
                          operationVerser( montantVerser,indice);
                  case 4 : break;
              }
          }while(choix!=4);
    }
    public void operationDepotEpargne(double montantDepot,int indice) {
        CompteEpargne.liste_compteEpargne.get(indice).setSolde(CompteEpargne.liste_compteEpargne.get(indice).CalculSoldeActuel(CompteEpargne.liste_compteEpargne.get(indice)) + montantDepot);

        LocalDate date1= LocalDate.now();

        String CompteAssocie1="N : " +CompteEpargne.liste_compteEpargne.get(indice).getNumero()+" Compte Epargne";

        String type1="Depot";

        ListeOpertion.add(new Operation(type1, montant, date1 ,CompteAssocie1));
    }
    public void operationRetirerEpargne(double montantRetrait,int indice) {


        if(CompteEpargne.liste_compteEpargne.get(indice).CalculSoldeActuel(CompteEpargne.liste_compteEpargne.get(indice))>=montantRetrait){

            CompteEpargne.liste_compteEpargne.get(indice).setSolde(CompteEpargne.liste_compteEpargne.get(indice).CalculSoldeActuel(CompteEpargne.liste_compteEpargne.get(indice)) - montantRetrait);

            LocalDate date2= LocalDate.now();

            String CompteAssocie2="N : " +CompteEpargne.liste_compteEpargne.get(indice).getNumero()+" Compte Epargne";

            String type2="Retrait";

            ListeOpertion.add(new Operation(type2, montant, date2 ,CompteAssocie2));
        }
        else{System.out.println("Impossible de faire cette operation");}
    }
    public void operationVerser(double montantVerser,int indice){
        Scanner  scanner=new Scanner(System.in);
        if(CompteEpargne.liste_compteEpargne.get(indice).CalculSoldeActuel(CompteEpargne.liste_compteEpargne.get(indice))>=montantVerser){

            System.out.println("_______Menu de choix de type de compte_______");
            System.out.println("      1_Verser le montant sur un compte épargne");
            System.out.println("      2_Verser le montant sur un compte courant");
            System.out.println("________________________________________________");
            System.out.println("Entrez votre choix > ");
            int choix1= scanner.nextInt();
            switch (choix1){
                case 1:if(!CompteEpargne.liste_compteEpargne.isEmpty()){

                    CompteEpargne compteEpargne=new CompteEpargne();

                    compteEpargne.AfficherListeCompteEpargne();

                    System.out.print("Entrez le numero du compte : ");
                    int indiceEpargne=scanner.nextInt()-1;

                    if(ValideIndiceEpargne(indiceEpargne)){

                        LocalDate date3= LocalDate.now();

                        String CompteAssocie3="N : " +CompteEpargne.liste_compteEpargne.get(indice).getNumero()+" Compte Epargne";

                        String type3="virement";

                        ListeOpertion.add(new Operation(type3, montant, date3 ,CompteAssocie3));

                        CompteEpargne.liste_compteEpargne.get(indiceEpargne).setSolde(CompteEpargne.liste_compteEpargne.get(indiceEpargne).CalculNombreJourEcoules(CompteEpargne.liste_compteEpargne.get(indiceEpargne))+montantVerser);
                        CompteEpargne.liste_compteEpargne.get(indice).setSolde(CompteEpargne.liste_compteEpargne.get(indice).CalculNombreJourEcoules(CompteEpargne.liste_compteEpargne.get(indice))-montantVerser);

                    }else{System.out.println("ce compte n'existe pas");}

                }else{System.out.println("la liste est vide ");}
                    break;

                case 2:if(!CompteCourant.liste_compteCourant.isEmpty()){

                    CompteCourant compteCourant=new CompteCourant();

                    compteCourant.AfficherListeCompteCourant();

                    System.out.print("Entrez le numero du compte : ");
                    int indiceCourant=scanner.nextInt()-1;

                    if(ValideIndiceCourant(indiceCourant)){

                        LocalDate date3= LocalDate.now();

                        String CompteAssocie3="N : " +CompteEpargne.liste_compteEpargne.get(indice).getNumero()+" Compte Epargne";

                        String type3="virement";

                        ListeOpertion.add(new Operation(type3, montant, date3 ,CompteAssocie3));

                        double nouveauSoldeCourant=CompteCourant.liste_compteCourant.get(indiceCourant).CalculSoldeActuel(CompteCourant.liste_compteCourant.get(indiceCourant));

                        CompteCourant.liste_compteCourant.get(indiceCourant).setSolde(nouveauSoldeCourant+montantVerser);

                        double nouveauSoldeEpargne=CompteEpargne.liste_compteEpargne.get(indice).CalculSoldeActuel(CompteEpargne.liste_compteEpargne.get(indice));

                        CompteEpargne.liste_compteEpargne.get(indice).setSolde(nouveauSoldeEpargne-montantVerser);

                    }else{System.out.println("ce compte n'existe pas");}

                }else{System.out.println("la liste est vide ");}

                    break;
            }
        }else{System.out.println("cette operation est impossible");}
    }
    //la partie operation pour le compte courant
    public void operationDepotCourant(double montantDepot,int indice) {
        CompteCourant.liste_compteCourant.get(indice).setSolde(CompteCourant.liste_compteCourant.get(indice).CalculSoldeActuel(CompteCourant.liste_compteCourant.get(indice)) + montantDepot);

        LocalDate date1= LocalDate.now();

        String CompteAssocie1="N : " +CompteCourant.liste_compteCourant.get(indice).getNumero()+" Compte Courant";

        String type1="Depot";

        ListeOpertion.add(new Operation(type1, montant, date1 ,CompteAssocie1));
    }
    //
    public boolean ValideIndiceEpargne(int indice){
        if( indice >= 0 && indice < CompteEpargne.liste_compteEpargne.size()){
            return true;
        }
        return false;
    }
    public boolean ValideIndiceCourant(int indice){
        if( indice >=0 && indice < CompteCourant.liste_compteCourant.size() ){
            return true;
        }
        return false;
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
