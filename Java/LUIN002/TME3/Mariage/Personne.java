public class Personne {
    private String nom;
    private Personne conjoint;

    public Personne(String nom) {
        this.nom = nom;
        conjoint = null;
    }

    public Personne() {
        this("pers");
        nom = nom + tirageLettre() + tirageLettre() + tirageLettre();
    }

    public String toString() {
        return nom + ", " + getStatus();
    }

    public String getStatus() {
        if (conjoint != null) {
            return ("marié");
        } else {
            return ("célibataire");
        }
    }

    public boolean getEstMarie() {
        return conjoint != null;
    }

    public void epouser(Personne p) {
        if (p == null || p == this || conjoint != null || p.getEstMarie() == true)
            System.out.println("Ce marriage est impossible!");
        else {
            System.out.println(toString() + " et " + p.toString() + " se marient");
            conjoint = p;
            p.conjoint = this;
        }
    }

    public void divorcer() {
        if (conjoint != null) {
            System.out.println(toString() + " divorce de " + conjoint.toString());
            if (conjoint.conjoint != null)
                conjoint.conjoint = null;
            conjoint = null;
        }
    }

    private char tirageLettre() {
        return ((char) ((int) ((Math.random() * 26) + 'A')));
    }
}
