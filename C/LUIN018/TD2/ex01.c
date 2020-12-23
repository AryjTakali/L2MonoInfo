#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

typedef struct _elt Elt; 
struct _elt{
int donnee;
  Elt *suivant;
};


int main() {
	int taille=10; Elt *liste=NULL; Elt *nelt=NULL; int i=0;

	for (i=0;i<taille;i++) {
		 	nelt=malloc(sizeof(Elt));
			if (nelt == NULL) {
					printf("Erreur lors de l’allocation.\n"); 
					return 0;
			}
			nelt->donnee=i; 
			nelt->suivant=liste; liste=nelt;
	}
	nelt=liste;
	while (nelt) {
			printf("%d ",nelt->donnee);
			nelt=nelt->suivant;
	}
	printf("\n");
	nelt=liste;
	while (nelt) {
			free(nelt);
			nelt=nelt->suivant;
	}
	printf("\nApres la suppression:");
	while (nelt) {
			printf("%d ",nelt->donnee);
			nelt=nelt->suivant;
	}
	return 0;
}
