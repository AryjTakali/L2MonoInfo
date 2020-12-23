public class TestAttrapePas2 {
    
    public static int moyenne(String[] notes) throws NumberFormatException {
        int moyenne = 0;
        int nb = 0;

        if(notes.length == 0)
            return 0;

        for(String note : notes) {
            moyenne += Integer.parseInt(note);
            nb++;
        }
        
        return moyenne / nb;
    }

    public static void main(String[] args) {

        try {
            System.out.println("La moyenne est de " + moyenne(args));
        }
        catch (NumberFormatException e) {
            System.out.println("<< La note n'est pas entière >>");
        }
    }
}