import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String telephone;
    private static int compte=0;
    public static ArrayList<Client> liste_client=new ArrayList<>();
    //contructeur
    public Client(int id, String nom, String prenom, String email, String adresse, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.telephone = telephone;
    }
    //constructeur vide
    public  Client(){
    }
    //methode ajouter
    public void Ajouter_client(){
        int idd=++compte;
        Scanner scanner=new Scanner(System.in);
        System.out.println("__________le client Numero"+compte+" :__________");
        System.out.print("entrez le nom de client > ");
         String nom=scanner.nextLine();


        System.out.print("entrez le prenom de client > ");
         String prenom=scanner.nextLine();

        System.out.print("entrez l'email de client > ");
        String email=scanner.nextLine();


        System.out.print("entrez la adresse  de client > ");
         String adresse=scanner.nextLine();

        System.out.print("entrez le telephone  de client > ");
        String telephone=scanner.nextLine();


        Client e =new Client(idd,nom,prenom,email,adresse,telephone);

        liste_client.add(e);

    }
    //methode Afficher liste des clients
    public void Afficher(){
        if(!Client.liste_client.isEmpty()){
            System.out.println();
            System.out.println("                          >la liste des clients<                      ");
            for (int i=0;i<liste_client.size();i++){
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("ID : "+liste_client.get(i).getId()+"\t Nom : "+liste_client.get(i).getNom()+" \t Prenom : "+liste_client.get(i).getPrenom()+" \t email : "+liste_client.get(i).getEmail()+" \t elephone : "+liste_client.get(i).getTelephone());
            }
                System.out.println("------------------------------------------------------------------------------------");
        }
        else{
            System.out.println();
            System.out.println("la liste est vide");
        }
    }
    //
    public void Modifier(){
        Scanner scanner= new Scanner(System.in);
        Afficher();
        if(!Client.liste_client.isEmpty()){
            System.out.print("entrez l'identifiant de client que tu veux modifier > ");
            int indice=scanner.nextInt()-1;
            if(indice>=0 && indice<liste_client.size()) {
                int choix = 0;
                do {
                    System.out.println("       Menu de Modification      ");
                    System.out.println("       1_Modifier Nom            ");
                    System.out.println("       2_Modifier Prenom          ");
                    System.out.println("       3_Modifier Email           ");
                    System.out.println("       4_Modifier Adresse         ");
                    System.out.println("       5_Modifier Telephone       ");
                    System.out.println("       6_Quitter                  ");
                    System.out.print("Entrez votre choix > ");
                    choix = scanner.nextInt();
                    scanner.nextLine();
                    switch (choix) {
                        case 1:
                            System.out.print("par quoi pouvez vous remplacez ("+liste_client.get(indice).getNom()+") : ");
                            String nom=scanner.nextLine();
                            Client.liste_client.get(indice).setNom(nom);
                            break;
                        case 2:
                            System.out.print("par quoi pouvez vous remplacez ("+liste_client.get(indice).getPrenom()+") : ");
                            String prenom=scanner.nextLine();
                            liste_client.get(indice).setPrenom(prenom);
                            break;
                        case 3:
                            System.out.print("par quoi pouvez vous remplacez ("+liste_client.get(indice).getEmail()+") : ");
                            String email=scanner.next();
                            setEmail(email);
                            break;
                        case 4:
                            System.out.print("par quoi pouvez vous remplacez ("+liste_client.get(indice).getAdresse()+") : ");
                            setAdresse(scanner.nextLine());
                            break;
                        case 5:
                            System.out.print("par quoi pouvez vous remplacez ("+liste_client.get(indice).getTelephone()+") : ");
                            String telephone=scanner.next();
                            setTelephone(telephone);
                            break;
                        case 6:break;
                    }
                } while (choix != 6);
            }
            else {
                System.out.println();
                System.out.println("ce client n'existe pas");}
        }
        else{
            System.out.println();
            System.out.println("la liste est vide ");
        }
    }
    //methode Supprimer un client
    public void Supprimer(){
        Scanner scanner=new Scanner(System.in);
        if(!Client.liste_client.isEmpty()){
            Afficher();
            System.out.print("entrez l'identifiant de client que tu veux supprimer >");
            int indice=scanner.nextInt()-1;
            if(indice>=0 && indice<liste_client.size()){
                Client.liste_client.remove(indice);
            }
            else{ System.out.println();
                System.out.println("ce client n'existe pas ");
            }
        }
        else{
            System.out.println();
            System.out.println("la liste est vide ");}
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
