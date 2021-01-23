public abstract class Operation extends Expression{
    protected double v1;
    protected double v2;


    public Operation(double v1, double v2){
        this.v1 = v1;
        this.v2 = v2;
    }

    public Operation(Expression v1, Expression v2){
        this(v1.getVal(), v2.getVal());
    }
    
    public abstract double getVal();
}