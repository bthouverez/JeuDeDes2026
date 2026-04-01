import java.util.Scanner;

public class JeuDeviner {
    private De leDe;

    public JeuDeviner()
    {
        leDe = new De(100);
        leDe.lancer();
    }

    public void jouer() {
        Scanner sc = new Scanner(System.in);
        int nbCoups = 0;
        int guess = 0;
        while(guess != leDe.getValeur()) {
            System.out.println("Alors, c'est combien ?");
            guess = sc.nextInt();
            nbCoups++;
            if(guess > leDe.getValeur())
                System.out.println("Non, c'est plus petit");
            else if(guess < leDe.getValeur())
                System.out.println("Non, c'est plus grand");
            else
                System.out.println("Oui, c'est ça ! "+nbCoups+" coups");
        }

    }
}
