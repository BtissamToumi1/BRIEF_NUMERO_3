import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class CompteCourant extends Compte{
    private static int compte=0;
    private double fraisBnacsires;
    public static ArrayList<CompteCourant> liste_compteCourant=new ArrayList<>();

    public CompteCourant(long id, double solde, Client proprietaire, int annee, int mois, int jour, double fraisBnacsires) {
        super(id,solde, proprietaire, annee, mois, jour);
        this.fraisBnacsires = fraisBnacsires;
    }
     public CompteCourant(){
     }
    //methode pour creer un compte apres le choix (est ce client est deja existant ou bien l'ajout du nouveau client)
    public void CreerCompte(Client client){

        Scanner scanner=new Scanner(System.in);

        int id=++compte;

        System.out.print("Entrez le solde initial > ");
        double solde=scanner.nextDouble();

        LocalDate DateActuelle=LocalDate.now();

        int annee =DateActuelle.getYear();
        int mois=DateActuelle.getMonthValue();
        int jour=DateActuelle.getDayOfMonth();

        System.out.print("Entrez les fraisBancaires > ");
        double frais= scanner.nextDouble();

        liste_compteCourant.add(new CompteCourant(id,solde,client,annee,mois,jour,frais));
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
    public void AfficherCompte(){
        Scanner scanner=new Scanner(System.in);

        if(!Client.liste_client.isEmpty()){

            System.out.println("les numeros des comptes commence de "+1+" a "+Client.liste_client.size()+1);

            System.out.println("Entrez l'indice de compte que vous souhaite afficher");
            int indice=scanner.nextInt()-1;

            if(indice>=0 && indice<Client.liste_client.size()){
                System.out.println("************************************************************************************");
                System.out.print("Compte : \t");
                System.out.println("ID : "+liste_compteCourant.get(indice).getNumero()+ "\t solde : "+CalculSoldeActuel(liste_compteCourant.get(indice))+" \t fraisBancaires : "+liste_compteCourant.get(indice).getFraisBnacsires());
                System.out.print("Client associe : \t");
                System.out.println( "ID : "+liste_compteCourant.get(indice).getProprietaire().getId()+"\t Nom : "+liste_compteCourant.get(indice).getProprietaire().getNom()+" \t Prenom : "+liste_compteCourant.get(indice).getProprietaire().getPrenom()+" \t email : "+liste_compteCourant.get(indice).getProprietaire().getEmail()+" \t telephone : "+liste_compteCourant.get(indice).getProprietaire().getTelephone()+" \t Adresse : "+liste_compteCourant.get(indice).getProprietaire().getAdresse());
                System.out.println("************************************************************************************");
            }
            else{System.out.println("ce compte n'existe pas");}
        }
        else{System.out.println("la liste est vide");}
    }
    public long CalculNombreJourEcoules(CompteCourant compte){
        LocalDate DateActuelle=LocalDate.now();
        LocalDate DateCreaationCompte=LocalDate.of(compte.getAnnee(),compte.getMois(),compte.getJour());
        return ChronoUnit.DAYS.between(DateCreaationCompte,DateActuelle);
    }
    public void AfficherListeCompteCourant(){
        if(!liste_compteCourant.isEmpty()){
            System.out.println("                 >la liste des comptes courants<       ");
            for(int i =0 ; i < liste_compteCourant.size() ; i++){
                System.out.println("************************************************************************************");
                System.out.print("Compte : \t");
                System.out.println("ID : "+liste_compteCourant.get(i).getNumero()+ "\t solde : "+CalculSoldeActuel(liste_compteCourant.get(i))+" \t fraisBancaires : "+liste_compteCourant.get(i).getFraisBnacsires());
                System.out.print("Client associe : \t");
                System.out.println( "ID : "+liste_compteCourant.get(i).getProprietaire().getId()+"\t Nom : "+liste_compteCourant.get(i).getProprietaire().getNom()+" \t Prenom : "+liste_compteCourant.get(i).getProprietaire().getPrenom()+" \t email : "+liste_compteCourant.get(i).getProprietaire().getEmail()+" \t telephone : "+liste_compteCourant.get(i).getProprietaire().getTelephone()+" \t Adresse : "+liste_compteCourant.get(i).getProprietaire().getAdresse());
            }
            System.out.println("************************************************************************************");
        }else{System.out.println("la liste est vide");}
    }
    public double CalculSoldeActuel(CompteCourant compte){
        return  compte.getSolde() - ( (int) ( CalculNombreJourEcoules(compte) / 30 ) * compte.getFraisBnacsires());
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
