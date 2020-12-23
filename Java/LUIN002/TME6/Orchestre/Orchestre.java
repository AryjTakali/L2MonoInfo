class Orchestre{
    private Instrument[] groupe;
    static protected int nbInstrument = 0;

    public Orchestre(int nbMaxInstrument){
        groupe= new Instrument[nbMaxInstrument + 1];
    }

    public void ajouterInstrument(Instrument i){
        if (nbInstrument + 1 < groupe.length){
            int index = 0;
            while (groupe[index] != null && index < groupe.length)
                index++;
                groupe[index] = i;
                nbInstrument++;
        } else{
            System.out.println("L'Orchestre est plein.\n");
        }
    }

    public void jouer(){
        int i = 0;

        while (groupe[i] != null){
            groupe[i].jouer();
            i++;
        }
    }

    public void plusLourd(){
        int heavier = 0;
        int i = 0;
        if (nbInstrument == 0)
            System.out.println("L'Orchestre est vide, il n'y a pas d'instrument le plus lourd.\n");
        while (i < groupe.length && i < nbInstrument){
            if (groupe[i].getPoids() > groupe[heavier].getPoids())
                heavier = i;    
            i++;    
        }
        System.out.println("L'instrument le plus lourd de l'Orchestre est : " + groupe[heavier].getInstruName());
        System.out.println("Il pese : " + groupe[heavier].getPoids() + "kg");
    }

    public void plusCher(){
        int expensive = 0;
        int i = 0;
        if (nbInstrument == 0)
            System.out.println("L'Orchestre est vide, il n'y a pas d'instrument le plus cher.\n");
        while (i < groupe.length && i < nbInstrument){
            if (groupe[i].getPrix() > groupe[expensive].getPrix())
                expensive = i;    
            i++;    
        }
        System.out.println("L'instrument le plus cher de l'Orchestre est : " + groupe[expensive].getInstruName());
        System.out.println("Il coute : " + groupe[expensive].getPrix()+ "$");
    }

    public String toString(){
        String s = "\nL'Orchestre est composé de : \n";
        try{
        int i = 0;
        while (i < groupe.length && i < nbInstrument){
            s += groupe[i].getInstruName() + " " + groupe[i].toString() + "\n";
            //la methode Objec.getClass permet d'avoir un comportement similaire a l'effet chercher
            // s += groupe[i].getClass() + " " + groupe[i].toString() + "\n";
            i++;
        }
        }catch(RuntimeException e){
            System.out.println(e);
        }
        return s;
    }
}