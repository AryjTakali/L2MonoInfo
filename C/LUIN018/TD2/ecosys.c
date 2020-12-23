#include "ecosys.h"


Animal  *creer_animal(int x, int y, float energie){
    Animal *animal ;
    srand(time(NULL));
    assert((animal = malloc(sizeof(Animal) * 2)) != NULL);

    animal->x = x;    
    animal->y = y;    
    animal->energie = energie;
    animal->dir[0] = rand() % 3 - 1;
    animal->dir[1] = rand() % 3 - 1;
    animal->suivant = NULL;

    return (animal);
}

Animal *ajouter_en_tete_animal(Animal *liste, Animal *animal){
    assert(animal != NULL);
    assert(animal->suivant == NULL);
    animal->suivant = liste;
    return (animal);
}

unsigned int     compte_animal_it(Animal *zemel){
    int i = 0;

    while (zemel != NULL){
        zemel = zemel->suivant;
        i++;
    }
    return (i);
}

unsigned int     compte_animal_rec(Animal *zemel){
     if (zemel == NULL)
        return 0;
    else
        return (1 + compte_animal_rec(zemel->suivant));
}

void    afficher_liste(Animal *a1){
   while (a1!= NULL){
        printf("%d\n", a1->x);
        a1 = a1->suivant;
    } 
}

char    **init(){
    char **enclot;
    int i = 0;
    int j = 0;
    assert ((enclot = malloc(sizeof(char*) * (SIZE_Y + 1))) != NULL);
    while (i < SIZE_Y){
        assert ((enclot[i] = malloc(sizeof(char) * (SIZE_X + 1))) != NULL);
        j = 0;
        while (j < SIZE_X){
        	enclot[i][j] = ' ';
            j++;
        }
        enclot[i][j] = '\0';
        i++;
    }
    enclot[SIZE_Y] = NULL;
    return (enclot);
}

void	up_enclot(){
    printf("+");
    for (int i = 0; i < SIZE_X; i++){
    	printf("%c",'-');
    }
    printf("+\n");
}


void    show_enclot(char **enclot){
    int i = 0;

	up_enclot();
    while (enclot[i] != NULL){
        printf("|%s|\n",enclot[i]);
        i++;
    }
	up_enclot();
}

void    ajout_enclot(char **enclot, Animal *animaux, char c){
    while (animaux != NULL){
        if (enclot[animaux->y][animaux->x] != c && enclot[animaux->y][animaux->x] != ' ')
            enclot[animaux->y][animaux->x] = '@';
        else
            enclot[animaux->y][animaux->x] = c;
        animaux = animaux->suivant;
    }
}

void    remplir_enclot(char **enclot, Animal *proies, Animal *predateur){
    ajout_enclot(enclot, proies, '*');
    ajout_enclot(enclot, predateur, 'O');
}


int main(){
    Animal *a1 = creer_animal(1,3,1.0);
    Animal *a2 = creer_animal(2,2,1.0);
    Animal *a3 = creer_animal(3,1,1.0);
    Animal *p1 = creer_animal(1,2,1.0);
    Animal *p2 = creer_animal(3,1,1.0);
    char **enclot = init();


    a1 = ajouter_en_tete_animal(a1, a2);
    a1 = ajouter_en_tete_animal(a1, a3);
    p1 = ajouter_en_tete_animal(p1, p2);
    printf("%d - %d\n", compte_animal_rec(a1), compte_animal_it(a1));

    show_enclot(enclot);
    remplir_enclot(enclot, a1, p1);
    show_enclot(enclot);
    
}
