import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Simulateur coupeDuMonde = new Simulateur(10, 5);
//        coupeDuMonde.remplir();
//        System.out.println(coupeDuMonde);


        // /////////// //
        // Jeu du 421  //
        // /////////// //

        // Crée l'objet Jeu421
        Jeu421 j = new Jeu421();
        // Lance tous les dés
        j.lancerTousLesDes();
        // Affiche l'état du jeu après le premier lancé
        System.out.println(j);
        // Initialisation du nombre de coups
        int nbCoups = 1;
        // Initialisation d'un scanner pour lire des entrées utilisateur
        Scanner sc = new Scanner(System.in);

        // Le jeu tourne tant que la partie n'est pas gagnée
        while(!j.partieGagnee()) {
            // Demande à l'utilisateur quel dé il souhaite relancer
            System.out.println("Quel dé relancer ?\n\n1: Le premier\n" +
                    "2: Le second\n3: Le troisième\n4: Tous !\n");

            // Récupère le choix de l'utilisateur et relance le(s) dé(s) correspondant(s)
            int choix =  sc.nextInt();
            if(choix >= 1 && choix < 4) j.lancerUnDe(choix);
            else if(choix == 4) j.lancerTousLesDes();
            else System.out.println("Nope !");

            // Incrémente le nombre de coups
            nbCoups++;
            System.out.println(j);
        }

        // Si on sort de la boucle, c'est que la partie est gagnée, on affiche le nombre de coups
        System.out.println("C'est gagné !! En "+ nbCoups+" coups");
    }
}