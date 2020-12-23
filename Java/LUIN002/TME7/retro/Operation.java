public abstract class Operation extends Expression{
    protected Valeur v1;
    protected Valeur v2;

    public Operation(Valeur v1, Valeur v2){
        this.v1 = v1;
        this.v2 = v2;
    }

}