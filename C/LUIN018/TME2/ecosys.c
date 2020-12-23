#include "ecosys.h"

//return 1 si c'est vrai 0 sinon avec une probabilite de prob
static int probabilite(float prob){
  return rand() % 100 < prob * 100;
}

/* PARTIE 1*/
/* Fourni: Part 1, exercice 3, question 2 */
Animal *creer_animal(int x, int y, float energie)
{
  Animal *na = (Animal *)malloc(sizeof(Animal));
  assert(na);

  na->x = x;
  na->y = y;
  na->energie = energie;
  na->dir[0] = rand() % 3 - 1;
  na->dir[1] = rand() % 3 - 1;
  na->suivant = NULL;

  return na;
}

/* Fourni: Part 1, exercice 3, question 3 */
Animal *ajouter_en_tete_animal(Animal *liste, Animal *animal)
{
  assert(animal);
  assert(animal->suivant == NULL);
  animal->suivant = liste;
  return animal;
}

/* A faire. Part 1, exercice 5, question 1 */
void ajouter_animal(int x, int y, float energie, Animal **liste_animal)
{
  assert(x >= 0 && x < SIZE_X && y >= 0 && y < SIZE_Y);
  *liste_animal = ajouter_en_tete_animal(*liste_animal, creer_animal(x, y, energie));
}

/* A Faire. Part 1, exercice 5, question 5 */
void enlever_animal(Animal **liste, Animal *animal)
{
  assert(liste); // on verifie que la liste existe bien
  if (!animal) // si animal n'existe pas il n'y a rien a enlever
    return;
  Animal *tmp; // variable temporaire qui permet de stocker des adresses si besoin
  
  if ((*liste) == animal){//le cas ou le premier element est = a animal est particulier
      tmp = (*liste)->suivant; //il suffit de changer de premier element de la liste
      free(*liste);// et free l'animal a enlever
      (*liste) = tmp;
      return; //permet de finir la fonction car l'objectif est accompli
  } 
  while (*liste){
    if ((*liste)->suivant && (*liste)->suivant == animal){ //on verifie si l'element suivant est celui recherché
      tmp = (*liste)->suivant->suivant; //si c'est l'element recherché on stocke l'adresse de l'element qui le suit 
      free((*liste)->suivant);
      (*liste)->suivant = tmp; // une fois l'animal enlevé on lie la suite de la liste a l'element actuel
      return; 
    }
    *liste = (*liste)->suivant;
  }
}

/* A Faire. Part 1, exercice 5, question 2 */
Animal *liberer_liste_animaux(Animal *liste)
{
  Animal *tmp;
  while (liste != NULL)
  {
    tmp = liste->suivant;//on stock l'adresse de l'element suivant 
    free(liste); // on libere l'element actuel  
    liste = tmp; //on avance
  }
  return NULL;
}

/* Fourni: part 1, exercice 3, question 4 */
unsigned int compte_animal_rec(Animal *la)
{
  if (!la)
    return 0;
  return 1 + compte_animal_rec(la->suivant);
}

/* Fourni: part 1, exercice 3, question 4 */
unsigned int compte_animal_it(Animal *la)
{
  int cpt = 0;
  while (la)
  {
    ++cpt;
    la = la->suivant;
  }
  return cpt;
}

/* Part 1. Exercice 4, question 1 */

void	up_enclot(){//fonction qui print le haut d'un enclot 
    printf("+");
    for (int i = 0; i < SIZE_Y; i++){
    	printf("%c",'-');
    }
    printf("+\n");
}

void afficher_ecosys(Animal *liste_proie, Animal *liste_predateur)
{
  char ecosys[SIZE_X][SIZE_Y + 1];

  /* on initialise le tableau */
  for (int i = 0; i < SIZE_X; i++){
    for (int j = 0; j < SIZE_Y; j++){
      ecosys[i][j] = ' ';
    }
     ecosys[i][SIZE_Y] = '\0'; //securité qui me permet de terminer chaque ligne par un \0 -> pour pouvoir faire des printf %s de chaque ligne
  }

  /* on ajoute les proies */
  while (liste_proie != NULL){ // on parcours la liste et on met le caractere correspondant aux proies dans ecosys
    ecosys[liste_proie->x][liste_proie->y] = '*';
    liste_proie = liste_proie->suivant;
  }

  /* on ajoute les predateurs */
    while (liste_predateur != NULL){
      //cette condition permet de placer un caractere different si une proie est sur la case
       if (ecosys[liste_predateur->x][liste_predateur->y] == '*')
         ecosys[liste_predateur->x][liste_predateur->y] = '@';
       else
        ecosys[liste_predateur->x][liste_predateur->y] = 'O';
      liste_predateur = liste_predateur->suivant;
    }

  /* on affiche le tableau */
  	up_enclot();
    for (int i = 0; i < SIZE_X; i++)
        printf("|%s|\n", ecosys[i]);
	  up_enclot();
}

void clear_screen()
{
  printf("\x1b[2J\x1b[1;1H"); /* code ANSI X3.4 pour effacer l'ecran */
}

/* PARTIE 2*/

/* Part 2. Exercice 5, question 1 */
void bouger_animaux(Animal *la)
{
  while(la){
    //Il faut checker que l'animal soit dans la map sinon apparait de l'autre coté
    if (la->x + la->dir[0] < SIZE_X && la->x + la->dir[0] >= 0)
      la->x+=la->dir[0];
    else
      la->x= la->x + la->dir[0] >= SIZE_X ? 0 : SIZE_X - 2;//size_x = '\0'
    if (la->y + la->dir[1] < SIZE_Y && la->y + la->dir[1] >= 0)
      la->y+=la->dir[1];
    else
      la->y= la->y + la->dir[1] >= SIZE_Y ? 0 : SIZE_Y - 2;//size_y = '\0'
    la = la->suivant;
  }
}


/* Part 2. Exercice 5, question 3 */
void reproduce(Animal **liste_animal, float p_reproduce)
{
  Animal *liste = *liste_animal;
  while(liste != NULL){
    if (probabilite(p_reproduce)){
      *liste_animal = ajouter_en_tete_animal(*liste_animal, creer_animal(liste->x, liste->y, liste->energie / 2.0));
      liste->energie = liste->energie / 2.0;
    }
    liste = liste->suivant;
  }
}

/* Part 2. Exercice 7, question 1 */
void rafraichir_proies(Animal **liste_proie, int monde[SIZE_X][SIZE_Y])
{
  bouger_animaux(*liste_proie);
  Animal *cur = *liste_proie;
  while (cur){
    cur->energie--;
    assert(cur->x >= 0 && cur->x < SIZE_X && cur->y >= 0 && cur->y < SIZE_Y);
    if (monde[cur->x][cur->y] > 0){
      cur->energie += gain_energie_proie;
      monde[cur->x][cur->y] = temps_repousse_herbe;
    }
    if (cur->energie <= 0)
      enlever_animal(liste_proie, cur);
    cur = cur->suivant;
  }
  reproduce(liste_proie, p_reproduce_proie);
}

/* Part 2. Exercice 8, question 1 */
Animal *animal_en_XY(Animal *l, int x, int y)
{
  while (l){
    if(l->x == x && l->y == y)
      return l;
    l = l->suivant;
  }
  return NULL;
}

/* Part 2. Exercice 8, question 2 */
void rafraichir_predateurs(Animal **liste_predateur, Animal **liste_proie)
{
  bouger_animaux(*liste_predateur);
  Animal *cur = *liste_predateur;
  Animal *eaten = NULL;
  while (cur){
    cur->energie--;
    assert(cur->x >= 0 && cur->x < SIZE_X && cur->y >= 0 && cur->y < SIZE_Y);
    if ((eaten = animal_en_XY(*liste_proie, cur->x, cur->y)) != NULL && probabilite(p_manger)){
      cur->energie += gain_energie_predateur;
      enlever_animal(liste_proie, eaten);
    }
    if (cur->energie <= 0)
      enlever_animal(liste_predateur, cur);
    cur = cur->suivant;
  }
  reproduce(liste_predateur, p_reproduce_predateur);
}

/* Part 2. Exercice 6, question 2 */
void rafraichir_monde(int monde[SIZE_X][SIZE_Y])
{
   for (int i = 0; i < SIZE_X; i++){
    for (int j = 0; j < SIZE_Y; j++){
      monde[i][j] += 1;
    }
  }
}
