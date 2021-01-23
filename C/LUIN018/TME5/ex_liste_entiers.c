
#include <stdlib.h>
#include "liste.h"
#include "devel.h"
#include "fonctions_entiers.h"

int main(void) {

  PListe nbList = malloc(sizeof(PListe));
  nbList->dupliquer = &dupliquer_int;
  nbList->copier = &copier_int;
  nbList->detruire = &detruire_int;
  nbList->afficher = &afficher_int;
  nbList->comparer = &comparer_int;
  nbList->ecrire = &ecrire_int;
  nbList->lire = &lire_int;
  int test = 42;
  inserer_debut(nbList, &test);
  afficher_liste(nbList);
  detruire_liste(nbList);
  // inserer_debut(nbList->elements, test);
/*  for(int i = 0; i <= 10; i++){
    if (i < 5)
      inserer_debut(nb_list, &i);
    else if (i > 5)
      inserer_fin(nb_list, i);
  }
  // inserer_place(nb_list, 5);
  afficher_liste(nb_list);
  detruire_liste(nb_list);
  */
 return 0;
}
