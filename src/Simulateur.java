import java.util.ArrayList;

public class Simulateur {
    private De leDe;
    private ArrayList<ArrayList<Integer>> scores;

    public Simulateur() {
        this.scores = new ArrayList<>();
        this.leDe = new De(6);
    }

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
    

    public void afficher() {

        for (int ii = 1; ii <= 20; ii++) {
            System.out.print("Joueur "+ii+" : ");
            for (int jj = 1; jj <= 10; jj++) {
                System.out.print(this.scores.get(ii).get(jj)+" ");
            }
            System.out.println();
        }
    }
}
