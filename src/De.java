import java.util.ArrayList;
import java.util.Random;

public class De {

    private int num;
    private int nbFaces;
    private int valeur;
    private boolean pipe;

    public De() {
        this.nbFaces = 6;
        this.num = 1;
        this.valeur = -1;
        this.pipe = false;
    }

    public De(int n) {
        this.nbFaces = n;
        this.num = 1;
        this.valeur = -1;
        this.pipe = false;
    }

    public De(int nu, int nf) {
        this.nbFaces = nf;
        this.num = nu;
        this.valeur = -1;
        this.pipe = false;
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

    public boolean isPipe() {
        return this.pipe;
    }

    public void setPipe(boolean p) { this.pipe = p; }

    // changer pipé : si vrai → FAUX et inversement
    public void togglePipe() {
        this.pipe = !this.pipe;
    }

    public void piper() { this.pipe = true;}

    @Override
    public String toString() {
        return "Le dé numéro " + num +
                " a " + nbFaces +
                " faces";
    }

    public void lancer() {
        Random rnd = new Random();
        if(this.pipe) {
            ArrayList<Integer> tab = new ArrayList<>();
            tab.add(1); tab.add(2); tab.add(4);
            int indice = rnd.nextInt(tab.size());
            this.valeur =  tab.get(indice);
        } else {
            this.valeur = rnd.nextInt(this.nbFaces) + 1;
        }
    }
}
