#include "ecosys.h"

#define NB_PROIES 20
#define NB_PREDATEURS 20
#define T_WAIT 40000

    /* Parametres globaux de l'ecosysteme (externes dans le ecosys.h)*/
const float p_ch_dir=0.01;
const int gain_energie_proie=10;
const int gain_energie_predateur=20;
const float p_reproduce_proie=0.4;
const float p_reproduce_predateur=0.3;
const int temps_repousse_herbe = -15; 
const float p_manger = 1;

static void  noGnu(){

  int map[SIZE_X][SIZE_Y];
  for (int i = 0; i < SIZE_X; i++){
    for (int j = 0; j < SIZE_Y; j++){
      map[i][j] = 0;
    }
  }

  Animal *proies = NULL;
  Animal *predateurs = NULL;

  for (int i = 0; i < NB_PROIES; i++)
    proies = ajouter_en_tete_animal(proies, creer_animal(rand() % SIZE_X, rand() %SIZE_Y, 5.));
  for (int i = 0; i < NB_PREDATEURS; i++)
    predateurs = ajouter_en_tete_animal(predateurs, creer_animal(rand() % SIZE_X, rand() %SIZE_Y, 5.));
  int cpt = 0;
   
  printf("Start - il y a %d proies et %d predateurs\n", compte_animal_it(proies), compte_animal_it(predateurs));
  afficher_ecosys(proies, predateurs); // le premier param affiche *, le deuxieme O
  while (++cpt < 100){
    rafraichir_monde(map);
    rafraichir_proies(&proies, map);
    rafraichir_predateurs(&predateurs, &proies);
    usleep(T_WAIT);
    if(proies == NULL && predateurs == NULL)
      break;
  }
  printf("Finish - %d iteration : il y a %d proies et %d predateurs\n", cpt, compte_animal_it(proies), compte_animal_it(predateurs));
  afficher_ecosys(proies, predateurs); // le premier param affiche *, le deuxieme O
}


static void  avecGnu(FILE *f){

  int map[SIZE_X][SIZE_Y];
  for (int i = 0; i < SIZE_X; i++){
    for (int j = 0; j < SIZE_Y; j++){
      map[i][j] = 0;
    }
  }

  Animal *proies = NULL;
  Animal *predateurs = NULL;

  for (int i = 0; i < NB_PROIES; i++)
    proies = ajouter_en_tete_animal(proies, creer_animal(rand() % SIZE_X, rand() %SIZE_Y, 5.));
  for (int i = 0; i < NB_PREDATEURS; i++)
    predateurs = ajouter_en_tete_animal(predateurs, creer_animal(rand() % SIZE_X, rand() %SIZE_Y, 5.));
  int cpt = 0;
   
  printf("Start - il y a %d proies et %d predateurs\n", compte_animal_it(proies), compte_animal_it(predateurs));
  fprintf(f, "%d %d %d\n", cpt, compte_animal_it(proies), compte_animal_it(predateurs));
  afficher_ecosys(proies, predateurs); // le premier param affiche *, le deuxieme O
  while (++cpt < 100){
    rafraichir_monde(map);
    rafraichir_proies(&proies, map);
    rafraichir_predateurs(&predateurs, &proies);
    usleep(T_WAIT);
    fprintf(f, "%d %d %d\n", cpt, compte_animal_it(proies), compte_animal_it(predateurs));
    if (proies == NULL && predateurs == NULL)
      break;
  }
  printf("Finish - %d iteration : il y a %d proies et %d predateurs\n", cpt, compte_animal_it(proies), compte_animal_it(predateurs));
  afficher_ecosys(proies, predateurs); // le premier param affiche *, le deuxieme O
}

//si le nombre de parametre est egal a 2 alors on ecrira l'evolution du nb de proies et predateur 
// il sera alors possible de modeliser cela sur gnuplot 
//sinon on  affichera juste la position de depart de l'ecosysteme et de sa fin
int main(int ac, char **av) {
 
  srand(time(NULL));

  if (ac < 2)
    noGnu();
  else if (ac == 2){
    FILE *f = fopen(av[1], "w");
    assert(f);
    avecGnu(f);
    fclose(f);
  }
  //  * exercice 9, question 1

  return 0;
}

