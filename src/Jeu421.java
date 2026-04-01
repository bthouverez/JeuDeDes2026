import java.util.Scanner;

public class Jeu421 {
    // Le 421 se joue avec 3 dés
    private De leDe1;
    private De leDe2;
    private De leDe3;

    public  Jeu421() {
        // Initialisation des 3 dés à 6 faces
        leDe1 = new De(6);
        leDe2 = new De(6);
        leDe3 = new De(6);
    }

    // Fonction permettant de lancer tous les dés
    public void lancerTousLesDes() {
        leDe1.lancer();
        leDe2.lancer();
        leDe3.lancer();
    }

    // Fonction premettant de lancer un seul dé dont le
    // numéro est passé en paramètre
    public void lancerUnDe(int n) {
        if(n == 1) leDe1.lancer();
        else if(n == 2) leDe2.lancer();
        else if(n == 3) leDe3.lancer();
        else System.out.println("Erreur");
    }

    // Fonction vérifiant si la partie est gagnée
    public boolean partieGagnee() {
        // Plusieurs façons de faire ça, il faut vérifier qu'on ait bien 4, 2 et 1
        // Technique de sioux ici, si la somme des 3 valeurs des dés vaut 7 et que
        // ces valeurs sont différentes, c'est qu'on a la bonne combinaison
        return (leDe1.getValeur() != leDe2.getValeur()
        && leDe2.getValeur() != leDe3.getValeur()
        && leDe3.getValeur() != leDe1.getValeur()
        && leDe1.getValeur() + leDe2.getValeur() + leDe3.getValeur() == 7);
    }

    // Affichage de l'état du jeu, les valeurs des 3 dés
    @Override
    public String toString() {
        String s = "";
        s += "Dé 1 : " + leDe1.getValeur() + "\n";
        s += "Dé 2 : " + leDe2.getValeur() + "\n";
        s += "Dé 3 : " + leDe3.getValeur() + "\n";
        return s;
    }

    public void jouer() {
        // Lance tous les dés
        this.lancerTousLesDes();
        // Affiche l'état du jeu après le premier lancé
        System.out.println(this);
        // Initialisation du nombre de coups
        int nbCoups = 1;
        // Initialisation d'un scanner pour lire des entrées utilisateur
        Scanner sc = new Scanner(System.in);

        // Le jeu tourne tant que la partie n'est pas gagnée
        while(!this.partieGagnee()) {
            // Demande à l'utilisateur quel dé il souhaite relancer
            System.out.println("""
                    Quel dé relancer ?
                    
                    1: Le premier
                    2: Le second
                    3: Le troisième
                    4: Tous !
                    """);

            // Récupère le choix de l'utilisateur et relance le(s) dé(s) correspondant(s)
            int choix =  sc.nextInt();
            if(choix >= 1 && choix < 4) this.lancerUnDe(choix);
            else if(choix == 4) this.lancerTousLesDes();
            else System.out.println("Nope !");

            // Incrémente le nombre de coups
            nbCoups++;
            System.out.println(this);
        }

        // Si on sort de la boucle, c'est que la partie est gagnée, on affiche le nombre de coups
        System.out.println("C'est gagné !! En "+ nbCoups+" coups");
    }
}
