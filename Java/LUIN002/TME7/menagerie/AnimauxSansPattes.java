public abstract class AnimauxSansPattes extends Animal{

      public AnimauxSansPattes(String nom, int age){
        super(nom, age);
    }
    
    public AnimauxSansPattes(String nom){
        this(nom, 1);
    }
  
    public abstract void crier();

    public String toString(){
        return super.toString() + " est un animal sans pattes.";
    }
}