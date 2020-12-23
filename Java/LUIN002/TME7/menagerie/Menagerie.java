public class Menagerie{
    private Animal[] tab;

    public Menagerie(int taille){
        tab = new Animal[taille];
    }

    public Menagerie(){
        this(10);
    }

    public void ajouter(Animal a){
        int i = 0;
        while(i < tab.length){
            if (tab[i]  == null){
                System.out.println(a.toString() + " a ete ajoute a la Menagerie.");
                tab[i] = a;
                return;
            }
            i++;
        }
        if (i == tab.length)
            System.out.println(a.toString() + " n'a pas pu etre ajoute a la Menagerie car elle est pleine.");
    }

    public void viellirTous(){
        System.out.println("Les animaux vieillissent tous d'un an.");
        int i = 0;
        while(i < tab.length && tab[i] != null){
            tab[i].vieillir();
            i++;
        }
    }
    public void midi(){
        System.out.println("Il est midi !");
        int i = 0;
        while(i < tab.length && tab[i] != null){
            tab[i].crier();
            i++;
        }
        if (i == 0)
            System.out.println("La menagerie est vide.");
    }

    public String toString(){
        String ret = "La menagerie est composé de : \n";
        int i = 0;
        while(i < tab.length && tab[i] != null){
            ret += i + " - " + tab[i].toString() + '\n';
            i++;
        }
        if (i == 0)
            ret = "La menagerie est vide.";
        return ret;
    }
    
}