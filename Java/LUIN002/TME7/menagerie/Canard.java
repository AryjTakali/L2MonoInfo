public class Canard extends AnimauxAPattes{

  public Canard(){
        super("Canard", 2);
    }

    public Canard(int age){
        super("Canard", 2, age);
    }

    public void crier(){
        System.out.println("CoinnnCoin");
    }
}