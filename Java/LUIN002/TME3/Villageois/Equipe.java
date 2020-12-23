public class Equipe{
    private String nom;
    private Villageois[] team;
    private int nbV;

    public Equipe(String nom){
        this.nom = nom;
        team = new Villageois[21];
        nbV = 0;
    }

    public void embaucher(Villageois v){
        int i = 0;
        while (team[i] != null && i < team.length)
            i++;
        if (nbV < team.length){
            team[i] = v;
            nbV++;
        }
    }

    public void embaucher(Equipe e){
        int i = 0, j = 0;
        while (team[i] != null && i < team.length)
            i++;
        while (e.team[j] != null && nbV < team.length){
            team[i + j] = e.team[j];
            j++;
            nbV++;
        }
    }

    public double poidsSouleve(){
        double ret = 0;

        for (int i = 0; i < team.length; i++){
            if (team[i] != null)
                ret += team[i].poidsSouleve();
            else
                return ret;
        }
        return ret;
    }

    public boolean peutSoulever(double n){
        return poidsSouleve() >= n; 
    }

    public String toString(){
        String s = "L'equipe " + nom + " contient les villageaois :\n";
        for (int i = 0; i < team.length; i++){
            if (team[i] != null)
                s += team[i].toString();
            else
                break;
        }
        s += "L'equipe souleve un poids total de " + poidsSouleve() + "kg\n";
        return s;
    }
}