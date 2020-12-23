import java.util.ArrayList;

/*ma premiere version de l'exercice a ete avec les Array 
je n'avais pas tres bien compris a consigne 
mais ca m'a permis de comprendre l'utilisation des ArrayList*/

public class PileArray {
    private ArrayList<Machin> mArr;

    public PileArray(int size){
        mArr = new ArrayList<Machin>();
        for (int i = 0; i < mArr.size(); i++){
            mArr.add(new Machin("Machin nb : " + i, i));
        }
    }

    public void empiler(Machin m){
        if (mArr != null){
            mArr.add(new Machin("Machin nb : " + mArr.size()));
        }
    }

    public Machin depiler(){
        if (mArr.size() != 0){
            Machin tmp = mArr.get(mArr.size());
            mArr.remove(mArr.size());
            return tmp;
        }
        return null;
    }
    public int getSize(){
        return mArr.size();
    }
    public boolean estVide(){
        return mArr.size() == 0;
    }
    public boolean estPleine(){
        return mArr.size() != 0;
    }
}