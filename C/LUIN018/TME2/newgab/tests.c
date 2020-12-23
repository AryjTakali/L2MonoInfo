#include "ecosys.h"


#define NB_PROIES 20
#define NB_PREDATEURS 20

void static show(Animal *la){

  while (la){
    printf("(%d, %d) : %.2f\n", la->x, la->y, la->energie);
    la = la->suivant;
  }
}

 /* Parametres globaux de l'ecosysteme (externes dans le ecosys.h)*/
const float p_ch_dir=0.01;
const int gain_energie_proie=10;
const int gain_energie_predateur=20;
const float p_reproduce_proie=0.4;
const float p_reproduce_predateur=0.3;
const int temps_repousse_herbe = -15;
const float p_manger = 1;

int main(void) {
    srand(time(NULL));
	Animal *head = NULL;
    Animal *proie1 = creer_animal(0,1,1.0);
    Animal *proie2 = creer_animal(0,2,1.0);
    Animal *proie3 = creer_animal(0,3,1.0);
    Animal *proie4 = creer_animal(0,4,1.0);
    Animal *predateur1 = creer_animal(0,0,1.0);
    Animal *predateur2 = creer_animal(3,1,1.0);
    Animal *predateur3 = creer_animal(4,5,1.0);


    head = ajouter_en_tete_animal(head, proie1);
    head = ajouter_en_tete_animal(head, proie2);
    head = ajouter_en_tete_animal(head, proie3);
    head = ajouter_en_tete_animal(head, proie4);
   predateur1 = ajouter_en_tete_animal(predateur1, predateur2);
   predateur1 = ajouter_en_tete_animal(predateur1, predateur3);
   

    afficher_ecosys(head, predateur1);
  //test enlever animal
  /* printf("Après la creation  :\n");
    printf("il y a %d proies et %d predateurs\n", compte_animal_rec(proie1), compte_animal_it(predateur1));
    afficher_ecosys(head, predateur1);
    enlever_animal(&proie1, proie1);
    enlever_animal(&predateur1, predateur2);
    enlever_animal(&predateur1, predateur1);
    printf("\nAprès avoir enleve  :\n");
    printf("il y a %d proies et %d predateurs\n", compte_animal_rec(proie1), compte_animal_it(predateur1));
    afficher_ecosys(proie1, predateur1);*/

    //test toricité
    /* afficher_ecosys(proie1, predateur1);
    show(predateur1);
    bouger_animaux(predateur1);
    show(predateur1);
    afficher_ecosys(proie1, predateur1);*/

    //test reproduction 
    printf("il y a %d proies et %d predateurs\n", compte_animal_rec(head), compte_animal_it(predateur1));
    show(head);
    enlever_animal(&head, proie1);
    //reproduce(&head, 1);
    printf("il y a %d proies et %d predateurs\n", compte_animal_rec(head), compte_animal_it(predateur1));
    show(proie1);
    afficher_ecosys(proie1, predateur1);

//  nettoyage et free des tableaux
    assert(!(head = liberer_liste_animaux(head)));
    assert(!(predateur1 = liberer_liste_animaux(predateur1)));
    printf("\nAprès nettoyage  :\n");
    printf("il y a %d proies et %d predateurs\n", compte_animal_rec(head), compte_animal_it(predateur1));
    // afficher_ecosys(proie1, predateur1);


  return 0;
}
