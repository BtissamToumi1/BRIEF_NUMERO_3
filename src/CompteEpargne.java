import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class CompteEpargne extends Compte {
    private double tauxInteret;
    public static ArrayList<CompteEpargne> liste_compteEpargne=new ArrayList<>();

    public CompteEpargne( double solde, Client proprietaire, int annee, int mois, int jour, double tauxInteret) {
        super( solde, proprietaire, annee, mois, jour);
        this.tauxInteret = tauxInteret;
    }
    public CompteEpargne(){
    }
    public void ChoixClient(){
        Scanner scanner=new Scanner(System.in);
        int choix;
        Client client=new Client();
        do{
            System.out.println("-----------Les options possibles sont :------------");
            System.out.println("    1-creer un compte a un nouveau client");
            System.out.println("    2-creer un compte a un client deja existant");
            System.out.println("    3-Quitter");
            System.out.print("Entrez votre choix > ");
            choix=scanner.nextInt();
            switch (choix){
                case 1:{ client.Ajouter_client();
                          CreerCompte(client=Client.liste_client.get(Client.liste_client.size()-1));
                          break;
                          }
                case 2:{ client.Afficher();
                          if(!Client.liste_client.isEmpty()){
                              System.out.print("Entrez l'indice du client > ");
                              int indice= scanner.nextInt()-1;
                              if(indice>=0 && indice<Client.liste_client.size()){
                                  client=Client.liste_client.get(indice);
                                  CreerCompte(client);
                              }
                              else{System.out.println("ce client n'exite pas");}
                          }else{System.out.println("la liste des clients est vide");}
                          break;
                       }

                case 3: break;
            }
        }while(choix!=3);
    }
    //methode pour creer un compte apres le choix (est ce client est deja existant ou bien l'ajout du nouveau client)
    public void CreerCompte(Client client){

        Scanner scanner=new Scanner(System.in);


        System.out.print("Entrez le solde initial > ");
        double solde=scanner.nextDouble();

        LocalDate DateActuelle=LocalDate.now();

        int annee =DateActuelle.getYear();
        int mois=DateActuelle.getMonthValue();
        int jour=DateActuelle.getDayOfMonth();

        System.out.print("Entrez le taux interet > ");
        double tauxInteret= scanner.nextDouble();

       //new CompteEpargne(numero , solde,client,annee,mois,jour);
       liste_compteEpargne.add(new CompteEpargne(solde,client,annee,mois,jour,tauxInteret));
    }
    //methode pour afficher les informations d'un compte bancaire
    public void AfficherCompte(){
        Scanner scanner=new Scanner(System.in);

        if(!Client.liste_client.isEmpty()){

            System.out.println("les numeros des comptes commence de "+1+" a "+Client.liste_client.size()+1);

            System.out.println("Entrez l'indice de compte que vous souhaite afficher");
            int indice=scanner.nextInt()-1;

            if(indice>=0 && indice<Client.liste_client.size()){
                System.out.println("************************************************************************************");
                System.out.print("Compte : \t");
                System.out.println("ID : "+liste_compteEpargne.get(indice).getNumero()+ "\t solde : "+CalculSoldeActuel(liste_compteEpargne.get(indice))+" \t tauxInteret : "+liste_compteEpargne.get(indice).getTauxInteret());
                System.out.print("Client associe : \t");
                System.out.println( "ID : "+liste_compteEpargne.get(indice).getProprietaire().getId()+"\t Nom : "+liste_compteEpargne.get(indice).getProprietaire().getNom()+" \t Prenom : "+liste_compteEpargne.get(indice).getProprietaire().getPrenom()+" \t email : "+liste_compteEpargne.get(indice).getProprietaire().getEmail()+" \t telephone : "+liste_compteEpargne.get(indice).getProprietaire().getTelephone()+" \t Adresse : "+liste_compteEpargne.get(indice).getProprietaire().getAdresse());
                System.out.println("************************************************************************************");
            }
            else{System.out.println("ce compte n'existe pas");}
        }
        else{System.out.println("la liste est vide");}
    }
    //methode pour calculer le nombre de jour ecoules entre la date de creation du compte et la date actuelle
    public long CalculNombreJourEcoules(CompteEpargne compte){
         LocalDate DateActuelle=LocalDate.now();
         LocalDate DateCreaationCompte=LocalDate.of(compte.getAnnee(),compte.getMois(),compte.getJour());
         return ChronoUnit.DAYS.between(DateCreaationCompte,DateActuelle);
    }
    public double CalculSoldeActuel(CompteEpargne compte){
        return  compte.getSolde() + ( (int) ( CalculNombreJourEcoules(compte) / 365 ) * compte.getTauxInteret());

    }
    public void AfficherListeCompteEpargne(){
        if(!liste_compteEpargne.isEmpty()){
            System.out.println("                 >la liste des comptes Epargne<       ");
            for(int i =0 ; i < liste_compteEpargne.size() ; i++){
                System.out.println("************************************************************************************");
                System.out.print("Compte : \t");
                System.out.println("ID : "+liste_compteEpargne.get(i).getNumero()+ "\t solde : "+CalculSoldeActuel(liste_compteEpargne.get(i))+" \t tauxInteret : "+liste_compteEpargne.get(i).getTauxInteret());
                System.out.print("Client associe : \t");
                System.out.println( "ID : "+liste_compteEpargne.get(i).getProprietaire().getId()+"\t Nom : "+liste_compteEpargne.get(i).getProprietaire().getNom()+" \t Prenom : "+liste_compteEpargne.get(i).getProprietaire().getPrenom()+" \t email : "+liste_compteEpargne.get(i).getProprietaire().getEmail()+" \t telephone : "+liste_compteEpargne.get(i).getProprietaire().getTelephone()+" \t Adresse : "+liste_compteEpargne.get(i).getProprietaire().getAdresse());
            }
            System.out.println("************************************************************************************");
        }else{System.out.println("la liste est vide");}
    }
    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public static ArrayList<CompteEpargne> getListe_compteEpargne() {
        return liste_compteEpargne;
    }

    public static void setListe_compteEpargne(ArrayList<CompteEpargne> liste_compteEpargne) {
        CompteEpargne.liste_compteEpargne = liste_compteEpargne;
    }
}
