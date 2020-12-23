public class TestSubmarine{

    public static void main(String args[]){
        Mer mer = new Mer();
        Merlu m = new Merlu(); 
        Dauphin d = new Dauphin(); 
        SousMarin sm = new SousMarin();
        ChatSub cs = new ChatSub();
        mer.ajouter(m);
        mer.ajouter(d);
        mer.ajouter(sm);
        mer.ajouter(cs);
        mer.deplacer();
    }
}