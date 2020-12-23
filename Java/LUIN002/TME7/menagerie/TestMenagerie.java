public class TestMenagerie{

    public static void main(String args[]){
        Menagerie m1 = new Menagerie();

        Boa b1 = new Boa(5);
        Canard c1 = new Canard(2);
        Saumon s1 = new Saumon();
        MillePattes mp1 = new MillePattes();
        Vache v1 = new Vache();

        m1.ajouter(b1);
        m1.ajouter(c1);
        m1.ajouter(s1);
        m1.ajouter(mp1);
        m1.ajouter(v1);
        m1.midi();
        System.out.println(m1.toString() + '\n');
        m1.viellirTous();
        System.out.println(m1.toString() + '\n');
        
    }
}