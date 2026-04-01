import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Simulateur coupeDuMonde = new Simulateur(10, 5);
        coupeDuMonde.remplir();
        System.out.println(coupeDuMonde);
    }
}