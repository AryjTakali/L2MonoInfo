public class Moins extends Operation{

   public Moins(Expression v1, Expression v2){
        super(v1, v2);
    }


   public double getVal(){
        return v1 - v2;
    }
}