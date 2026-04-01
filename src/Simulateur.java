import java.util.ArrayList;

public class Simulateur {
    private De leDe;
    private ArrayList<ArrayList<Integer>> scores;
    private int nbJoueurs;
    private int nbLancers;

    // Constructeur par défaut
    public Simulateur() {
        // Initialise le tableau des scores
        this.scores = new ArrayList<>();
        // Initialise le Dé qui permettra de faire les lancers
        this.leDe = new De(6);

        // Par défaut, initialise le nombre de joueurs à 3 et le nombre de lancers à 5
        this.nbJoueurs = 3;
        this.nbLancers = 5;
    }

    // Constructeur paramétre du nombre de joueurs et de lancers
    public Simulateur(int j, int l) {
        this.scores = new ArrayList<>();
        this.leDe = new De(6);
        this.nbJoueurs = j;
        this.nbLancers = l;
    }

    // Génère tous les lancers de tous les joueurs dans le tableau de scores
    public void remplir() {
        scores.add(new ArrayList<>());
        // boucle this.nbJoueurs fois pour les this.nbJoueurs joueurs
        for(int ii = 0; ii < this.nbJoueurs; ii++) {
            // Crée un nouvel ArrayList pour les scores du joueur courant
            ArrayList<Integer> liste = new ArrayList<>();
            liste.add(-1);
            // Boucle this.nbLancers fois pour les this.nbLancers lancers du joueur
            for(int jj = 0; jj < this.nbLancers; jj++) {
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
        for (int jj = 1; jj <= this.nbLancers; jj++) {
            System.out.print(this.scores.get(n).get(jj)+" ");
        }
    }

    // Affiche les lancers de tous les joueurs
    public void afficher() {
        for (int ii = 1; ii <= this.nbJoueurs; ii++) {
            this.afficherLancersJoueur(ii);
            System.out.println();
        }
    }

    // Calcule le score total d'un joueur
    public int totalJoueur(int n) {
        // Déclare la variable qui permettra de calculer le score
        int score = 0;
        // Parcours de tous les lancers du joueur
        for (int ii = 1; ii <= this.nbLancers; ii++) {
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
        for (int ii = 1; ii <= this.nbLancers; ii++) {
            // Ajoute à la variable si un lancer du joueur vaut 6
            if(this.scores.get(n).get(ii) == 6) {
                nb6++;
            }
        }
        return nb6;
    }

    public String toString() {
        String r = "###################################\n";
        r +=       "     RÉSULTATS COUPE DU MONDE    \n";
        r += "  " + this.nbJoueurs + " joueurs, " + this.nbLancers + " lancers chacun  \n";
        r +=       "###################################\n\n";
        for(int ii = 1; ii <= this.nbJoueurs; ii++) {
            r += "Joueur " + ii + " : ";
            r += this.totalJoueur(ii) + " -> ";
            for(int jj = 1; jj <= this.nbLancers; jj++) {
                r += this.scores.get(ii).get(jj) + " ";
            }
            r += "[" + this.nombreDeSixJoueur(ii) + "]\n";
        }
        return r;
    }
}
