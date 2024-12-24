import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String telephone;
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

        Scanner scanner=new Scanner(System.in);

        System.out.println("entrez le id de client > ");
        int idd =scanner.nextInt();


        System.out.println("entrez le nom de client > ");
         String nom=scanner.nextLine();

        scanner.nextLine();

        System.out.println("entrez le prenom de client > ");
         String prenom=scanner.nextLine();

        System.out.println("entrez l'email de client > ");
        String email=scanner.nextLine();


        System.out.println("entrez la adresse  de client > ");
         String adresse=scanner.nextLine();

        System.out.println("entrez la adresse  de client > ");
        String telephone=scanner.nextLine();

        Client e =new Client(idd,nom,prenom,email,adresse,telephone);

        liste_client.add(e);

    }
    public void Afficher(){
        if(!liste_client.isEmpty()){
            for(int i=0;i<liste_client.size();i++){
                System.out.println("le Nom : "+liste_client.get(i).getNom());
            }
        }
        else{System.out.println("la liste est vide");}
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
