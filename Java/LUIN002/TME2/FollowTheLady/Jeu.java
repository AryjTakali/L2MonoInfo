import java.util.Random;

public class Jeu {
    private Emplacement gauche, droit, milieu;
    private Carte cible;
    private int win, game;

    public Jeu() {
        cible = new Carte("Dame");
        Carte c1 = new Carte();
        Carte c2 = new Carte();
        gauche = new Emplacement("gauche", cible);
        milieu = new Emplacement("milieu", c1);
        droit = new Emplacement("droit", c2);
        win = 0;
        game = 0;
    }

    public void echange(Emplacement a, Emplacement b) {
        Carte temp = a.enlever();
        a.poser(b.enlever());
        b.poser(temp);
    }

    public void echanger(int i, int j) {
        if (i + j == 1)
            echange(gauche, milieu);
        else if (i + j == 2)
            echange(gauche, droit);
        else
            echange(droit, milieu);
    }

    public void melanger() {
        int i = (int) (Math.random() * 3);
        echanger(i, 0);
    }

    public void melanger(int n) {
        for (int i = 0; i < n; i++) {
            melanger();
        }
        printGame();
        System.out.println(pick());
        game += 1;
    }

    public int getNbGame() {
        return game;
    }

    public int getNbWin() {
        return win;
    }

    public void repeat(int n) {
        for (int i = 0; i < n; i++)
            melanger(10);
        System.out.println("\nSur " + n + " partie nous avons gagne " + win + " fois");
        double moy = (double) win / (double) n;
        System.out.println("Soit une moyenne de " + moy);
        moy = Math.round(100 * moy);
        System.out.println("Soit un pourcentage de " + moy + "%");
    }

    public void printGame() {
        System.out.println("\n" + gauche.getCarte() + "\t" + milieu.getCarte() + "\t" + droit.getCarte());
    }

    public String pick() {
        String s = "you pick ";
        int i = (int) (Math.random() * 3);
        if (i == 0) {
            s += gauche.toString() + "\n";
            s += gauche.getCarte().equals("Dame") ? "You win!" : "You lost";
            win += gauche.getCarte().equals("Dame") ? 1 : 0;
        } else if (i == 1) {
            s += milieu.toString() + "\n";
            s += milieu.getCarte().equals("Dame") ? "You win!" : "You lost";
            win += milieu.getCarte().equals("Dame") ? 1 : 0;
        } else {
            s += droit.toString() + "\n";
            s += droit.getCarte().equals("Dame") ? "You win!" : "You lost";
            win += droit.getCarte().equals("Dame") ? 1 : 0;
        }
        return s;
    }

    public static void main(String[] args) {
        Jeu game = new Jeu();
        game.repeat(1000);
    }
}