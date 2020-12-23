public class Alea{

    private Alea(){}
    public static char lettre(){
        return (char)((Math.random()*('z'-'a' + 1)) + 'a');
    }

    public static String chaine(){
        String res = "";
        for (int i = 0; i < 10; i++){
            res += lettre();
        }
        return res;
    }

    public static void main(String args[]){
        System.out.println(chaine());
    }
}