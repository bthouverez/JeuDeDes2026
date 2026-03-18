import java.util.Random;

public class De {

    private int num;
    private int nbFaces;
    private int valeur;

    public De() {
        this.nbFaces = 6;
        this.num = 1;
        this.valeur = -1;
    }

    public De(int n) {
        this.nbFaces = n;
        this.num = 1;
        this.valeur = -1;
    }

    public De(int nu, int nf) {
        this.nbFaces = nf;
        this.num = nu;
        this.valeur = -1;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNbFaces() {
        return nbFaces;
    }

    public void setNbFaces(int nbFaces) {
        this.nbFaces = nbFaces;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "Le dé numéro " + num +
                " a " + nbFaces +
                " faces";
    }

    public void lancer() {
        Random rnd = new Random();
        this.valeur = rnd.nextInt(this.nbFaces) + 1;
    }
}
