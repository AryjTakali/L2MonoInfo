import java.util.ArrayList;

public class Mer{
    private ArrayList<Submarine> nageurs;

    public Mer(){
        nageurs = new ArrayList<>();

    }

    public void ajouter(Submarine sub){
        nageurs.add(sub);
    }

    public void deplacer(){
        for(Submarine sub : nageurs){
            sub.seDeplacer();
        }
    }
}