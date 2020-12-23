public abstract class Animal{
    public final String nom;
    private int age;

    public Animal(String nom, int age){
        this.nom = nom;
        this.age = age;
    }
    
    public Animal(String nom){
        this.nom = nom;
        this.age = 1;
    }
    
    public void vieillir(){
        age++;
    }

    public abstract void crier();

    public String toString(){
        return "nom  : " + nom + " age : " + age;
    }
}