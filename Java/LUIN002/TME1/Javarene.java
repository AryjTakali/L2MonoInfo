
public class Javarene {
    Javamon p1;
    Javamon p2;

    public Javarene(Javamon p1, Javamon p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Javarene() {
        p1 = new Javamon("player1");
        p2 = new Javamon("player2");
    }

    public String isWinner() {
        if (p1.estMort() == true) {
            return p2.getName() + " is the winner!";
        } else
            return p1.getName() + " is the winner!";

    }

    public void turn(Javamon att, Javamon def) {
        double attack, defense;
        int damage;

        attack = att.getAttaque();
        defense = def.getDefense();
        damage = (int) (((attack - defense) * 10) / 1);
        if (defense >= attack) {
            System.out.println(att.getName() + " missed his attack\n");
        } else {
            def.infligerDommage(damage);
            System.out.println(att.getName() + " has inflicted " + damage + "damages to " + def.getName());
        }
    }

    public void showScores(Javamon p1, Javamon p2){

        System.out.println(p1.getName() + " : " + p1.getPV() + "PV\t\t" + p2.getName() + " : " + p2.getPV() + "PV\n");
    }

    public void combat() {
        boolean turn = true;
        int round = 0;
        p1.initCombat();
        p2.initCombat();

        while (p1.estMort() == false && p2.estMort() == false) {
            if (turn) {
                turn(p1, p2);
                round++;
            } else {
                turn(p2, p1);
            }
            turn = !turn;
            System.out.println("\nIt's the "+ round + "th round.\nThe current score is :");
            showScores(p1,p2);
        }
        System.out.println(isWinner());
    }

    public static void main(String[] args) {
        Javarene combat1 = new Javarene();
        combat1.combat();
    }
}