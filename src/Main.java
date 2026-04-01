import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Crée l'objet Simulateur
//        Simulateur coupeDuMonde = new Simulateur(10, 5);
//        coupeDuMonde.remplir();
//        System.out.println(coupeDuMonde);


//        Jeu421 j = new Jeu421();
//        j.jouer();

        JeuDeviner d = new JeuDeviner();
        d.jouer();
    }
}