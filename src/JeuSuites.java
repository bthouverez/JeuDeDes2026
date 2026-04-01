import java.util.ArrayList;

public class JeuSuites {
    // Bien que le jeu se joue avec 6 dés, on en a qu'un dans la classe
    // qui sera lancé 6 fois à la suite
    private De leDe;
    // Tableau permettant de stocker les 6 scores d'un lancé
    private ArrayList<Integer> valeurs;
    // Tableau permettant de stocker les scores totaux des joueurs
    private ArrayList<Integer> scores;

    // Le constructeur attend le nombre de joueurs
    public  JeuSuites(int n){
        // Initialise le dé à 6 faces
        this.leDe = new De(6);
        // Initialise le tableau des valeurs
        this.valeurs = new ArrayList<>();
        // Initialise le tableau des scores totaux
        this.scores = new ArrayList<>();
        // Remplis le tableau des scores totaux avec des 0 pour chaque joueur
        for(int i = 0; i < n; i++){
            this.scores.add(0);
        }
    }

    // Fonction simulant un lancé de 6 dés
    public void lancer() {
        // Le tableau des valeurs est remis à 0
        this.valeurs.clear();
        System.out.print("Lancement : ");
        // Le dé est lancé 6 fois pour simuler 6 dés simultanés
        // Les valeurs obtenues sont stockées dans le tableau des valeurs
        for(int i = 0; i < 6; i++) {
            this.leDe.lancer();
            this.valeurs.add(this.leDe.getValeur());
        }
        System.out.println(this.valeurs);
    }

    // Fonction calculant le score obtenu pour un lancé de 6 dés
    public int calculeScore() {
        // Les valeurs sont dans un premier temps triées
        this.valeurs.sort(Integer::compareTo);
        // Puis les doublons sont enlevés
        ArrayList<Integer> sansDoublons = new ArrayList<>();
        for (Integer v : this.valeurs) {
            if (!sansDoublons.contains(v)) sansDoublons.add(v);
        }
        this.valeurs = sansDoublons;

        // Ainsi, on peut vérifier dans le tableau si les valeurs obtenues sont bien consécutives
        // Le compteur ii sert justement à compter combien de valeurs consécutives sont obtenues
        int ii = 0;
        while(ii < this.valeurs.size()) {
            if(this.valeurs.get(ii) != ii+1) break;
            ii++;
        }
        // En fonction du nombre de valeurs consécutives, le score du lancé peut être calculé,
        // affiché et surtout renvoyé
        int score = ii == 0 ? 0 : (ii-1)*5;
        System.out.println("Score du lancé : "+ score);
        return score;
    }

    // Fonction principale du jeu
    public void jouer() {
        // Variable permettant de savoir à quel joueur est le tour
        int joueur = 0;
        // Le jeu se poursuit à l'infini, tant qu'un joueur n'a pas atteint 100
        while(true) {
            System.out.println("\n\nAu tour du joueur " + (joueur + 1));
            System.out.println("Appuyer sur Entrée pour lancer les dés");
            new java.util.Scanner(System.in).nextLine();
            // Pour chaque tour de chaque joueur :
            // Les 6 dés sont lancés
            this.lancer();
            // Le score total est mis à jour
            this.scores.set(joueur, this.scores.get(joueur) +this.calculeScore());
            System.out.println("Score total : "+ this.scores.get(joueur));
            // On vérifie si la partie est terminée, si un joueur a atteint 100
            if(this.scores.get(joueur) >= 100) {
                // Si oui, on affiche un message de victoire
                System.out.println("Le joueur "+ (joueur + 1) + " a gagné");
                // Et on force la sortie de la boucle infinie
                break;
            }
            // Sinon, on passe au joueur suivant
            joueur = (joueur + 1) % this.scores.size();
        }
    }

}
