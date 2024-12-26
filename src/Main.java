//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CompteEpargne compte=new CompteEpargne();
        Client client=new Client();
        //client.Ajouter_client();
        compte.ChoixClient();
        client.Afficher();
        compte.AfficherCompte();
        //client.Ajouter_client();
        //client.Afficher();
    }
 }