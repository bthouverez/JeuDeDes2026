import java.util.ArrayList;

public class Simulateur {
    private De leDe;
    private ArrayList<ArrayList<Integer>> scores;

    // Constructeur par défaut
    public Simulateur() {
        // Initialise le tableau des scores
        this.scores = new ArrayList<>();
        // Initialise le Dé qui permettra de faire les lancers
        this.leDe = new De(6);
    }

    // Génère tous les lancers de tous les joueurs dans le tableau de scores
    public void remplir() {
        scores.add(new ArrayList<>());
        // boucle 20 fois pour les 20 joueurs
        for(int ii = 0; ii < 20; ii++) {
            // Crée un nouvel ArrayList pour les scores du joueur courant
            ArrayList<Integer> liste = new ArrayList<>();
            liste.add(-1);
            // Boucle 10 fois pour les 10 lancers du joueur
            for(int jj = 0; jj < 10; jj++) {
                // Lance le dé et ajoute sa valeur à la liste
                this.leDe.lancer();
                liste.add(this.leDe.getValeur());
            }
            // Ajoute la liste des scores du joueur au tableau global
            this.scores.add(liste);
        }
    }

    // Affiche les lancers d'un joueur
    public void afficherLancersJoueur(int n) {
        System.out.print("Joueur "+n+" : ");
        for (int jj = 1; jj <= 10; jj++) {
            System.out.print(this.scores.get(n).get(jj)+" ");
        }
    }

    // Affiche les lancers de tous les joueurs
    public void afficher() {
        for (int ii = 1; ii <= 20; ii++) {
            this.afficherLancersJoueur(ii);
            System.out.println();
        }
    }

    // Calcule le score total d'un joueur
    public int totalJoueur(int n) {
        // Déclare la variable qui permettra de calculer le score
        int score = 0;
        // Parcours de tous les lancers du joueur
        for (int ii = 1; ii <= 10; ii++) {
            // Calcul de son score total
            score += this.scores.get(n).get(ii);
        }
        return score;
    }

    // Calcule le score total d'un joueur
    public int nombreDeSixJoueur(int n) {
        // Déclare la variable qui permettra de calculer le nombre de 6
        int nb6 = 0;
        // Parcours de tous les lancers du joueur
        for (int ii = 1; ii <= 10; ii++) {
            // Ajoute à la variable si un lancer du joueur vaut 6
            if(this.scores.get(n).get(ii) == 6) {
                nb6++;
            }
        }
        return nb6;
    }
}
