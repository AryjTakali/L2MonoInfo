public abstract class AnimauxAPattes extends Animal{
    public final int nbPattes;

      public AnimauxAPattes(String nom, int nbPattes, int age){
        super(nom, age);
        this.nbPattes = nbPattes;
    }
    
    public AnimauxAPattes(String nom, int nbPattes){
        this(nom, nbPattes, 1);
    }
  
    public abstract void crier();

    public String toString(){
        return super.toString() + " est un animal a " + nbPattes + " pattes.";
    }
}