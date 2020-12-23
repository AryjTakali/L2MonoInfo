class TestVehicule{

    public static void  testVelo(){
        Velo v1 = new Velo(5);
        Velo v2 = new Velo(12);

        v1.transporter("Dijon", "Amsterdam");
        v2.transporter("Paris", "Amsterdam");
        System.out.println(v1.toString());
        System.out.println("\nLe velo 1 roule 200km");
        System.out.println("\nLe velo 2 roule 100km");
        v1.rouler(200);
        v2.rouler(100);
        System.out.println(v1.toString());
        System.out.println(v2.toString());
    }

   public static void  testAmoteur(){
        Voiture v1 = new Voiture(5);
        Voiture v2 = new Voiture(7);
        Camion c1 = new Camion(10);
        Camion c2 = new Camion(17);

        System.out.println(v1.toString());
        System.out.println(c1.toString());
        v1.Approvisionner(10);
        v1.transporter(6, 100);
        System.out.println("Vehicule " + v1.myNumId + " : distance parcouru " +  v1.getDistance());
        c2.transporter("anis", 50);
        c2.Approvisionner(10);
        c2.transporter("anis", 50);
        System.out.println("Vehicule " + c2.myNumId + " : distance parcouru " +  c2.getDistance());
    } 

   //on remarque que le compteur numId prend en compte toutes les instances 
   //qu'il s'agisse de Amoteur ou SansMoteur 
    public static void main(String args[]){
        testVelo();
        testAmoteur();

    }
}