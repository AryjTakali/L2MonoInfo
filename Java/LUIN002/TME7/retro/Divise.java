public class Divise extends Operation{
    
    public Divise(Valeur v1, Valeur v2){
        super(v1, v2);
    }

    public double getVal(){
        return v1.getVal() / v2.getVal();
    }
}