#include <stdio.h>
#include <stdlib.h>
#include "arbre_lexicographique.h"


int   main(int ac, char **av)
{
  if (ac != 3){
    printf("Usage : ./main_arbre <nb_repet> <mot>");
    return -1;
  }

  int nb_search = atoi(av[1]);
  PNoeud abrLex = lire_dico("french_za");

  for(int i = 0; i < nb_search; i++){
     rechercher_mot(abrLex, av[2]);
  }
  // afficher_dico(abrLex);
  detruire_dico(abrLex);

  return 0;
}
