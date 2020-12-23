public class TestTracteur {
    public static void test(Tracteur t1, Tracteur t2) {
        System.out.println("Mon premier Tracteur !\n" + t1.toString());
        System.out.println("Mon second Tracteur !\n" + t2.toString());
        t2.peindre("rouge");
        System.out.println("\nApres modification de t2: \n");
        System.out.println("Mon premier Tracteur !\n" + t1.toString());
        System.out.println("Mon second Tracteur !\n" + t2.toString());
    }

    public static void main(String[] args) {
        Roue r1 = new Roue(120);
        Roue r2 = new Roue(120);
        Roue pr1 = new Roue();
        Roue pr2 = new Roue();
        Cabine c1 = new Cabine(10, "bleue");
        Cabine c2 = new Cabine(10, "bleue");
        Tracteur t1 = new Tracteur(c1, r1, r2, pr1, pr2);
        Tracteur t2 = new Tracteur(c2, r1, r2, pr1, pr2);
        /*
         * ==>test reference //ce premier test montre qu'il est necessaire de creer une
         * nouvelle instance avec la commande new afin d'avoir 2 objets distincts donc
         * les cabines doivent etres de objets disctincts pour que le changement de
         * couleur de t2 n'impacte pas t1 Sinon t1 et t2 ont la meme reference Tracteur
         * t2 = t1;
         */

        // ==> Correction
        test(t1, t2);
        // tests effectues afin d'essayer les classes roue et cabines
        /*
         * System.out.println("Grande roue 1 : " + r1.toString());
         * System.out.println("Grande roue 2 : " + r2.toString());
         * System.out.println("Petite roue 1 : " + pr1.toString());
         * System.out.println("Petite roue 2 : " + pr2.toString());
         * System.out.println(c.toString());
         */

    }
}