//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       Client client=new Client();
       client.Ajouter_client();



       System.out.println(Client.liste_client.get(0).getAdresse());


        System.out.println(client.getNom());
        client.Afficher();
        client.getNom();
}
}