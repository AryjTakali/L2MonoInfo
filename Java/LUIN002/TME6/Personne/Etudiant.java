public class Etudiant extends Personne {
    private String cursus;

    public Etudiant(String n, String t, String c) {
        super(n, t);
        cursus = c;
    }

    public boolean estEnL2() {
        return cursus.equals("L2");
    }

    public void afficherInfo(){
        System.out.println("Nom :"+ nom);
        System.out.println("NumTel :"+ numTel);
        System.out.println("NbEnfants :"+ nbEnfants); //ne compile pas car private
        System.out.println("Cursus :"+ cursus);
    }
    
    public void modifierInfo(){
        //nom="Toto"; compile pas car nom est final
        numTel="012030405";
        nbEnfants=-1;//private pour ne pas faire de betises de ce genre 
        cursus="L0";
    }
}