//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        De monDe = new De();
        System.out.println("Mon dé : " + monDe);

        for (int ii = 0; ii < 50; ii++) {
            monDe.lancer();
            System.out.println("Valeur du dé : "+monDe.getValeur());
        }
    }
}