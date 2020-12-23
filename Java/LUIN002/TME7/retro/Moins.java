public class Moins extends Operation{

   public Moins(Valeur v1, Valeur v2){
        super(v1, v2);
    }


   public double getVal(){
        return v1.getVal() - v1.getVal();
    }
}