class Salarie extends Personne{
    private double salaire;

    public Salarie(String nom, double salaire){
        super(nom);
        this.salaire = salaire;
    }

    public int getSalaire(){
        return salaire;
    }

    public double Prime(){
        return 0.05*nbEnfants;
    }

    public void modifierNumTel(String numTel){
        this.numTel=numTel;
        System.out.println("Le salarie " + nom + " a pour numero " + numTel);
    }
}