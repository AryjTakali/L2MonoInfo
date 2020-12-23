#include <stdio.h>
#include <stdlib.h>
#include "liste.h"
#include "abr.h"

int main(int ac, char **av)
{
  if (ac != 3){
    printf("Usage : ./main_abr <nb_repet> <mot>");
    return -1;
  }

  int nb_search = atoi(av[1]);
  Nd_mot *abr = Lm2abr(lire_dico_Lmot("french_za"));

    // printf("%s", chercher_Nd_mot(abr, av[2])->mot);
  for(int i = 0; i < nb_search; i++){
    chercher_Nd_mot(abr, av[2]);
  }
  detruire_abr_mot(abr);

  return 0;
}
