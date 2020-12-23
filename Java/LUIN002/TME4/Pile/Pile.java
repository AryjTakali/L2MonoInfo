
public class Pile {
    private Machin[] mArr;

    public Pile(int size){
        mArr = new Machin[size + 1];
        // for (int i = 0; i < mArr.length; i++){
            // mArr.add(new Machin("Machin nb : " + i, i));
        // }
    }

    @Override
    public String toString(){
        String s = "";
        int i = 0;
        while (i < mArr.length && mArr[i] != null){
            s += mArr[i].getNom() + " de valeur " + mArr[i].getVal() + "\n";
            i++;
        }
        return s;
    }

    public void empiler(Machin m){
        int i = 0;
        while (mArr[i] != null && i < mArr.length){
            i++;
        }
        if (i + 1 != mArr.length)
            mArr[i] = m;
    }

    public Machin depiler(){
        int i = 0;
        while (mArr[i] != null && i < mArr.length){
            i++;
        }
        if (i == 0 || mArr[i-1] == null)
            return null;
        else {
            Machin tmp = mArr[i - 1];
            mArr[i - 1] = null;
            return tmp;
        }
    }
    
    public int getSize(){
        return mArr.length;
    }

    public boolean estVide(){
        for (Machin i : mArr){
            if (i != null)
                return false;
        }
        return true;
    }

    public boolean estPleine(){
        for (Machin i : mArr){
            if (i == null)
                return false;
        }
        return true;
    }
}