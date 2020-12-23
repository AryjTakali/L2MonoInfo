class TestPersonne{

    public static void main( String [ ] args ) {

    Personne p = new Personne("Albert") ; 
    p.ajouterEnfant () ;
    p.prime() ;//Personne n'a pas de methode prime
    p.estEnL2() ;//personne n'a pas de methode estenL2
    Etudiant e = new Etudiant("Ahmed",null,"L2"); 
    e.ajouterEnfant () ;
    e.prime () ; //etudiant ne possede pas de methode prime
    e.estEnL2 () ;
    Salarie s1 = new Salarie ("Amelle") ;
    Salarie s2 = new Salarie ("Pauline" ,"0122334455") ; //pas de contructeur avec num tel
    Salarie s3 = new Salarie ("Yves" ,"0123401234" ,2000) //same manque num
 }
}