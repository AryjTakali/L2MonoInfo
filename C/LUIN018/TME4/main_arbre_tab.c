#include <stdlib.h>
#include <stdio.h>
#include "arbre_lexicographique_tab.h"

int   main(int ac, char **av)
{
  if (ac != 3){
    printf("Usage : ./main_arbre <nb_repet> <mot>");
    return -1;
  }

  int nb_search = atoi(av[1]);
  PNoeudTab abrTab = lire_dico("french_za");

  for(int i = 0; i < nb_search; i++){
     rechercher_mot(abrTab, av[2]);
  }
  // afficher_dico(abrTab);
  detruire_dico(abrTab);

  return 0;
}
