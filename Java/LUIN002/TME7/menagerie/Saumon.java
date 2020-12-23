public class Saumon extends AnimauxSansPattes{
    
    public Saumon(){
        super("Saumon");
    }

    public Saumon(int age){
        super("Saumon", age);
    }

    public void crier(){
        System.out.println("blupblupblubp");
    }
}