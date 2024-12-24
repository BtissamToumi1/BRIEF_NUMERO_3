//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       Client client=new Client();
       client.Ajouter_client();
       client.Afficher();
       client.Modifier();
        client.Afficher();
       client.Supprimer();
        client.Afficher();
    }
 }