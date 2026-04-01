import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choix = -1;

        while(choix != 0) {
            System.out.println("""
                A quel jeu voulez-vous jouer ?
                
                1. Coupe du monde de lancer de dé
                2. Le 421
                3. Le dé à deviner
                4. Les suites
                0. Quitter
                """);
            choix = sc.nextInt();

            if(choix == 1) {
                System.out.println("C'est parti pour la coupe du monde de lancer de dés !");
                // Crée l'objet Simulateur
                Simulateur coupeDuMonde = new Simulateur(10, 5);
                coupeDuMonde.remplir();
                System.out.println(coupeDuMonde);
            } else if(choix == 2) {
                System.out.println("C'est parti pour un 421 !");
                Jeu421 j = new Jeu421();
                j.jouer();
            } else if(choix == 3) {
                System.out.println("Le dé à deviner, c'est parti !");
                JeuDeviner d = new JeuDeviner();
                d.jouer();
            } else if(choix == 4) {
                System.out.println("Les suites ? Pas facile ! Let's go !!");
                System.out.println("Combien de joueurs ?");
                JeuSuites s = new JeuSuites(sc.nextInt());
                s.jouer();
            } else if(choix == 0) {
                System.out.println("Ooohhh non !! Déjà ? :'(");
            } else {
                System.out.println("Je crois qu'il y a erreur ! Tu sais lire ?");
            }
        }



    }
}