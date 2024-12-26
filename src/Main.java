//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CompteCourant compte1=new CompteCourant();
        CompteEpargne compte2=new CompteEpargne();
        //Client client=new Client();
        compte1.ChoixClient();
        //compte1.ChoixClient();
        compte1.AfficherListeCompteCourant();
        compte2.ChoixClient();
        compte2.AfficherListeCompteEpargne();
    }
 }