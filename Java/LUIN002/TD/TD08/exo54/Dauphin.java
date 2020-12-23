class Dauphin extends Mammifere 
    implements Submarine,Echolocation{
     
    public Dauphin(){}
    
    public void seDeplacer(){
        System.out.println("Comme un dauphin dans l'eau!");
    }

    public void envoyerSon(){
        System.out.println("Comme un dauphin DJ!");
    }

    public void ecouterSon(){
        System.out.println("Comme un dauphin audiophile!");
    }
}