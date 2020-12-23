class TestOrchestre{


    public static void main(String args[]){
        Orchestre o1 = new Orchestre(4);
        Guitare g1 = new Guitare();
        Piano p1 = new Piano();
        Trompette t1 = new Trompette();
        Batterie b1 = new Batterie();

        o1.ajouterInstrument(g1);
        o1.ajouterInstrument(p1);
        o1.ajouterInstrument(t1);
        o1.ajouterInstrument(b1);
        o1.ajouterInstrument(t1);
        o1.jouer();
        System.out.println(o1.toString());
        o1.plusCher();
        o1.plusLourd();
    }
}