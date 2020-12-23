
class TestAttrapePas1{

    public static void main(String[] args){
      try{
          System.out.println("La moyenne est de " + moyenne(args));
      } catch(AucuneNoteEntiereException e) {
            System.out.println(e.getMessage() + " " + e);
      }
    }

    public static int moyenne(String[] tab) throw AucuneNoteEntiereException{
        int note;
        int somme = 0;
        int nb_notes = 0;

            
        for(int i = 0; i < tab.length; i++){
            try{
                note = Integer.parseInt(tab[i]);
                somme += note;
                nb_notes++;
            } catch(NumberFormatException nfe){
            System.out.println("Exception : Invalid argument : " + nfe.getMessage());
            }
        }
        if (nb_notes == 0){
            throw new AucuneNoteEntiereException();
        }
        return (somme/nb_notes);
    }
}