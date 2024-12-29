import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       Scanner scan=new Scanner(System.in);
       CompteCourant comptecourant=new CompteCourant();
       CompteEpargne compteepargne=new CompteEpargne();
       Client client=new Client();
       Operation operation=new Operation();
       comptecourant.ChoixClient();
       compteepargne.ChoixClient();
       operation.MenuChoixTypeCompte();
       comptecourant.AfficherListeCompteCourant();
       compteepargne.AfficherListeCompteEpargne();
       /*int choix=0,choix1=0,choix2=0,choix3=0;
       do{
          System.out.println("----------Menu Gestion Bancaire--------------");
          System.out.println("          1-Gestion Client                   ");
          System.out.println("          2-Gestion Compte                   ");
          System.out.println("          3-Gestion operation                ");
          System.out.println("          4-Quitter                          ");
          try{
             System.out.println("Entrez votre choix > ");
             choix= scan.nextInt();
             switch (choix){
             case 1:do{
                System.out.println("----------Menu Gestion Client--------------");
                System.out.println("          1-Ajouter Client                  ");
                System.out.println("          2-Modifier Compte                 ");
                System.out.println("          3-Afficher la liste des clients   ");
                System.out.println("          4-Supprimer client                ");
                System.out.println("          5-Menu Gestion Bancaire   ");
                try{
                   System.out.println("Entrez votre choix > ");
                   choix1= scan.nextInt();
                   switch (choix1){
                      case 1:client.Ajouter_client();break;
                      case 2:client.Modifier();break;
                      case 3:client.Afficher();break;
                      case 4:client.Supprimer();break;
                      default:System.out.println("Au revoir ");break;
                   }
                }
                catch (InputMismatchException e) {
                   System.out.println(" Entrez invalide ");
                   scan.next();
                }
             }while(choix1!=5);
                break;
             case 2:do{
                System.out.println("----------Menu Gestion Compte--------------");
                System.out.println("          1-Creer Compte Epargne            ");
                System.out.println("          2-Creer Compte Courant            ");
                System.out.println("          3-Afficher un Compte Epargne      ");
                System.out.println("          4-Afficher un Compte Courant      ");
                System.out.println("          5-Afficher liste Comte Courant    ");
                System.out.println("          6-Afficher liste Comte Epargne    ");
                System.out.println("          7-Menu Gestion Bancaire");
                try{
                   System.out.println("Entrez votre choix > ");
                   choix2= scan.nextInt();
                   switch (choix2){
                      case 1:compteepargne.ChoixClient(); break;
                      case 2:comptecourant.ChoixClient();  break;
                      case 3:comptecourant.AfficherCompte(); break;
                      case 4:client.Supprimer(); break;
                      case 5: comptecourant.AfficherListeCompteCourant();   break;
                      case 6: compteepargne.AfficherListeCompteEpargne();  break;
                      default:System.out.println("Au revoir "); break;
                   }
                }
                catch (InputMismatchException e) {
                   System.out.println(" Entrez invalide ");
                   scan.next();
                }
             }while(choix2!=7);
                break;

             case 3:do{
                System.out.println("----------Menu Gestion Operation--------------");
                System.out.println("          1-Effectuer un Depot sur un Compte Epargne       ");
                System.out.println("          2-Effectuer un Depot sur un Compte Courant       ");
                System.out.println("          3-Effectuer un Retrait sur un Compte Epargne     ");
                System.out.println("          4-Effectuer un Retrait sur un Compte Courant     ");
                System.out.println("          5-Effectuer un virement sur un Compte Epargne    ");
                System.out.println("          6-Effectuer un virement sur un Comte Epargne     ");
                System.out.println("          7-Menu Gestion Bancaire");
                try{
                   System.out.println("Entrez votre choix > ");
                   choix3= scan.nextInt();
                   switch (choix2){
                      case 1: break;
                      case 2: break;
                      case 3: break;
                      case 4: break;
                      case 5: break;
                      case 6: break;
                      default:System.out.println("Au revoir "); break;
                   }
                }
                catch (InputMismatchException e) {
                   System.out.println(" Entrez invalide ");
                   scan.next();
                }
             }while(choix3!=7);
                break;
                default: System.out.println("Au revoir");break;
             }
          }
          catch (InputMismatchException e) {
                System.out.println(" Entrez invalide ");
                scan.next();
             }
       }while(choix!=4);*/
    }
 }